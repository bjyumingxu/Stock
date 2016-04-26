package com.isoft.project.module.contorller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.isoft.project.module.dao.SysUserinfoDao;

@RequestMapping("/Stockuserselect")
@Controller
public class UserinfoController {
	@Autowired
	private SysUserinfoDao suid;
	
	
	
	@RequestMapping("/userinfo")
	@ResponseBody
	public List test1(){
		
		return suid.findbyUserinfoId();
		

	}


}
