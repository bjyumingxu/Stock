package com.isoft.project.module.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import com.isoft.project.module.dao.StockInfoDao;
import com.isoft.project.module.dao.StockdataDao;
import com.isoft.project.module.dao.StockselectDao;
import com.isoft.project.module.po.Stockdata;
import com.isoft.project.module.po.Stockindex;
import com.isoft.project.module.po.Stockinfo;
import com.isoft.stock.stockutils.JuheDataToBean;
import com.isoft.stock.stockutils.JuheStockData;

public class StockselectServer {
	@Autowired
	private StockselectDao ssdao;
	

	
	
	
	
	public List<Stockindex>  getall(){
		
		return ssdao.findAll();
	}
	
	public Map<String,Object> getStockindexbyid(String id){
		
		
		Stockindex si=  ssdao.findById(Integer.valueOf(id));
		
		 
		 //List<Stockindex> sdlist=ssdao.findbyStockIndexId();
		 
		 Map<String, Object> map=new HashMap<String, Object>();
		 
//		 map.put("Stockinfo", si);
//		 map.put("Stockdata", sdlist);
		 
		 
		 return map;
		
	}
	
	

}
