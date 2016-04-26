package com.isoft91.common.base.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ModelAttribute;

import com.isoft91.common.base.entity.BaseCommonEntity;
import com.isoft91.common.base.utilities.PaginationUtility;

/**
 * @ProjectName:91isoft_oa
 * @Description: 
 * @Copyright: Copyright (c) 2016
 * @Company:天津市融创软通科技有限公司
 * @author: 周楠
 * @date 2016年3月25日 上午8:10:20
 */

public class PaginationController extends HttpServletController{

	protected final static String   PAGNATIONKEY ="pagnation";
	
	/**
	 * 
	 * @Description: 获取分页对象
	 * @MethodName:getPaginationUtility
	 * @author: Lan Yuan
	 * @email: lanyuan@91isoft.com 
	 * @date 2016年2月20日 下午11:08:01
	 * @version V1.0
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public PaginationUtility<? extends BaseCommonEntity> getPaginationUtility(HttpServletRequest request) {
		PaginationUtility<? extends BaseCommonEntity> paginationUtility = (PaginationUtility<? extends BaseCommonEntity>) request.getAttribute(PAGNATIONKEY);
		if(paginationUtility==null){
			throw new NullPointerException("未传递分页参数（page&rows），却在方法中使用paginationUtility对象。");
		}else{
			return paginationUtility;
		}
	}
	
	
	
	
	
	/**
	 * @Description: 分页、排序参数初始化
	 * @MethodName:setPagnationAttribute
	 * @author: Lan Yuan
	 * @email: lanyuan@91isoft.com 
	 * @date 2016年3月7日 下午4:38:38
	 * @version V1.1
	 * @param rows 每页显示的个数
	 * @param page 请求页
	 * @param sort 排序字段名
	 * @param order 排序方式
	 */
	@ModelAttribute  
	private void setPagnationAttribute(HttpServletRequest request,Integer rows,Integer page,String sort,String order){
		if(rows!=null&&page!=null&&sort!=null&&order!=null){
			PaginationUtility<? extends BaseCommonEntity> _paginationUtility = new PaginationUtility<>();
			_paginationUtility.setPageNum(page);
			_paginationUtility.setPageSize(rows);
			_paginationUtility.setOrderBy(sort+" "+order);
			request.setAttribute(PAGNATIONKEY, _paginationUtility);
		}
		if(rows!=null&&page!=null){
			PaginationUtility<? extends BaseCommonEntity> _paginationUtility = new PaginationUtility<>();
			_paginationUtility.setPageNum(page);
			_paginationUtility.setPageSize(rows);
			request.setAttribute(PAGNATIONKEY, _paginationUtility);
		}else if(sort!=null&&order!=null){
			PaginationUtility<? extends BaseCommonEntity> _paginationUtility = new PaginationUtility<>();
			_paginationUtility.setOrderBy(sort+" "+order);
			request.setAttribute(PAGNATIONKEY, _paginationUtility);
		}
		
	}
	
	
	
}
