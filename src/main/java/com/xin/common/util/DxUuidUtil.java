package com.xin.common.util;

import java.util.UUID;

public class DxUuidUtil {
	    public static String getUUID(){
	         return UUID.randomUUID().toString().replace("-", "");
	    }

}
