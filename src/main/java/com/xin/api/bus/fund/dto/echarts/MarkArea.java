package com.xin.api.bus.fund.dto.echarts;/**
 * @Description
 * @Author 赵宏宇
 * @date 2021.11.17 17:23
 */

import java.util.List;

/**
 * @Description
 * @Author 赵宏宇
 * @date 2021.11.17 17:23
 */
public class MarkArea {

    private List<List<MarkAreaData>> data;

    public List<List<MarkAreaData>> getData() {
        return data;
    }

    public void setData(List<List<MarkAreaData>> data) {
        this.data = data;
    }
}
