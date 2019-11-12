package com.rain.sparrow.module.step.bean;


import org.apache.ibatis.type.Alias;

@Alias(value = "StepBean")
public class StepBean {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
