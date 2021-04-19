package application;

import java.io.IOException;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Doc_MedRep_Controller implements Initializable  {
	
	@FXML
	private Button save;
	
	@FXML
	private Button reset;
	
	@FXML
	private Button In_Patienthistory;
	
	@FXML
	private Button Out_Patienthistory;
	
	@FXML
	private Button Settings;
	
	@FXML
	private Button DoctorHome;
	
	@FXML
	private TextField Staff_Id;
	
	@FXML
	private TextField Report_No;
	
	@FXML
	private TextField P_Id;
	
	@FXML
	private TextField Bp;
	
	@FXML
	private TextField disdiag;
	
	@FXML
	private TextField temp;
	
	@FXML
	private TextField weight;
	
	@FXML
	private TextField pulse;
	
	String query = null;
    Connection connection = null ;
    PreparedStatement preparedStatement = null ;
    
    int userId;
	public String Phone_No;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		userId=CurrentStatus.getCs().getStaff_id();
		Phone_No=CurrentStatus.getCs().getPh_no();
	}
	
	public void save(ActionEvent event) {
		connection=ConnectionUtil.ConDB();
        try {
        	 query="SELECT MAX(REPORT_NO) FROM MED_REP";
        	 preparedStatement = connection.prepareStatement(query);
        	 ResultSet resultSet = preparedStatement.executeQuery();
        	 int nw=0;
        	 while(resultSet.next()) {
        		 nw=resultSet.getInt("Max(REPORT_NO)");
        	 }
			PreparedStatement st= connection.prepareStatement("INSERT INTO MED_REP (REPORT_NO,STAFF_ID,DIS_DIAG,BP,TEMP,WEIGHT,PULSE,P_ID) values(?,?,?,?,?,?,?,?)");
			int Sid=Integer.parseInt(Staff_Id.getText());
			String ds=disdiag.getText();
			String bp=Bp.getText();
			int tmp=Integer.parseInt(temp.getText());
			int wt=Integer.parseInt(weight.getText());
			int pul=Integer.parseInt(pulse.getText());
			int pid=Integer.parseInt(P_Id.getText());
			nw++;
			st.setInt(1,nw);
			st.setInt(2,Sid);
			st.setString(3,ds);
			st.setString(4,bp);
			st.setInt(5,tmp);
			st.setInt(6,wt);
			st.setInt(7,pul);
			st.setInt(8,pid);
			int res=st.executeUpdate();
			Report_No.setText(String.valueOf(nw));
			Staff_Id.clear();
			disdiag.clear();
			Bp.clear();
			temp.clear();
			weight.clear();
			pulse.clear();
			P_Id.clear();
			Report_No.clear();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void reset(ActionEvent event) {
		Staff_Id.clear();
		disdiag.clear();
		Bp.clear();
		temp.clear();
		weight.clear();
		pulse.clear();
		P_Id.clear();
		Report_No.clear();
	}
	
	public void In_Patienthistory(ActionEvent event) {
		try {
            //add you loading or delays - ;-)
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            //stage.setMaximized(true);
//            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("doctor_inpatient_history.fxml")));
            stage.setScene(scene);
            stage.show();
        } 
        catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
	}
	
	public void Out_Patienthistory(ActionEvent event) {
		try {
            //add you loading or delays - ;-)
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            //stage.setMaximized(true);
//            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("doctor_outpatient_history.fxml")));
            stage.setScene(scene);
            stage.show();
        } 
        catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
	}
	
	public void DoctorHome(ActionEvent event) {
		try {
            //add you loading or delays - ;-)
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            //stage.setMaximized(true);
//            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("doctor_home.fxml")));
            stage.setScene(scene);
            stage.show();
        } 
        catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
	}
	
	public void Settings(ActionEvent event) {
		try {
            //add you loading or delays - ;-)
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            //stage.setMaximized(true);
//            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Settings.fxml")));
            stage.setScene(scene);
            stage.show();
        } 
        catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
	}
}
