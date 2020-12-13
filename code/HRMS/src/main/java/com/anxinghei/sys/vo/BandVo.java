package com.anxinghei.sys.vo;

public class BandVo {
	
	private Integer id;
    private Integer typeid;
    private String typename;
    private Integer discount;
    private String startday;
    private String endday;
    private String description;
    
    
	@Override
	public String toString() {
		return "BandVo [id=" + id + ", typeid=" + typeid + ", typename=" + typename + ", discount=" + discount
				+ ", startday=" + startday + ", endday=" + endday + ", description=" + description + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTypeid() {
		return typeid;
	}
	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
	public String getStartday() {
		return startday;
	}
	public void setStartday(String startday) {
		this.startday = startday;
	}
	public String getEndday() {
		return endday;
	}
	public void setEndday(String endday) {
		this.endday = endday;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
