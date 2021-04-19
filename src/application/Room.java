package application;

public class Room {
	int room_no;
	String room_type;
	int room_charge;
	int max_occ;
	public Room(int room_no, String room_type, int room_charge, int max_occ) {
		super();
		this.room_no = room_no;
		this.room_type = room_type;
		this.room_charge = room_charge;
		this.max_occ = max_occ;
	}
	public int getRoom_no() {
		return room_no;
	}
	public void setRoom_no(int room_no) {
		this.room_no = room_no;
	}
	public String getRoom_type() {
		return room_type;
	}
	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}
	public int getRoom_charge() {
		return room_charge;
	}
	public void setRoom_charge(int room_charge) {
		this.room_charge = room_charge;
	}
	public int getMax_occ() {
		return max_occ;
	}
	public void setMax_occ(int max_occ) {
		this.max_occ = max_occ;
	}
	
}
