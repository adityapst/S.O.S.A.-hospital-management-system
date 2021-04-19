package application;

public class Doc_home {
	int Staff_id;
	String Dob;
	String Staff_name;
	int salary;
	String Phone_no;
	String desg;
	String dept;
	public Doc_home(int staff_id, String dob, String staff_name, int salary, String phone_no, String desg,
			String dept) {
		super();
		Staff_id = staff_id;
		Dob = dob;
		Staff_name = staff_name;
		this.salary = salary;
		Phone_no = phone_no;
		this.desg = desg;
		this.dept = dept;
	}
	public int getStaff_id() {
		return Staff_id;
	}
	public void setStaff_id(int staff_id) {
		Staff_id = staff_id;
	}
	public String getDob() {
		return Dob;
	}
	public void setDob(String dob) {
		Dob = dob;
	}
	public String getStaff_name() {
		return Staff_name;
	}
	public void setStaff_name(String staff_name) {
		Staff_name = staff_name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getPhone_no() {
		return Phone_no;
	}
	public void setPhone_no(String phone_no) {
		Phone_no = phone_no;
	}
	public String getDesg() {
		return desg;
	}
	public void setDesg(String desg) {
		this.desg = desg;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	
}
