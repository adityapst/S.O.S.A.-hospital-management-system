package application;

public class CurrentStatus {
	private final static CurrentStatus cs=new CurrentStatus();
	int member_uid;
	String ph_no;
	int Staff_id;
	
	private CurrentStatus() {
		
	}
	public int getMember_uid() {
		return member_uid;
	}
	public void setMember_uid(int member_uid) {
		this.member_uid = member_uid;
	}
	public String getPh_no() {
		return ph_no;
	}
	public void setPh_no(String ph_no) {
		this.ph_no = ph_no;
	}
	public static CurrentStatus getCs() {
		return cs;
	}
	public int getStaff_id() {
		return Staff_id;
	}
	public void setStaff_id(int staff_id) {
		Staff_id = staff_id;
	}
	
	

}
