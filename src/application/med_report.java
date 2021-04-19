package application;

public class med_report {
	
	int report_no;
	int staff_id;
	String dis_diag;
	String BP;
	int temp,weight,pulse;
	
	public med_report(int report_no, int staff_id, String dis_diag, String bP, int temp, int weight, int pulse) {
		super();
		this.report_no = report_no;
		this.staff_id = staff_id;
		this.dis_diag = dis_diag;
		BP = bP;
		this.temp = temp;
		this.weight = weight;
		this.pulse = pulse;
	}
	
	public int getReport_no() {
		return report_no;
	}
	
	public void setReport_no(int report_no) {
		this.report_no = report_no;
	}
	
	public int getStaff_id() {
		return staff_id;
	}
	
	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}
	
	public String getDis_diag() {
		return dis_diag;
	}
	
	public void setDis_diag(String dis_diag) {
		this.dis_diag = dis_diag;
	}
	
	public String getBP() {
		return BP;
	}
	
	public void setBP(String bP) {
		BP = bP;
	}
	
	public int getTemp() {
		return temp;
	}
	
	public void setTemp(int temp) {
		this.temp = temp;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public int getPulse() {
		return pulse;
	}
	
	public void setPulse(int pulse) {
		this.pulse = pulse;
	}
}
