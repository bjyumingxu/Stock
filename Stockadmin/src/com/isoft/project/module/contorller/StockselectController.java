package com.isoft.project.module.contorller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.isoft.project.module.dao.StockselectDao;
import com.isoft.project.module.po.Stockdata;
import com.isoft.project.module.service.StockIndexSevice;
import com.isoft91.common.base.controller.BaseController;


@RequestMapping("/Stockselect")
@Controller
public class StockselectController extends BaseController{	
	
	@Autowired
	private StockselectDao ssd;
	@Autowired
	private StockIndexSevice  sisvc;

	
	
	
	@RequestMapping("/cx")
	@ResponseBody
	public List test2(String gid){
		System.out.println(gid);
		return ssd.findbyStockcxId(gid);
		

	}
	@RequestMapping("/mhcx")
	@ResponseBody
	public List test3(String name){
		System.out.println(name);
		return ssd.findbyStockmhcxId(name);
		

	}
	/**
	 * 大盘
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping("/test3.do")
	@ResponseBody
	public Map find(){
		sisvc.synStockDataDaPan();
		
		return ssd.findbyStockIndexId();
	}
	
	/**
	 * TOP10
	 * @return
	 */
	@RequestMapping("/test4.do")
	@ResponseBody
	public List find1(){

		
		return ssd.findbyStockTopId(); 
	}
	
}
