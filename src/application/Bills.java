package application;

public class Bills {
	int bill_no,room_charge,treatment_charge,medicinal_charge,net_amount;

	public Bills(int bill_no, int room_charge, int treatment_charge, int medicinal_charge, int net_amount) {
		super();
		this.bill_no = bill_no;
		this.room_charge = room_charge;
		this.treatment_charge = treatment_charge;
		this.medicinal_charge = medicinal_charge;
		this.net_amount = net_amount;
	}

	public int getBill_no() {
		return bill_no;
	}

	public void setBill_no(int bill_no) {
		this.bill_no = bill_no;
	}

	public int getRoom_charge() {
		return room_charge;
	}

	public void setRoom_charge(int room_charge) {
		this.room_charge = room_charge;
	}

	public int getTreatment_charge() {
		return treatment_charge;
	}

	public void setTreatment_charge(int treatment_charge) {
		this.treatment_charge = treatment_charge;
	}

	public int getMedicinal_charge() {
		return medicinal_charge;
	}

	public void setMedicinal_charge(int medicinal_charge) {
		this.medicinal_charge = medicinal_charge;
	}

	public int getNet_amount() {
		return net_amount;
	}

	public void setNet_amount(int net_amount) {
		this.net_amount = net_amount;
	}
	
	
}
