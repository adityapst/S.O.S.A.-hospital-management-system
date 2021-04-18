package application;

import java.sql.Date;

public class Patient_In {
	int pid,room_no,report_no,bill_no,adv_pay;
	Date in_date,out_date;
	String treatment,presc;
	public Patient_In(int pid, Date in_date,Date out_date,int room_no, int report_no, int bill_no,
			String treatment, String presc, int adv_pay) {
		super();
		this.pid = pid;
		this.room_no = room_no;
		this.report_no = report_no;
		this.bill_no = bill_no;
		this.adv_pay = adv_pay;
		this.in_date = in_date;
		this.out_date = out_date;
		this.treatment = treatment;
		this.presc = presc;
	}
	
	public int getPid() {
		return pid;
	}
	
	public void setPid(int pid) {
		this.pid = pid;
	}
	
	public int getRoom_no() {
		return room_no;
	}
	
	public void setRoom_no(int room_no) {
		this.room_no = room_no;
	}
	
	public int getReport_no() {
		return report_no;
	}
	
	public void setReport_no(int report_no) {
		this.report_no = report_no;
	}
	
	public int getBill_no() {
		return bill_no;
	}
	
	public void setBill_no(int bill_no) {
		this.bill_no = bill_no;
	}
	
	public int getAdv_pay() {
		return adv_pay;
	}
	
	public void setAdv_pay(int adv_pay) {
		this.adv_pay = adv_pay;
	}
	
	public Date getIn_date() {
		return in_date;
	}
	
	public void setIn_date(Date in_date) {
		this.in_date = in_date;
	}
	
	public Date getOut_date() {
		return out_date;
	}
	
	public void setOut_date(Date out_date) {
		this.out_date = out_date;
	}
	
	public String getTreatment() {
		return treatment;
	}
	
	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}
	
	public String getPresc() {
		return presc;
	}
	
	public void setPresc(String presc) {
		this.presc = presc;
	}
	
	

}
