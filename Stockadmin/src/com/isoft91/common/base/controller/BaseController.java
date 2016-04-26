package com.isoft91.common.base.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;
/**
 * 
 * @ProjectName:91isoft_oa
 * @ClassName:BaseCommonController.java
 *	@Description: 抽取了共有文件上传、下载方法，详见方法注释。
 * @Copyright: Copyright (c) 2016
 * @Company:天津市融创软通科技有限公司
 * @author: Lan Yuan
 * @email: lanyuan@91isoft.com 
 * @date 2016年2月20日 下午11:02:14
 * @version V1.1
 */
@Controller
public class BaseController  extends PaginationController{
	
	protected final static String CURRENTUSERSESSIONKEY = "CURRENTUSERSESSIONKEY";
	
	protected final static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	
	
	protected final static String SEPARATOR= File.separator;


	Logger logger  =  Logger.getLogger(BaseController.class);
	
	/**
	 * @Description: 文件上传，请遵循参数格式传入参数。详见参数说明
	 * @Copyright: Copyright (c) 2016
	 * @Company:天津市融创软通科技有限公司
	 * @author LAN YUAN
	 * @date 2016年1月7日 下午3:11:26
	 * @param multipartFile springMVCController层MultipartFile 对象
	 * @param savingPatternOrFullName 在磁盘中保存的文件名 大小写不限 支持传入参数值 ⒈uuid		⒉ date 	3.自定义文件全名（包含扩展名）
	 * @param savingAbsolutePath 保存文件的磁盘绝对路径（不包含文件名，路径允许未被创建）
	 * @return 生成的文件全名（包含扩展名）
	 * @example 调用示例：          globalCommonFileUpload(multipartFile,"uuid","E:/files/filePath/")
	 */
	protected String globalCommonFileUpload(MultipartFile multipartFile,String savingPatternOrFullName,String savingAbsolutePath) {

		String fileExtendsName = "."+getSuffix(multipartFile.getOriginalFilename());
		String finalSavingPath = "";
		savingPatternOrFullName = savingPatternOrFullName.toUpperCase();
		String returnFinalFileName = "";
		switch (savingPatternOrFullName) {
		case "UUID":
			returnFinalFileName=getUUIDString() + fileExtendsName;
			finalSavingPath = savingAbsolutePath +SEPARATOR+ getUUIDString() + fileExtendsName;
			break;
		case "DATE":
			returnFinalFileName = getCurrentDateTimeString() + fileExtendsName;
			finalSavingPath = savingAbsolutePath +SEPARATOR+ getCurrentDateTimeString() + fileExtendsName;
			break;
		default:
			returnFinalFileName = savingPatternOrFullName;
			finalSavingPath = savingAbsolutePath +SEPARATOR+ savingPatternOrFullName ;
			break;
		}
		File file = new File(finalSavingPath);
		if(!file.mkdirs()){
			file.mkdirs();
		}
		try {
			multipartFile.transferTo(file);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnFinalFileName;
	}
	
	/**
	 * @Description: 文件下载，请遵循参数格式传入参数。详见参数说明
	 * @Copyright: Copyright (c) 2016
	 * @Company:天津市融创软通科技有限公司
	 * @author LAN YUAN
	 * @date 2016年1月7日 下午3:40:12
	 * @param savingFileAbsolutePath 	文件在磁盘中的绝对路径包含文件名及扩展名
	 * @param downLoadFileName 下载时显示的文件名包含扩展名
	 * @example 调用示例：   globalCommonFileDownload("E:/heihei/0F39A0C1379047CF9049AE131E889BB3.doc", "file.doc");
	 */
	protected void globalCommonFileDownload(HttpServletResponse response ,String savingFileAbsolutePath,String downLoadFileName) {
		response.setCharacterEncoding("UTF-8");
		response.reset();
		response.setContentType("multipart/form-data"); 
		response.setHeader("Content-Disposition", "attachment; filename="+downLoadFileName);  
		try {
			ServletOutputStream outputStream = response.getOutputStream();
			FileInputStream fileInputStream = new FileInputStream(new File(savingFileAbsolutePath));
	         byte[] b=new byte[4096];  
	         int length;  
	         while((length=fileInputStream.read(b))>0){  
	        	 outputStream.write(b,0,length);  
	         }  
	         fileInputStream.close();  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	/**
	 * 
	 * @Description: 获取文件扩展名
	 * @Copyright: Copyright (c) 2016
	 * @Company:天津市融创软通科技有限公司
	 * @author LAN YUAN
	 * @date 2016年1月7日 下午3:17:52
	 *  * @param originalFilename
	 *  * @return
	 */
	public static String getSuffix(String filename) {
        String suffix = "";
        int pos = filename.lastIndexOf('.');
        if (pos > 0 && pos < filename.length() - 1) {
            suffix = filename.substring(pos + 1);
        }
        return suffix;
    }
	
	
	
	/**
	 * 获取UUID
	 * @Description: 请务必自行补充代码核心描述
	 * @Copyright: Copyright (c) 2016
	 * @Company:天津市融创软通科技有限公司
	 * @author LAN YUAN
	 * @date 2016年1月7日 下午3:34:05
	 *  * @return
	 */
	protected static String getUUIDString(){
		return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
	}
	/**
	 * 获取当前系统时间
	 * @Description: 请务必自行补充代码核心描述
	 * @Copyright: Copyright (c) 2016
	 * @Company:天津市融创软通科技有限公司
	 * @author LAN YUAN
	 * @date 2016年1月7日 下午3:34:09
	 *  * @return
	 */
	protected static String getCurrentDateTimeString() {
		return simpleDateFormat.format(new Date());
	}
	
	
	
	

}
