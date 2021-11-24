package com.xin.model.enums;

/**
* @Author:  zhaohongyu
* @CreateDate:  2021-11-16 15:47
*/
public enum SysViewEnum {

    CONSOLE_MAIN("console_main","sys/console/console_main","控制台"),
    LOGIN_MAIN("login_main","sys/login/login_main","登录页面"),
    MENU_MAIN_LIST("menu_main_list","sys/menu/menu_main_list","菜单列表"),

	;
    public final String systemcode;
	public final String systempath;
	public final String systemname;


	private SysViewEnum(String systemcode , String systempath , String systemname) {
        this.systemcode = systemcode;
	    this.systempath = systempath;
		this.systemname = systemname;
	}

    public static SysViewEnum getEnumBySystemcode(String systemcode) {
        for (SysViewEnum c : SysViewEnum.values()) {
            if (c.systemcode.equals(systemcode)) {
                return c;
            }
        }
        return null;
    }

}