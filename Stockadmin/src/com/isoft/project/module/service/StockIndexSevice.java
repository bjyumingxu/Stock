package com.isoft.project.module.service;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;








import com.isoft.project.module.dao.StockIndexDao;
import com.isoft.project.module.po.Stockindex;
import com.isoft.project.module.po.Stockinfo;
import com.isoft.stock.stockutils.JuheDataToBean;
import com.isoft.stock.stockutils.JuheStockData;



@Service("StockIndexSevice")
public class StockIndexSevice {

	@Autowired
	private StockIndexDao stockiddao;
	
	
	/**
	 * 实时大盘同步
	 * @MethodName:synStockDataDaPan
	 * @author: 姓名
	 * @date 2016年4月20日 下午3:20:14
	 */
	public void synStockDataDaPan(){
		
	JSONObject sh=	(JSONObject) JuheStockData.selectStockDaPan(0);
	JSONObject zh=	(JSONObject) JuheStockData.selectStockDaPan(1);
	
	Stockindex sish=(Stockindex) JuheDataToBean.ToDaPanBean(sh, Stockindex.class);
	
	stockiddao.saveOrUpdate(sish);
	
	Stockindex sizh=(Stockindex) JuheDataToBean.ToDaPanBean(zh, Stockindex.class);
	
	stockiddao.saveOrUpdate(sizh);
		
	}
		
	
}
