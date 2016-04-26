package com.isoft.project.module.contorller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.isoft.project.module.po.Stockinfo;
import com.isoft.project.module.service.StockInfoService;
import com.isoft91.common.base.controller.BaseController;

/**
 * @ProjectName:MVCProject
 * @Description: 
 * @Copyright: Copyright (c) 2016
 * @Company:天津市融创软通科技有限公司
 * @author: 周楠
 * @date 2016年4月19日 上午9:39:47
 */
@RequestMapping("/StockInfo")
@Controller
public class StockInfoController extends BaseController{

	@Autowired
	private StockInfoService sisvc;
	
	
	
	@RequestMapping("/findall")
	@ResponseBody
	public List<Stockinfo> getall(){
		
		return sisvc.getall();
		
	}
	
	
	@RequestMapping("/findbyid")
	@ResponseBody
	public Map<String, Object> getbyId(String id){
		
	
	Map<String, Object> map =	sisvc.getStockinfobyid(id);
		
		
		return map;
		
	}
	
	
	@RequestMapping("/synStocklist")
	@ResponseBody
	public String synStockList(){
		
		Date start=new Date();
				
		sisvc.synStockInfo();
	
		Date end =new Date();
		
	    Long time=	end.getTime()-start.getTime();
	    
	    time= time/1000;
		
		return SUCCESS+"   time:"+time +"s" ;
	}
	
	
	
}
