package com.isoft.project.module.contorller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.isoft.project.module.service.StockIndexSevice;
import com.isoft.project.module.service.StockdataService;
import com.isoft91.common.base.controller.BaseController;


@RequestMapping("/Stockdata")
@Controller
public class StockdataController extends BaseController{
    @Autowired
	private StockdataService  sdsvc;
    @Autowired
    private StockIndexSevice  sisvc;
	
    
    @RequestMapping("/savetest")
    @ResponseBody
    public String test(){
    	
    	sdsvc.testsave();
		return SUCCESS;
    	
    }
    
    
    /**
     * 人工触发 同步类表更新
     * @MethodName:exeStockinfolist
     * @author: 姓名
     * @date 2016年4月20日 下午4:27:02
     * @return
     */
    @RequestMapping("/exeStockinfolist")
    @ResponseBody
    public String exeStockinfolist(){
    	
    	sdsvc.getdataStockinfolist();
    	
    	return SUCCESS;
    	
    }
    /**
     * 自动触发data更新
     * @return
     */
    @RequestMapping("/synStockData")
    @ResponseBody
    public String synStockData(){
    	
    	sdsvc.synStockData();
    	
    	return SUCCESS;
    	
    }
    
    /**
     * 抓取大盘数据（实时）
     * @return
     */
    @RequestMapping("/synStockDaPanData")
    @ResponseBody
    public String synStockDataDaPan(){
    	
    	sisvc.synStockDataDaPan();
    	
    	return SUCCESS;
    	
    }
    
    
}
