package application.Patient_view_details;

import java.sql.Date;

public class Staff {
	int Staff_id;
	Date DOB;
	int salary;
	String st_name;
	String desig;
	String dept;
	String ph_no;
	public Staff(int staff_id, String st_name, Date dOB, int salary, String ph_no, String desig, String dept) {
		super();
		Staff_id = staff_id;
		DOB = dOB;
		this.salary = salary;
		this.st_name = st_name;
		this.desig = desig;
		this.dept = dept;
		this.ph_no = ph_no;
	}
	public int getStaff_id() {
		return Staff_id;
	}
	public void setStaff_id(int staff_id) {
		Staff_id = staff_id;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getSt_name() {
		return st_name;
	}
	public void setSt_name(String st_name) {
		this.st_name = st_name;
	}
	public String getDesig() {
		return desig;
	}
	public void setDesig(String desig) {
		this.desig = desig;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getPh_no() {
		return ph_no;
	}
	public void setPh_no(String ph_no) {
		this.ph_no = ph_no;
	}
	
	
	
	
	
	

}
