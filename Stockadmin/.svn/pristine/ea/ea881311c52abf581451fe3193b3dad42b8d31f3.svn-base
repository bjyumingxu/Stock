package com.isoft91.common.base.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class IDGeneratorUtility implements BaseCommonUtility{
	
	protected final static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	
	public static String getUUIDString(){
		return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
	}
	
	@Deprecated
	public static String getCurrentDateTimeString() {
		return simpleDateFormat.format(new Date());
	}
}
