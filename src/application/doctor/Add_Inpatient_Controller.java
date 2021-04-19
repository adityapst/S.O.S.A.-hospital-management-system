package application.doctor;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Utils.ConnectionUtil;
import application.Staff_controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Add_Inpatient_Controller implements Initializable{
	
	@FXML
	private TextField Pid;
	
	@FXML
	private TextField In_Date;
	
	@FXML
	private TextField Treatment;
	
	@FXML
	private TextField Prescription;
	
	@FXML
	private Button Save;
	
	@FXML
	private Button Reset;
	
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
        	 int p=Integer.parseInt(Pid.getText());
        	 String in=In_Date.getText();
        	 String pres=Prescription.getText();
        	 String treat=Treatment.getText();
        	 query="UPDATE IN_PAT SET PRES='"+pres+"'"+"where pid="+p+"and IN_DATE='"+in+"'";
        	 preparedStatement = connection.prepareStatement(query);
        	 int res=preparedStatement.executeUpdate();
        	 query="UPDATE IN_PAT SET TREAT='"+treat+"'"+"where pid="+p+"and IN_DATE='"+in+"'";
        	 preparedStatement = connection.prepareStatement(query);
        	 res=preparedStatement.executeUpdate();
        	 Pid.clear();
     		 In_Date.clear();
     		 Treatment.clear();
     		 Prescription.clear();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void reset(ActionEvent event) {
		Pid.clear();
		In_Date.clear();
		Treatment.clear();
		Prescription.clear();
	}
}
