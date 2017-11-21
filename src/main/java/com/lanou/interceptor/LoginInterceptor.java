package com.lanou.interceptor;

import com.lanou.domain.Admin_info;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by dllo on 17/11/10.
 */
public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String url = request.getRequestURI(); // 获取请求路径
        if (url.indexOf("login") != -1){
            return true;
        }
        // 获取session对象
        Admin_info admin_info = (Admin_info) request.getServletContext().getAttribute("admin_info");
            if (admin_info == null || admin_info.getName().equals(url)) {
            // 如果没有登录过需要转发到登录页面
            request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request,response);
        }
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
