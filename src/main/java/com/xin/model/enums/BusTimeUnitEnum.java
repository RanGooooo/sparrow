package com.xin.model.enums;

/**
* @Author:  zhaohongyu
* @CreateDate:  2021-11-16 15:47
*/
public enum BusTimeUnitEnum {

    Y("Y","年"),
    M("M","月"),
    D("D","日"),

	;
    public final String systemcode;
	public final String systemname;


	private BusTimeUnitEnum(String systemcode , String systemname) {
        this.systemcode = systemcode;
		this.systemname = systemname;
	}

    public static BusTimeUnitEnum getEnumBySystemcode(String systemcode) {
        for (BusTimeUnitEnum c : BusTimeUnitEnum.values()) {
            if (c.systemcode.equals(systemcode)) {
                return c;
            }
        }
        return null;
    }

}