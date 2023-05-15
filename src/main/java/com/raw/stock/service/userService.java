package com.raw.stock.service;

import com.raw.stock.entity.LoginTicket;


import com.raw.stock.entity.user;
import com.raw.stock.mapper.selectAllmapper;
import com.raw.stock.mapper.usermapper;
import com.raw.stock.util.ticktUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class userService {

    @Autowired
    private selectAllmapper selectAllmapper;

    @Autowired
    private com.raw.stock.mapper.usermapper usermapper;

    public Map<String,Object> login(String username ,String passsword,long exporedSeconds ){
        Map<String,Object>  map=new HashMap<>();

        user user = selectAllmapper.selectUserByname(username);


        LoginTicket loginTicket=new LoginTicket();

        loginTicket.setUserId(user.getId());
        loginTicket.setTicket(ticktUtil.generateUUID());
        loginTicket.setStatus(0);
        loginTicket.setExpired(new Date(System.currentTimeMillis()+exporedSeconds*1000));
        usermapper.inserTicket(loginTicket);

        map.put("loginTicket",loginTicket.getTicket());
        

        return map;

    }

    public  void  loginOut(String ticket){
        usermapper.updataTicketStatus(ticket);



    }

    public LoginTicket findLoginTickt(String tickt){

        LoginTicket ticket = selectAllmapper.selectByTicket(tickt);


        return  ticket;

    }

    public  user findUserById(int id){

        return  usermapper.selectUserById(id);
    }

}
