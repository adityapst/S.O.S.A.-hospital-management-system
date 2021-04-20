package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import Utils.ConnectionUtil;
import application.Add_Staff_Controller;
import application.Patient_In;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Doc_inpat_controller implements Initializable {
	
	@FXML
	private TableView<Patient_In> Pateint_In_Details;
	
	@FXML
	private TableColumn<Patient_In,String>pid;
	
	@FXML
	private TableColumn<Patient_In,String>in_date;
	
	@FXML
	private TableColumn<Patient_In,String>out_date;
	
	@FXML
	private TableColumn<Patient_In,String>room_no;
	
	@FXML
	private TableColumn<Patient_In,String>report_no;
	
	@FXML
	private TableColumn<Patient_In,String>bill_no;
	
	@FXML
	private TableColumn<Patient_In,String>treatment;
	
	@FXML
	private TableColumn<Patient_In,String>presc;
	
	 @FXML
	 private Button Doctor_Home;
	    
	 @FXML
	 private Button Out_Patienthistory;
	    
	 @FXML
	 private Button MedReports;
	 
	 @FXML
	 private Button Edit;
	 
	 @FXML
	 private Button Settings;
	 
	 @FXML
	 private TextField Search;
	 
	 int userId;
	 public String Phone_No;
	
	
	String query = null;
    Connection connection = null ;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;
    Patient_In pin=null;
    
    ObservableList<Patient_In>Patient_In_list= FXCollections.observableArrayList();
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		userId=CurrentStatus.getCs().getStaff_id();
		Phone_No=CurrentStatus.getCs().getPh_no();
		loadDate_In();		
	}
	private void loadDate_In() {
    	connection=ConnectionUtil.ConDB();
    	 try {
    		 Patient_In_list.clear();
             
             query = "SELECT * FROM IN_PAT O,MED_REP MP where O.REPORT_NO=MP.REPORT_NO AND MP.STAFF_ID="+userId;
             preparedStatement = connection.prepareStatement(query);
             resultSet = preparedStatement.executeQuery();
             
             while (resultSet.next()){
            	 boolean add=Patient_In_list.add(new  Patient_In(
            			 resultSet.getInt("PID"),
                       resultSet.getDate("IN_DATE"),
                       resultSet.getInt("REPORT_NO"),
                       resultSet.getInt("BILL_NO"),
                       resultSet.getInt("ROOM_NO"),
                       resultSet.getDate("OUT_DATE"),
                       resultSet.getString("TREAT"),
                       resultSet.getString("PRESC")));
            	 
                 
             }
             Pateint_In_Details.setItems(Patient_In_list);
             
             
         } catch (SQLException ex) {
        	 System.out.println("Error");
//             Logger.getLogger(med_report_controller.class.getName()).log(Level.SEVERE, null, ex);
         }
    	 pid.setCellValueFactory(new PropertyValueFactory<>("pid"));
    	 in_date.setCellValueFactory(new PropertyValueFactory<>("in_date"));
    	 report_no.setCellValueFactory(new PropertyValueFactory<>("report_no"));
    	 bill_no.setCellValueFactory(new PropertyValueFactory<>("bill_no"));
    	 room_no.setCellValueFactory(new PropertyValueFactory<>("room_no"));
    	 out_date.setCellValueFactory(new PropertyValueFactory<>("out_date"));
    	 treatment.setCellValueFactory(new PropertyValueFactory<>("treatment"));
    	 presc.setCellValueFactory(new PropertyValueFactory<>("presc"));

    }
	
	public void Doctor_Home(ActionEvent event) {
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
	
	public void Search(KeyEvent event) {
		connection=ConnectionUtil.ConDB();
   	 try {
   		    Patient_In_list.clear();
   		    String ser=Search.getText();
   		    if(Pattern.matches("[0-9]{1,}", ser))
   		     	query = "SELECT * FROM IN_PAT O,MED_REP MP where O.REPORT_NO=MP.REPORT_NO AND MP.STAFF_ID="+userId+" and PID LIKE '"+Search.getText()+"%'";
   		    else query = "SELECT * FROM IN_PAT O,MED_REP MP where O.REPORT_NO=MP.REPORT_NO AND MP.STAFF_ID="+userId;
   		    preparedStatement = connection.prepareStatement(query);
   		    System.out.println(query);
            
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()){
           	 boolean add=Patient_In_list.add(new  Patient_In(
           			 resultSet.getInt("PID"),
                      resultSet.getDate("IN_DATE"),
                      resultSet.getInt("REPORT_NO"),
                      resultSet.getInt("BILL_NO"),
                      resultSet.getInt("ROOM_NO"),
                      resultSet.getDate("OUT_DATE"),
                      resultSet.getString("TREAT"),
                      resultSet.getString("PRESC")));
           	 
                
            }
            Pateint_In_Details.setItems(Patient_In_list);
            
            
        } catch (SQLException ex) {
       	 System.out.println("Error");
//            Logger.getLogger(med_report_controller.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
	
}
