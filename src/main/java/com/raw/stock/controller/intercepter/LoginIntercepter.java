package com.raw.stock.controller.intercepter;

import com.raw.stock.controller.Hoder.HostHoder;
import com.raw.stock.entity.LoginTicket;
import com.raw.stock.entity.user;

import com.raw.stock.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Component
public class LoginIntercepter implements HandlerInterceptor {

    @Autowired
    private com.raw.stock.service.userService userService;


    @Autowired
    private HostHoder hostHoder;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //在执行前先查询是否登陆,先从cookie中得到tickt，在去查数据库是否含有tickt

        String tickt = CookieUtil.getValue(request, "loginTicket");

        if(tickt!=null){


            LoginTicket loginTickt = userService.findLoginTickt(tickt);

            if(loginTickt!=null&&loginTickt.getStatus()==0&&loginTickt.getExpired().after(new Date())){

                user user = userService.findUserById(loginTickt.getUserId());

                hostHoder.setUser(user);

            }

        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
       //验证是否登陆成功
        user user = hostHoder.getUser();

        if(user!=null&&modelAndView!=null){
            modelAndView.addObject("loginUser",user);

        }

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        hostHoder.clearUser();
    }
}

