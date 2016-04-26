package com.isoft.project.module.service;

import java.util.List;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isoft.project.module.dao.StockInfoDao;
import com.isoft.project.module.dao.StockdataDao;
import com.isoft.project.module.po.Stockdata;
import com.isoft.project.module.po.Stockinfo;
import com.isoft.stock.stockutils.JuheDataToBean;
import com.isoft.stock.stockutils.JuheStockData;


@Service("StockdataService")
public class StockdataService {

	private static List<Stockinfo> dataStockinfolist;
	
	
	@Autowired
	private StockdataDao sddao;
	
	@Autowired
	private StockInfoDao sidao;
	
	
	/**
	 * 同步股价数据前 获取同步列表
	 * @MethodName:getdataStockinfolist
	 * @author: 姓名
	 * @date 2016年4月20日 下午4:24:48
	 * @return
	 */
	public  List<Stockinfo>  getdataStockinfolist(){
		
	return dataStockinfolist=sidao.findDataStockinfoList();

	}
	
	
	
	/**
	 * 同步股价数据
	 * @MethodName:synStockData
	 * @author: 姓名
	 * @date 2016年4月20日 下午4:25:17
	 */
	public void synStockData(){
		
		for (Stockinfo stockinfo : dataStockinfolist) {
			
			try {
			
		    JSONArray  jsonarray=(JSONArray) JuheStockData.selectHSStock(stockinfo.getSymbol());
		    
		    Stockdata  s= (Stockdata) JuheDataToBean.ToDanGuBean(jsonarray, Stockdata.class);
		    
		    sddao.saveOrUpdate(s);
			
			} catch (Exception e) {
			e.printStackTrace();  
			//做异常记录  
			}
	
		}
	
		
	}
	
	
	
	
	public void testsave(){
	
		JSONArray  jsonarray=(JSONArray) JuheStockData.selectHSStock("sh600000");
	    
		  Stockdata   s=   (Stockdata) JuheDataToBean.ToDanGuBean(jsonarray, Stockdata.class);
	
		sddao.saveOrUpdate(s);
		
	}
	
}
