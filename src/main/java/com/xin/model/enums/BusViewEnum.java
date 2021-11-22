package com.xin.model.enums;

/**
* @Author:  zhaohongyu
* @CreateDate:  2021-11-16 15:47
*/
public enum BusViewEnum {

    FUND_MAIN_LIST("fund_main_list","bus/fund/fund_main_list","基金列表"),
    FUND_MAIN_SAVE("fund_main_save","bus/fund/fund_main_save","基金保存页面"),
    FUND_NET_WORTH_REPORT("fund_net_worth_report","bus/fund/fund_net_worth_report","基金净值报表"),
	
	;
    public final String systemcode;
	public final String systempath;
	public final String systemname;

	
	private BusViewEnum(String systemcode ,String systempath , String systemname) {
        this.systemcode = systemcode;
	    this.systempath = systempath;
		this.systemname = systemname;
	}

    public static BusViewEnum getEnumBySystemcode(String systemcode) {
        for (BusViewEnum c : BusViewEnum.values()) {
            if (c.systemcode.equals(systemcode)) {
                return c;
            }
        }
        return null;
    }

}