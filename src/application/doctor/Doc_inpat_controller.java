package application.doctor;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

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
import javafx.scene.control.cell.PropertyValueFactory;
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
	private TableColumn<Patient_In,String>adv_pay;
	
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
	
	
	String query = null;
    Connection connection = null ;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;
    Patient_In pin=null;
    
    ObservableList<Patient_In>Patient_In_list= FXCollections.observableArrayList();
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		loadDate_In();		
	}
	private void loadDate_In() {
    	connection=ConnectionUtil.ConDB();
    	 try {
    		 Patient_In_list.clear();
             
             query = "SELECT * FROM in_pat";
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
                       resultSet.getString("PRESC"),
                       resultSet.getInt("ADV_PAY")));
            	 
                 
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
    	 adv_pay.setCellValueFactory(new PropertyValueFactory<>("adv_pay"));
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
	
	public void Edit(ActionEvent event) {
		try {
    		FXMLLoader loader=new FXMLLoader(getClass().getResource("doctor_inpatient_button_edithistory.fxml"));
        	Parent root=loader.load();
        	Add_Inpatient_Controller add_controller=loader.getController();
        	
            //Node node = (Node) event.getSource();
            //Stage stage = (Stage) node.getScene().getWindow();
            //stage.setMaximized(true);
//            stage.close();
            //Scene scene = new Scene(FXMLLoader.load(getClass().getResource("patient_details.fxml")));
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } 
        catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
	}
}
