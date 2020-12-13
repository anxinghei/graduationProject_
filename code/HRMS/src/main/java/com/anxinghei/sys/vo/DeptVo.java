package com.anxinghei.sys.vo;

public class DeptVo {

    private Integer dId;
    private String dName;
    private String description;
    private Integer mId;
    private String mName;

    public DeptVo() {
    }

    public DeptVo(Integer dId, String dName, String description, Integer mId, String mName) {
        this.dId = dId;
        this.dName = dName;
        this.description = description;
        this.mId = mId;
        this.mName = mName;
    }

    @Override
    public String toString() {
        return "DeptVo{" +
                "dId=" + dId +
                ", dName='" + dName + '\'' +
                ", description='" + description + '\'' +
                ", mId=" + mId +
                ", mName='" + mName + '\'' +
                '}';
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }
}
