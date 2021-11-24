package com.xin.common.model.enums;

/**
 * 功能: 账号使用状态
 * 作者: zhaohongyu
 * 创建时间: 2021-11-24 15:18
 */
public enum SysUserMainAccountStateEnum {

    PROHIBIT("00","禁止使用"),
    NORMAL("01","正常使用"),

	;
    public final String systemcode;
	public final String systemname;


	private SysUserMainAccountStateEnum(String systemcode , String systemname) {
        this.systemcode = systemcode;
		this.systemname = systemname;
	}

    public static SysUserMainAccountStateEnum getEnumBySystemcode(String systemcode) {
        for (SysUserMainAccountStateEnum c : SysUserMainAccountStateEnum.values()) {
            if (c.systemcode.equals(systemcode)) {
                return c;
            }
        }
        return null;
    }

}