package com.raw.stock.mapper;


import com.raw.stock.entity.LoginTicket;
import com.raw.stock.entity.stock;
import com.raw.stock.entity.user;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface usermapper {


    user selectUserById(int id);

    int   inserTicket(LoginTicket loginTicket);


    int updataTicketStatus(String loginTicket);
}
