package com.xin.api.bus.fund.dto.echarts;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Serie {
	
	private String name;
	private String type;
    private List<BigDecimal> data;
    private MarkArea markArea;
    
    public Serie() {
		this.data = new ArrayList<>();
	}
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<BigDecimal> getData() {
		return data;
	}
	public void setData(List<BigDecimal> data) {
		this.data = data;
	}

    public MarkArea getMarkArea() {
        return markArea;
    }

    public void setMarkArea(MarkArea markArea) {
        this.markArea = markArea;
    }
//    {
//        type: 'line',
//                markArea: {
//        itemStyle: {
//            color: 'rgba(255, 173, 177, 0.4)'
//        },
//        data: [
//                                            [
//        {
//            name: 'Morning Peak',
//                    xAxis: '2021-07-30'
//        },
//        {
//            xAxis: '2021-11-08'
//        }
//                                            ]
//                                        ]
//    }
//    }
}
