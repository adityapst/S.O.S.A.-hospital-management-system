package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Utils.ConnectionUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;

public class Add_Item_Controller implements Initializable  {
	
	@FXML
	private Button save;
	
	@FXML
	private Button edit;
	
	@FXML
	private TextField Goodsid;
	
	@FXML
	private TextField ProductName;
	
	@FXML
	private TextField Qty;
	
	@FXML
	private Button remove;
	
	@FXML
	private Label Addnew;
	
	String query = null;
    Connection connection = null ;
    PreparedStatement preparedStatement = null ;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	}
	
	public void save(ActionEvent event) {
		connection=ConnectionUtil.ConDB();
        try {
			PreparedStatement st= connection.prepareStatement("INSERT INTO INVENTORY (GOODS_ID,P_NAME,Qty) values(?,?,?)");
			int num=Integer.parseInt(Goodsid.getText());
			st.setInt(1,num);
			String s=ProductName.getText();
			st.setString(2,s);
			int n=Integer.parseInt(Qty.getText());
			st.setInt(3,n);
			int res=st.executeUpdate();
			Goodsid.clear();
			ProductName.clear();
			Qty.clear();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void remove(ActionEvent event) {
		connection=ConnectionUtil.ConDB();
		try {
	       	 int nw=Integer.parseInt(Goodsid.getText());
	       	 PreparedStatement st= connection.prepareStatement("DELETE STAFF WHERE INVENTORY WHERE GOODS_ID="+nw);
				int res=st.executeUpdate();
				if(res>0) {
					setAddnew(Color.GREEN,"Item Deleted !!");
				}
				else setAddnew(Color.TOMATO,"Something Went Wrong :/");
//				Staff_Id.clear();
//		    	Staff_controller stff=new Staff_controller(); 
//		    	stff.loadDate();	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				setAddnew(Color.TOMATO,"Error Ocuured");
				e.printStackTrace();
			}
	}
	public void edit(ActionEvent event) {
		connection=ConnectionUtil.ConDB();
        try {
        	int num=Integer.parseInt(Goodsid.getText());
			String s=ProductName.getText();
			int n=Integer.parseInt(Qty.getText());
			PreparedStatement st= connection.prepareStatement("UPDATE INVENTORY SET QTY="+n+" where GOODS_ID="+num+" and P_NAME='"+s+"'");
			Goodsid.clear();
			ProductName.clear();
			Qty.clear();
			int res=st.executeUpdate();
			if(res<=0) {
				System.out.println("Wrong input!!!");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void setAddnew(Color color,String text) {
    	Addnew.setTextFill(color);
    	Addnew.setText(text);
    	System.out.println(text);
    }
	
}
