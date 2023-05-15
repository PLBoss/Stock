package com.raw;


import com.raw.stock.entity.stock;
import com.raw.stock.service.findSelectAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class test {

    @Autowired
    private findSelectAll findSelectAll;

    @Test
    public void test(){

        List<stock> page = findSelectAll.findSelectAll();

        for (stock stock : page) {


            System.out.println(stock);

        }


    }
}
