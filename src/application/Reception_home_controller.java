package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Utils.ConnectionUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Reception_home_controller implements Initializable{
	
	@FXML
	private Label StaffId;
	
	@FXML
	private Label StaffName;
	
	@FXML
	private Label Dob;
	
	@FXML
	private Label Salary;
	
	@FXML
	private Label PhoneNo;
	
	@FXML
	private Label Desig;
	
	@FXML
	private Label Dept;
	
	@FXML
	private Button Bills;
	
	@FXML
	private Button OutPatient;
	
	@FXML
	private Button Rooms;
	
	@FXML
	private Button InPatient;
	
	@FXML
	private Button settings;
	
	int userId;
	public String Phone_No;
	
	String query = null;
    Connection connection = null ;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		userId=CurrentStatus.getCs().getStaff_id();
		Phone_No=CurrentStatus.getCs().getPh_no();
		loadData();
	}
	private void loadData(){
		connection=ConnectionUtil.ConDB();
		try {
			
            query = "SELECT STAFF_ID,ST_NAME,DOB,PH_NO,DESIG,SALARY,DEPT FROM staff where STAFF_ID="+userId;
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()){
            	StaffId.setText(resultSet.getString("STAFF_ID"));
            	StaffName.setText(resultSet.getString("ST_NAME"));
            	Dob.setText(resultSet.getString("DOB"));
            	PhoneNo.setText(resultSet.getString("PH_NO"));
            	Desig.setText(resultSet.getString("DESIG"));
            	Salary.setText(resultSet.getString("SALARY"));
            	Dept.setText(resultSet.getString("DEPT"));
            }
        } catch (SQLException ex) {
       	 System.out.println("Error");
//            Logger.getLogger(med_report_controller.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	public void Bills(ActionEvent event) {
		try {
            //add you loading or delays - ;-)
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            //stage.setMaximized(true);
//            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("reception_bills.fxml")));
            stage.setScene(scene);
            stage.show();

        } 
        catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
	}
	
	public void OutPatient(ActionEvent event) {
		try {
            //add you loading or delays - ;-)
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            //stage.setMaximized(true);
//            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("reception_patient_add_outpatient.fxml")));
            stage.setScene(scene);
            stage.show();

        } 
        catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
	}
	
	public void Rooms(ActionEvent event) {
		try {
            //add you loading or delays - ;-)
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            //stage.setMaximized(true);
//            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("reception_rooms.fxml")));
            stage.setScene(scene);
            stage.show();

        } 
        catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
	}
	
	public void InPatient(ActionEvent event) {
		try {
            //add you loading or delays - ;-)
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            //stage.setMaximized(true);
//            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("reception_patient_add_inpatient.fxml")));
            stage.setScene(scene);
            stage.show();

        } 
        catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
	}
	
	public void settings(ActionEvent event) {
		try {
            //add you loading or delays - ;-)
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            //stage.setMaximized(true);
//            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("settings.fxml")));
            stage.setScene(scene);
            stage.show();

        } 
        catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
	}
}
