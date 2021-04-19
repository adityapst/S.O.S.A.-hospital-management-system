package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Utils.ConnectionUtil;
import application.Add_Staff_Controller;
import application.Staff;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class Doc_Home_Controller implements Initializable {
	
	@FXML
    private Label Staff_id;
    
    @FXML
    private Label DOB;
    
    @FXML
    private Label Staff_name;
    
    @FXML
    private Label salary;
    
    @FXML
    private Label phone_no;
    
    @FXML
    private Label desg;
    
    @FXML
    private Label dept;
    
    @FXML
    private Button In_Patienthistory;
    
    @FXML
    private Button Out_Patienthistory;
    
    @FXML
    private Button MedReports;
    
    @FXML
	 private Button Settings;
    
    String query = null;
    Connection connection = null ;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;
    Doc_home doc_obj=null;
    
    int userId;
	public String Phone_No;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		userId=CurrentStatus.getCs().getStaff_id();
		Phone_No=CurrentStatus.getCs().getPh_no();
		loadDate();		
	}
	private void loadDate() {
    	connection=ConnectionUtil.ConDB();
    	 try {
             query = "SELECT * FROM staff WHERE STAFF_ID="+userId;
             preparedStatement = connection.prepareStatement(query);
             resultSet = preparedStatement.executeQuery();
             
             while (resultSet.next()){
            	 Staff_id.setText(resultSet.getString("STAFF_ID"));
            	 DOB.setText(resultSet.getString("DOB"));
            	 Staff_name.setText(resultSet.getString("ST_NAME"));
            	 salary.setText(resultSet.getString("SALARY"));
            	 phone_no.setText(resultSet.getString("PH_NO"));
            	 desg.setText(resultSet.getString("DESIG"));
            	 dept.setText(resultSet.getString("DEPT"));
             }
         } catch (SQLException ex) {
        	 System.out.println("Error");
//             Logger.getLogger(med_report_controller.class.getName()).log(Level.SEVERE, null, ex);
         }
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
	
	public void MedReports(ActionEvent event) {
		try {
            //add you loading or delays - ;-)
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            //stage.setMaximized(true);
//            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("doctor_med_reports.fxml")));
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
