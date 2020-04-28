package com.rain.sparrow.system.management;

import com.rain.sparrow.common.annotation.mvc.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/controllerReflect")
public class ControllerReflect {
    @ResponseBody
    @RequestMapping("getUrlMapping")
    public List<Map<String, Object>> getUrlMapping(HttpServletRequest request) {
        List<Map<String, Object>> result = new ArrayList<>();

        WebApplicationContext wc = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession().getServletContext());
        RequestMappingHandlerMapping rmhp = wc.getBean(RequestMappingHandlerMapping.class);
        Map<RequestMappingInfo, HandlerMethod> map = rmhp.getHandlerMethods();
        for(RequestMappingInfo info : map.keySet()){
            Api methodAnnotation = map.get(info).getMethodAnnotation(Api.class);
            if(methodAnnotation!=null){
                Map<String, Object> dto = new HashMap<>();
                result.add(dto);
                dto.put("name",methodAnnotation.name());
                dto.put("mapping",info.getPatternsCondition().toString());
            }
            System.out.println(info.getPatternsCondition().toString());
        }
        return result;
    }
}
