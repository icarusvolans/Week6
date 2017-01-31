package com.example.batchcsvpostgresql.model;


public class Department {
    private long deptId;
    private String[] deptType;


    public Department() {
    }

    public Department(long deptId, String[] deptType) {
        this.deptId = deptId;
        this.deptType = deptType;
    }

    public long getDeptId() {
        return deptId;
    }

    public void setDeptId(long deptId) {
        this.deptId = deptId;
    }

    public String[] getDeptType() {
        return deptType;
    }

    public void setDeptType(String[] deptType) {
        this.deptType = deptType;
    }

}



