package com.isoft91.common.base.utilities;

import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.isoft91.common.base.entity.BaseCommonEntity;
@Component
@SuppressWarnings("unchecked")
/**
 * 
 * @ProjectName:91isoft_oa
 * @ClassName:PaginationUtility.java
 * @Description: mybaits分页插件扩展类，分页对象，配合spring aop实现业务代码免分页
 *  2016年3月7日 16:32:27 支持排序
 * @Copyright: Copyright (c) 2016
 * @Company:天津市融创软通科技有限公司
 * @author: Lan Yuan
 * @email: lanyuan@91isoft.com 
 * @date 2016年3月7日 16:31:31
 * @version V1.1
 */
public class PaginationUtility<T extends BaseCommonEntity> extends PageInfo<T> implements BaseCommonUtility{
	/**
	 * 
	 */
	private void setPageInfo(PaginationUtility<T> paginationUtility,PageInfo<T> pageInfo){
		paginationUtility.setEndRow(pageInfo.getEndRow());
		paginationUtility.setFirstPage(pageInfo.getFirstPage());
		paginationUtility.setHasNextPage(pageInfo.isHasNextPage());
		paginationUtility.setHasPreviousPage(pageInfo.isHasPreviousPage());
		paginationUtility.setIsFirstPage(pageInfo.isIsFirstPage());
		paginationUtility.setIsLastPage(pageInfo.isIsLastPage());
		paginationUtility.setLastPage(pageInfo.getLastPage());
		paginationUtility.setNavigatepageNums(pageInfo.getNavigatepageNums());
		paginationUtility.setNavigatePages(pageInfo.getNavigatePages());
		paginationUtility.setNextPage(pageInfo.getNextPage());
		paginationUtility.setOrderBy(pageInfo.getOrderBy());
		paginationUtility.setPageNum(pageInfo.getPageNum());
		paginationUtility.setPages(pageInfo.getPages());
		paginationUtility.setPageSize(pageInfo.getPageSize());
		paginationUtility.setPrePage(pageInfo.getPrePage());
		paginationUtility.setSize(pageInfo.getSize());
		paginationUtility.setStartRow(pageInfo.getStartRow());
		paginationUtility.setList(pageInfo.getList());
		paginationUtility.setTotal(pageInfo.getTotal());
	}
	
	private static final long serialVersionUID = 3300757611987209228L;
	
	
	/**
	 * 
	 * @Description: 分页的AOP处理，在controller层将分页基础数据装入对象，在service层无需设置分页即可完成分页
	 * @MethodName:preparedPageHeplerAndloadingPageInfoSetResults
	 * @author: Lan Yuan
	 * @email: lanyuan@91isoft.com 
	 * @date 2016年2月20日 下午10:40:23
	 * @version V1.0
	 * @param proceedingJoinPoint
	 */
	public List<T> preparedPageHeplerAndloadingPageInfoSetResults(ProceedingJoinPoint proceedingJoinPoint){
		PaginationUtility<T> paginationUtility = (PaginationUtility<T>) proceedingJoinPoint.getArgs()[0];
		PageHelper.startPage(paginationUtility.getPageNum(), paginationUtility.getPageSize(),getOrderBy());
		try {
			List<T> list = (List<T>) proceedingJoinPoint.proceed();
			PageInfo<T> pageInfo =new PageInfo<T>(list);
			setPageInfo(paginationUtility,pageInfo);
			return list;
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	@Override
	public List<T> getList() {
		// TODO Auto-generated method stub
		return super.getList();
	}
	
}
