package com.raw.stock.controller;


import com.raw.stock.annotation.LoginRequired;
import com.raw.stock.entity.user;
import com.raw.stock.service.findSelectAll;
import com.raw.stock.service.userService;
import com.raw.stock.util.CookieUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class systemController {

    @Autowired
    private findSelectAll findSelectALl;
    
    @Autowired
    private userService userService;


    private int expired_time=100;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String getloginPage(){

        return  "pages-login";
    }


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(Model model, String username, String password, HttpServletResponse response){


        /*
        *
        * */
        user user=findSelectALl.findByname(username);

        if(user!=null){
            String pass = user.getPassword();

            if(pass.equals(password)){

                Map<String, Object> map = userService.login(username, password, expired_time);
                String loginTicket = map.get("loginTicket").toString();
                Cookie cookie=new Cookie("loginTicket",loginTicket);
                cookie.setMaxAge(expired_time);
                cookie.setPath("/");
                response.addCookie(cookie);



                return "redirect:/page";
            }

            model.addAttribute(("pmsg"),"密码错误");
        }else{
            model.addAttribute("umsg","用户名错误");
        }



        return "pages-login";

    }
    @RequestMapping(value = "/loginOut")
    public String loginout(HttpServletResponse response, HttpServletRequest request){

        String loginTicket = CookieUtil.getValue(request, "loginTicket");

        userService.loginOut(loginTicket);

        return "pages-login";


    }



    @RequestMapping("/register")
    public  String register(){

        return  "pages-register";

    }
}
