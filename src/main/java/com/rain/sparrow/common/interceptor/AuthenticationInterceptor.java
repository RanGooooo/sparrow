package com.rain.sparrow.common.interceptor;

import com.rain.sparrow.common.constant.AuthenticationConstant;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description 认证拦截器
 * @Author RanGooooo
 * @date 2020.03.14 15:41
 */
@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getSession().getAttribute(AuthenticationConstant.USER_INFO)!=null){
            return true;
        }
        // 针对ajax请求处理
//        if (request.getHeader("X-Requested-With") != null) {
//            String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
//            response.setHeader("ajaxTimeOuturl", basePath + "/TSLoginController/login");
//        } else {
//            request.getRequestDispatcher("/TSLoginController/login").forward(request, response);
//        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

    }
}
