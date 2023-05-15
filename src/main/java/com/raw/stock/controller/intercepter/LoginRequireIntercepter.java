package com.raw.stock.controller.intercepter;

import com.raw.stock.annotation.LoginRequired;
import com.raw.stock.controller.Hoder.HostHoder;
import com.raw.stock.entity.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;


@Component
public class LoginRequireIntercepter implements HandlerInterceptor {

    @Autowired
    private HostHoder hostHoder;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //检查用户是否登陆的拦截器


        if(handler instanceof HandlerMethod){
            HandlerMethod handlerMethod= (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            LoginRequired loginRequired = method.getAnnotation(LoginRequired.class);
            user user = hostHoder.getUser();
            if(loginRequired!=null&&user==null){

                response.sendRedirect(request.getContextPath()+"/login");
                return  false;
            }

        }



        return  true;
    }
}
