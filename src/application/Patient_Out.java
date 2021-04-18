package application;

import java.sql.Date;

public class Patient_Out {
	int pid,room_no,report_no,bill_no;
	Date in_date;
	String treatment,presc;
	public Patient_Out(int pid, Date in_date, int report_no, int bill_no, String treatment, String presc) {
		super();
		this.pid = pid;
		this.report_no = report_no;
		this.bill_no = bill_no;
		this.in_date = in_date;
		this.treatment = treatment;
		this.presc = presc;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
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
	public Date getIn_date() {
		return in_date;
	}
	public void setIn_date(Date in_date) {
		this.in_date = in_date;
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
