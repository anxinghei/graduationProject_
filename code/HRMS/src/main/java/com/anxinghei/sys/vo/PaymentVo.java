package com.anxinghei.sys.vo;

public class PaymentVo {

    private Integer roomNum;
	private Integer guestid;
	private String guestname;
    private Integer amount;
    private String date;
	private String startday;
	private String endday;
	
	private Integer dayPayment;
	private Integer monthPayment;
	private Integer yearPayment;
	private Integer daySum;
	private Integer monthSum;
	private Integer yearSum;
	
	
	
	public PaymentVo() {
		super();
	}

	public PaymentVo(Integer dayPayment, Integer monthPayment, Integer yearPayment, Integer daySum, Integer monthSum,
			Integer yearSum) {
		super();
		this.dayPayment = dayPayment;
		this.monthPayment = monthPayment;
		this.yearPayment = yearPayment;
		this.daySum = daySum;
		this.monthSum = monthSum;
		this.yearSum = yearSum;
	}

	@Override
	public String toString() {
		return "PaymentVo [roomNum=" + roomNum + ", guestid=" + guestid + ", guestname=" + guestname + ", amount="
				+ amount + ", date=" + date + ", startday=" + startday + ", endday=" + endday + ", dayPayment="
				+ dayPayment + ", monthPayment=" + monthPayment + ", yearPayment=" + yearPayment + ", daySum=" + daySum
				+ ", monthSum=" + monthSum + ", yearSum=" + yearSum + "]";
	}
	
	public Integer getDaySum() {
		return daySum;
	}
	public void setDaySum(Integer daySum) {
		this.daySum = daySum;
	}
	public Integer getMonthSum() {
		return monthSum;
	}
	public void setMonthSum(Integer monthSum) {
		this.monthSum = monthSum;
	}
	public Integer getYearSum() {
		return yearSum;
	}
	public void setYearSum(Integer yearSum) {
		this.yearSum = yearSum;
	}
	public Integer getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(Integer roomNum) {
		this.roomNum = roomNum;
	}
	public Integer getGuestid() {
		return guestid;
	}
	public void setGuestid(Integer guestid) {
		this.guestid = guestid;
	}
	public String getGuestname() {
		return guestname;
	}
	public void setGuestname(String guestname) {
		this.guestname = guestname;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
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
	public Integer getDayPayment() {
		return dayPayment;
	}
	public void setDayPayment(Integer dayPayment) {
		this.dayPayment = dayPayment;
	}
	public Integer getMonthPayment() {
		return monthPayment;
	}
	public void setMonthPayment(Integer monthPayment) {
		this.monthPayment = monthPayment;
	}
	public Integer getYearPayment() {
		return yearPayment;
	}
	public void setYearPayment(Integer yearPayment) {
		this.yearPayment = yearPayment;
	}
	
	
}
