package com.rain.sparrow.control.code.service.sdk.constant;

//import java.util.Date;
//import java.math.BigDecimal

public enum DataTypeEnum {
	
	
	BIG_DECIMAL("decimal","BigDecimal"),
	DATE("datetime","Date"),
	STRING("varchar","String");
	
	 private final String key;
	 private final String value;
	 
	 public static DataTypeEnum getEnumByKey(String key){
	    if(null == key){
	        return null;
	    }
	    for(DataTypeEnum temp:DataTypeEnum.values()){
	        if(temp.getKey().equals(key)){
	            return temp;
	        }
	    }
	    return null;
	}

	private DataTypeEnum(String key,String value){
	    this.key = key;
	    this.value = value;
	}
	
	public String getValue() {
		return value;
	}

	public String getKey() {
		return key;
	}
	
}
