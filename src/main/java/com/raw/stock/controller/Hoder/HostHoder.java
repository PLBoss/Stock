package com.raw.stock.controller.Hoder;


import com.raw.stock.entity.user;
import org.springframework.stereotype.Component;

@Component
public class HostHoder {
        private ThreadLocal<user> users=new ThreadLocal<user>();

        public void  setUser(user user){
            users.set(user);
        }

        public user getUser(){
            return  users.get();
        }

        public void clearUser(){
            users.remove();
        }

}
