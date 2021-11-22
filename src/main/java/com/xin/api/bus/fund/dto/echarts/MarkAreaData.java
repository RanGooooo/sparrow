package com.xin.api.bus.fund.dto.echarts;/**
 * @Description
 * @Author 赵宏宇
 * @date 2021.11.17 17:32
 */

/**
 * @Description
 * @Author 赵宏宇
 * @date 2021.11.17 17:32
 */
public class MarkAreaData {

    private String name;

    private String xAxis;

    public MarkAreaData(String name, String xAxis) {
        this.name = name;
        this.xAxis = xAxis;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getxAxis() {
        return xAxis;
    }

    public void setxAxis(String xAxis) {
        this.xAxis = xAxis;
    }
}
