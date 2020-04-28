package com.rain.sparrow.control.code.dto;

import com.rain.sparrow.common.annotation.check.NotNull;

public class THCodeDto {

    @NotNull(message = "表不能为空")
    private String table;

    @NotNull
    private String model;

    @NotNull
    private String entity;

    @NotNull
    private String packagePath;

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getPackagePath() {
        return packagePath;
    }

    public void setPackagePath(String packagePath) {
        this.packagePath = packagePath;
    }
}
