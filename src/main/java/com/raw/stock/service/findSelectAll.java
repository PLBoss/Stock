package com.raw.stock.service;

import com.raw.stock.entity.stock;
import com.raw.stock.entity.user;
import com.raw.stock.mapper.selectAllmapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class findSelectAll {

    @Autowired
    private selectAllmapper selectAllMapper;

    public List<stock> findSelectAll(){

        return selectAllMapper.selectAll();

    }

    public List<stock> findPage(int offset,int limit){

        return selectAllMapper.selectPage(offset,limit);

    }


    public  int count(){
        return  selectAllMapper.selectcount();
    }


    public user findByname(String username) {

        return selectAllMapper.selectUserByname(username);
    }
}
