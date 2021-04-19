package application.doctor;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Utils.ConnectionUtil;
import application.Patient_In;
import application.Patient_Out;
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

public class Doc_Out_controller implements Initializable {
	
	@FXML
	private TableView<Patient_Out> Pateint_Out_Details;

	@FXML
	private TableColumn<Patient_In,String>pid_op;
	
	@FXML
	private TableColumn<Patient_In,String>in_date_op;
	
	@FXML
	private TableColumn<Patient_In,String>report_no_op;
	
	@FXML
	private TableColumn<Patient_In,String>bill_no_op;
	
	@FXML
	private TableColumn<Patient_In,String>treatment_op;
	
	@FXML
	private TableColumn<Patient_In,String>presc_op;
	
	@FXML
	private Button Doctor_Home;
	    
	 @FXML
	 private Button In_Patienthistory;
	    
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
    Patient_Out pout=null;
    
    ObservableList<Patient_Out>Patient_Out_list= FXCollections.observableArrayList();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		loadDate_Out();		
	}
	private void loadDate_Out() {
    	connection=ConnectionUtil.ConDB();
    	 try {
    		 Patient_Out_list.clear();
             
             query = "SELECT * FROM out_pat";
             preparedStatement = connection.prepareStatement(query);
             resultSet = preparedStatement.executeQuery();
             
             while (resultSet.next()){
            	 boolean add=Patient_Out_list.add(new  Patient_Out(
                         resultSet.getInt("PID"),
                         resultSet.getDate("IN_DATE"),
                         resultSet.getInt("REPORT_NO"),
                         resultSet.getInt("BILL_NO"),
                         resultSet.getString("TREAT"),
                         resultSet.getString("PRESC")));
            	 
                 
             }
             Pateint_Out_Details.setItems(Patient_Out_list);
             
             
         } catch (SQLException ex) {
        	 System.out.println("Error");
//             Logger.getLogger(med_report_controller.class.getName()).log(Level.SEVERE, null, ex);
         }
    	 pid_op.setCellValueFactory(new PropertyValueFactory<>("pid"));
    	 in_date_op.setCellValueFactory(new PropertyValueFactory<>("in_date"));
    	 report_no_op.setCellValueFactory(new PropertyValueFactory<>("report_no"));
    	 bill_no_op.setCellValueFactory(new PropertyValueFactory<>("bill_no"));
    	 treatment_op.setCellValueFactory(new PropertyValueFactory<>("treatment"));
    	 presc_op.setCellValueFactory(new PropertyValueFactory<>("presc"));
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
    		FXMLLoader loader=new FXMLLoader(getClass().getResource("doctor_outpatient_button_edithistory.fxml"));
        	Parent root=loader.load();
        	Add_Outpatient_Controller add_controller=loader.getController();
        	
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
