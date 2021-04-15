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

public class patient_bills_controller implements Initializable {
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
	
	@FXML
	private TableView<Bills> Bill_Report;
	
	@FXML
	private TableColumn<Bills,String>Bill_No;
	
	@FXML
	private TableColumn<Bills,String>Room_Charge;
	
	@FXML
	private TableColumn<Bills,String>Treatment_Charge;
	
	@FXML
	private TableColumn<Bills,String>Medicine_Charge;
	
	@FXML
	private TableColumn<Bills,String>Net_Amount;
	
	public String userId,Phone_No;
	
	public void showInfo(String name,String Phone) {
		userId=name;
		Phone_No=Phone;
	}
	
	String query = null;
    Connection connection = null ;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;
    Bills bills=null;
	
    ObservableList<Bills>bills_list= FXCollections.observableArrayList();
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
    	loadDate();
	}
    
    private void loadDate() {
    	connection=ConnectionUtil.ConDB();
    	 try {
    		 bills_list.clear();
             
             query = "SELECT * FROM bill";
             preparedStatement = connection.prepareStatement(query);
             resultSet = preparedStatement.executeQuery();
             
             while (resultSet.next()){
            	 boolean add=bills_list.add(new  Bills(
                         resultSet.getInt("Bill_No"),
                         resultSet.getInt("Room_Charge"),
                         resultSet.getInt("Treatment_Charge"),
                         resultSet.getInt("Medicine_Charge"),
                         resultSet.getInt("Net_Amount")));
            	 Bill_Report.setItems(bills_list);
                 
             }
             
             
         } catch (SQLException ex) {
        	 System.out.println("Error");
//             Logger.getLogger(med_report_controller.class.getName()).log(Level.SEVERE, null, ex);
         }
    	 Bill_No.setCellValueFactory(new PropertyValueFactory<>("Bill_No"));
    	 Room_Charge.setCellValueFactory(new PropertyValueFactory<>("Room_Charge"));
    	 Treatment_Charge.setCellValueFactory(new PropertyValueFactory<>("Treatment_Charge"));
    	 Medicine_Charge.setCellValueFactory(new PropertyValueFactory<>("Medicine_Charge"));
    	 Net_Amount.setCellValueFactory(new PropertyValueFactory<>("Net_Amount"));
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
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("patient_history.fxml")));
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
