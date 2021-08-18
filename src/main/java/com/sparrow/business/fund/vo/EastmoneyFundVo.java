package com.sparrow.business.fund.vo;

/**
 * @Description
 * @Author 赵宏宇
 * @date 2021.07.13 16:26
 */
public class EastmoneyFundVo {

    private String fundcode;
    private String name;
    /**
     * 单位净值日期
     */
    private String jzrq;
    /**
     * 单位净值
     */
    private String dwjz;
    /**
     * 净值估算
     */
    private String gsz;
    /**
     * 净值浮动百分比
     */
    private String gszzl;
    private String gztime;

    public String getFundcode() {
        return fundcode;
    }

    public void setFundcode(String fundcode) {
        this.fundcode = fundcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJzrq() {
        return jzrq;
    }

    public void setJzrq(String jzrq) {
        this.jzrq = jzrq;
    }

    public String getDwjz() {
        return dwjz;
    }

    public void setDwjz(String dwjz) {
        this.dwjz = dwjz;
    }

    public String getGsz() {
        return gsz;
    }

    public void setGsz(String gsz) {
        this.gsz = gsz;
    }

    public String getGszzl() {
        return gszzl;
    }

    public void setGszzl(String gszzl) {
        this.gszzl = gszzl;
    }

    public String getGztime() {
        return gztime;
    }

    public void setGztime(String gztime) {
        this.gztime = gztime;
    }
}
