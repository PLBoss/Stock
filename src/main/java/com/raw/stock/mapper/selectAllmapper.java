package com.raw.stock.mapper;


import com.raw.stock.entity.LoginTicket;
import com.raw.stock.entity.stock;
import com.raw.stock.entity.user;
import org.apache.ibatis.annotations.Mapper;
import sun.security.krb5.internal.Ticket;

import java.util.List;

@Mapper
public interface selectAllmapper {

    public List<stock> selectAll();

    public List<stock> selectPage(int offset,int limit);


    public  int selectcount();

    user selectUserByname(String username);

    LoginTicket selectByTicket(String tickt);
}
