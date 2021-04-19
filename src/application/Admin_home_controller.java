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

public class Admin_home_controller implements Initializable {
	@FXML
	private Button Inventory;
	
	@FXML
	private Button Staff;
	
	@FXML
	private Button PatientHistory;
	
	@FXML
	private Button Bills;
	
	@FXML
	private Button Rooms;
	
	@FXML
	private Button MedReports;
	
	@FXML
	private Button Settings;
	
	@FXML
	private Label AdminId;
	
	@FXML
	private Label Name;
	
	@FXML
	private Label Dob;
	
	@FXML
	private Label Phone;
	
	@FXML
	private Label Desig;
	
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
			
            query = "SELECT STAFF_ID,ST_NAME,DOB,PH_NO,DESIG FROM staff where STAFF_ID="+userId;
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()){
            	AdminId.setText(resultSet.getString("STAFF_ID"));
            	Name.setText(resultSet.getString("ST_NAME"));
            	Dob.setText(resultSet.getString("DOB"));
            	Phone.setText(resultSet.getString("PH_NO"));
            	Desig.setText(resultSet.getString("DESIG"));
            }
        } catch (SQLException ex) {
       	 System.out.println("Error");
//            Logger.getLogger(med_report_controller.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
	public void MedReports(ActionEvent event) {
    	try {
            //add you loading or delays - ;-)
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            //stage.setMaximized(true);
//            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("admin_med_reports.fxml")));
            stage.setScene(scene);
            stage.show();

        } 
        catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
	}
	
    public void Staff(ActionEvent event) {
    	try {
            //add you loading or delays - ;-)
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            //stage.setMaximized(true);
//            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("admin_staff.fxml")));
            stage.setScene(scene);
            stage.show();

        } 
        catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
	}
    
    public void PatientHistory(ActionEvent event) {
    	try {
            //add you loading or delays - ;-)
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            //stage.setMaximized(true);
//            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("admin_patient_history.fxml")));
            stage.setScene(scene);
            stage.show();

        } 
        catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
	}
	
    public void Bills(ActionEvent event) {
    	try {
            //add you loading or delays - ;-)
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            //stage.setMaximized(true);
//            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("admin_bills.fxml")));
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
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("admin_rooms.fxml")));
            stage.setScene(scene);
            stage.show();

        } 
        catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
	}
    
    public void Inventory(ActionEvent event) {
    	try {
            //add you loading or delays - ;-)
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            //stage.setMaximized(true);
//            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("admin_inventory.fxml")));
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
