package com.sparrow.business.fund.dto;

import com.sparrow.business.fund.entity.TBFund;

public class TBFundDto extends TBFund{

    private String realName;

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
}
