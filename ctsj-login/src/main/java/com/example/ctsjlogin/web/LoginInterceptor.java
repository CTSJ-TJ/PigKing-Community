package com.example.ctsjlogin.web;

import com.google.gson.Gson;
import com.example.ctsjlogin.vo.Result;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    // 前置拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if (session.getAttribute("loginedUser")==null) {

            String accept = request.getHeader("Accept");
            if(accept.startsWith("application/json")){
                // JSON
                Gson gson = new Gson();
                String json = gson.toJson(new Result(0, "请先登录!", null));
                response.setContentType("application/json;charset=utf-8");
                response.getWriter().append(json);
            } else {
                // contextPath   /SpringMVC_war_exploded
                String contextPath = request.getServletContext().getContextPath();
                String indexPath = contextPath + "/index.html?tologin";
                response.sendRedirect(indexPath);
            }
            return false;
        }
        return true;
    }

    // 后置拦截
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("----------postHandle-------------");
    }

    // 完成拦截
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("----------afterCompletion-------------");
    }
}