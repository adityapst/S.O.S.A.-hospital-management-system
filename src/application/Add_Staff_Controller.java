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
import javafx.scene.control.TextField;

public class Add_Staff_Controller implements Initializable {
	@FXML
	private Button save;
	
	@FXML
	private Button reset;
	
	@FXML
	private TextField Staff_Id;
	
	@FXML
	private TextField DOB;
	
	@FXML
	private TextField St_Name;
	
	@FXML
	private TextField Salary;
	
	@FXML
	private TextField Ph_No;
	
	@FXML
	private TextField Desig;
	
	@FXML
	private TextField Dept;
	
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
        	 query="SELECT MAX(STAFF_ID) FROM STAFF";
        	 preparedStatement = connection.prepareStatement(query);
        	 ResultSet resultSet = preparedStatement.executeQuery();
        	 int nw=0;
        	 while(resultSet.next()) {
        		 nw=resultSet.getInt("Max(STAFF_ID)");
        	 }
			PreparedStatement st= connection.prepareStatement("INSERT INTO STAFF (Staff_Id,DOB,St_Name,Salary,Ph_No,Desig,Dept) values(?,?,?,?,?,?,?)");
			String d=DOB.getText();
			String s=St_Name.getText();
			int sal=Integer.parseInt(Salary.getText());
			String p=Ph_No.getText();
			String ds=Desig.getText();
			String dp=Dept.getText();
			st.setInt(1,nw+1);
			st.setString(2,d);
			st.setString(3,s);
			st.setInt(4,sal);
			st.setString(5,p);
			st.setString(6,ds);
			st.setString(7,dp);
			int res=st.executeUpdate();
			Staff_Id.clear();
	    	DOB.clear();
	    	St_Name.clear();
	    	Salary.clear();
	    	Ph_No.clear();
	    	Desig.clear();
	    	Dept.clear();
	    	Staff_controller stff=new Staff_controller(); 
	    			stff.loadDate();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 
    
    public void reset(ActionEvent event) {
    	Staff_Id.clear();
    	DOB.clear();
    	St_Name.clear();
    	Salary.clear();
    	Ph_No.clear();
    	Desig.clear();
    	Dept.clear();
    }
}
