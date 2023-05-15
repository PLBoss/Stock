package com.raw.stock.controller;


import com.raw.stock.annotation.LoginRequired;
import com.raw.stock.entity.Page;
import com.raw.stock.entity.stock;
import com.raw.stock.service.findSelectAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class stockController {

   @Autowired
   private findSelectAll findSelectAll;

    @RequestMapping("/index")
    public String getindex(){

        List<stock> stocks = findSelectAll.findSelectAll();

        return "index";
    }
    @RequestMapping("/echarts")
    public String echart(){

        return "charts-echarts";
    }

    @RequestMapping("/achart")
    public String achart(){

        return "charts-chartjs";
    }

    @RequestMapping("/pchart")
    public String pchart(){

        return "charts-apexcharts";
    }

    @ResponseBody
    @RequestMapping("/getKdata")
    public Object getecharts(){

        List<stock> stocks = findSelectAll.findSelectAll();
        return stocks;
    }

    @LoginRequired
    @RequestMapping("/page")
    public String getindexPage(Model model, Page page){


        int count = findSelectAll.count();

        page.setRows(count);
        page.setPath("/page");
        page.setLimit(8);

        // 创建SimpleDateFormat对象，指定日期时间格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
        // 获取当前时间
        Date date = new Date();
        // 格式化输出时间
        String time = sdf.format(date);
        List<stock> stocks = findSelectAll.findPage(page.getOffset(), page.getLimit());

        model.addAttribute("time",time);
        model.addAttribute("count",count);
        model.addAttribute("stocks",stocks);


        return "index";
    }

}
