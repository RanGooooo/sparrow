package com.xin.api.bus.fund.dto.echarts;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(Include.NON_NULL)
public class Option {
	//报表显示类别
	private Legend legend;
	//x轴数据
	private XAxis xAxis;
	//折线上的连续数据集合
	private List<Serie> series;
	
	public Option() {
		this.legend = new Legend();
		this.xAxis = new XAxis();
		this.series = new ArrayList<>();
	}
	
	public Legend getLegend() {
		return legend;
	}
	public void setLegend(Legend legend) {
		this.legend = legend;
	}
	public XAxis getxAxis() {
		return xAxis;
	}
	public void setxAxis(XAxis xAxis) {
		this.xAxis = xAxis;
	}
	public List<Serie> getSeries() {
		return series;
	}
	public void setSeries(List<Serie> series) {
		this.series = series;
	}
	
}
