package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Utils.ConnectionUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class visit_details_controller implements Initializable {
	
	@FXML
	private Button home;
	
	@FXML
	private Button visith;
	
	@FXML
	private Button medrpt;
	
	@FXML
	private Button bill;
	
	@FXML
	private Button settings;
	
	
	// In Patient
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
	
	
	// Out Patient
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
	
	
	int userId;
	public String Phone_No;
	
	String query = null;
    Connection connection = null ;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;
    Patient_In pin=null;
    Patient_Out pout=null;
    
    ObservableList<Patient_In>Patient_In_list= FXCollections.observableArrayList();
    
    ObservableList<Patient_Out>Patient_Out_list= FXCollections.observableArrayList();
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
    	userId=CurrentStatus.getCs().getMember_uid();
		Phone_No=CurrentStatus.getCs().getPh_no();
    	loadDate_In();
    	loadDate_Out();
	}
    
    private void loadDate_In() {
    	connection=ConnectionUtil.ConDB();
    	 try {
    		 Patient_In_list.clear();
             
             query = "SELECT * FROM in_pat where PID="+userId;
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
    
    private void loadDate_Out() {
    	connection=ConnectionUtil.ConDB();
    	 try {
    		 Patient_Out_list.clear();
             
             query = "SELECT * FROM out_pat where PID="+userId;
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
	
	public void home(ActionEvent event) {
		try {
            //add you loading or delays - ;-)
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            //stage.setMaximized(true);
//            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("patient_details.fxml")));
            stage.setScene(scene);
            stage.show();

        } 
        catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
	}
	
	public void visith(ActionEvent event) {
		try {
            //add you loading or delays - ;-)
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            //stage.setMaximized(true);
//            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("patient_visit_details.fxml")));
            stage.setScene(scene);
            stage.show();

        } 
        catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
	}
	
	public void medrpt(ActionEvent event) {
		try {
            //add you loading or delays - ;-)
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            //stage.setMaximized(true);
//            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("patient_med_report.fxml")));
            stage.setScene(scene);
            stage.show();

        } 
        catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
	}
	
	public void bill(ActionEvent event) {
		try {
            //add you loading or delays - ;-)
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            //stage.setMaximized(true);
//            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("patient_bills.fxml")));
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
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("patient_details.fxml")));
            stage.setScene(scene);
            stage.show();

        } 
        catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
	}
	


}
