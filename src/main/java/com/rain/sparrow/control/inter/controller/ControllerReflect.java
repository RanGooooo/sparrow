package com.rain.sparrow.control.inter.controller;

import com.rain.sparrow.control.inter.annotation.Api;
import com.rain.sparrow.control.inter.annotation.ApiGroup;
import com.rain.sparrow.control.inter.dto.ApiDto;
import com.rain.sparrow.control.inter.dto.ApiGroupDto;
import com.rain.sparrow.control.inter.dto.ApiParameterDto;
import com.rain.sparrow.control.inter.dto.ApiRequestMethodDto;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


@Controller
@RequestMapping("/controllerReflect")
public class ControllerReflect {
    @ResponseBody
    @RequestMapping("getUrlMapping")
    public Map<String,ApiGroupDto> getUrlMapping(HttpServletRequest request) throws Exception {
        Map<String,ApiGroupDto> apiGroupMap = new HashMap<>();
        WebApplicationContext wc = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession().getServletContext());
        RequestMappingHandlerMapping rmhp = wc.getBean(RequestMappingHandlerMapping.class);
        Map<RequestMappingInfo, HandlerMethod> map = rmhp.getHandlerMethods();
        for(RequestMappingInfo info : map.keySet()){
            HandlerMethod handlerMethod = map.get(info);
            Method method = handlerMethod.getMethod();
            Class<?> declaringClass = method.getDeclaringClass();
            ApiGroup apiGroup = declaringClass.getAnnotation(ApiGroup.class);
            if(apiGroup!=null){
                RequestMapping requestMapping = declaringClass.getAnnotation(RequestMapping.class);
                String key = requestMapping.value()[0];
                ApiGroupDto apiGroupDto = apiGroupMap.get(key);
                if(apiGroupDto==null){
                    apiGroupDto = new ApiGroupDto();
                    apiGroupMap.put(key,apiGroupDto);
                    apiGroupDto.setDescription(apiGroup.description());
                    apiGroupDto.setMapping(key);
                }
                ApiDto apiDto = new ApiDto();
                Api api = handlerMethod.getMethodAnnotation(Api.class);
                apiDto.setDescription(api.description());
                apiDto.setMapping(info.getPatternsCondition().toString());
                Set<RequestMethod> requestMethods = info.getMethodsCondition().getMethods();
                for (RequestMethod requestMethod:requestMethods) {
//                    apiDto.setMethod(requestMethod.name());
                    ApiRequestMethodDto apiRequestMethodDto = new ApiRequestMethodDto();
                    apiRequestMethodDto.setName(requestMethod.name());
                    apiRequestMethodDto.setType("success");
                    apiDto.addRequestMethod(apiRequestMethodDto);
                }
                String[] parameterNames = new LocalVariableTableParameterNameDiscoverer().getParameterNames(method);
                for (String parameterName:parameterNames) {
                    ApiParameterDto apiParameterDto = new ApiParameterDto();
                    apiParameterDto.setKey(parameterName);
                    apiDto.addParameter(apiParameterDto);
                }

                apiGroupDto.addApi(apiDto);
            }
        }
        return apiGroupMap;
    }
}

//dto.put("method", handlerMethod.getMethod().getName());
//        Method method = handlerMethod.getMethod();
//        dto.put("className", handlerMethod.getMethod().getDeclaringClass().getName());
//        RequestMethodsRequestCondition methodsCondition = info.getMethodsCondition();
//        for (RequestMethod requestMethod : methodsCondition.getMethods()) {
//        dto.put("type", requestMethod.toString());
//        }
//        PatternsRequestCondition p = info.getPatternsCondition();
//        for (String url : p.getPatterns()) {
//        dto.put("url", url);
//        }



//        for(RequestMappingInfo info : map.keySet()){
//            HandlerMethod handlerMethod = map.get(info);
//            Api methodAnnotation = map.get(info).getMethodAnnotation(Api.class);
//            if(methodAnnotation!=null){
//                Map<String, Object> dto = new HashMap<>();
//                result.add(dto);
//                dto.put("name",methodAnnotation.name());
//                dto.put("mapping",info.getPatternsCondition().toString());
//                MethodParameter[] methodParameters = handlerMethod.getMethodParameters();
//                Method method = handlerMethod.getMethod();
//
//                for (MethodParameter m :methodParameters) {
//
//                    dto.put("methodParamter",m.getParameter().getName());
//                }
//            }
//        }