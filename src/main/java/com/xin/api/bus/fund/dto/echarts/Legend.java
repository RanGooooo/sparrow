package com.xin.api.bus.fund.dto.echarts;

import java.util.ArrayList;
import java.util.List;

public class Legend {
	
	private List<String> data;
	
	public Legend() {
		this.data = new ArrayList<>();
	}

	public List<String> getData() {
		return data;
	}

	public void setData(List<String> data) {
		this.data = data;
	}
	
}
