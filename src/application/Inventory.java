package application;

public class Inventory {
	
	int goods_id;
	String P_Name;
	int Qty;
	public Inventory(int goods_id, String p_Name, int qty) {
		super();
		this.goods_id = goods_id;
		P_Name = p_Name;
		Qty = qty;
	}
	
	public int getGoods_id() {
		return goods_id;
	}
	
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	
	public String getP_Name() {
		return P_Name;
	}
	
	public void setP_Name(String p_Name) {
		P_Name = p_Name;
	}
	
	public int getQty() {
		return Qty;
	}
	
	public void setQty(int qty) {
		Qty = qty;
	}
	
	

}
