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
	private TableColumn<Bills,String>BILL_NO;
	
	@FXML
	private TableColumn<Bills,String>ROOM_CHARGE;
	
	@FXML
	private TableColumn<Bills,String>TREAT_CHARGE;
	
	@FXML
	private TableColumn<Bills,String>MED_CHARGE;
	
	@FXML
	private TableColumn<Bills,String>Net_Amount;
	
	int userId;
	public String Phone_No;
	
	String query = null;
    Connection connection = null ;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;
    Bills bills=null;
	
    ObservableList<Bills>bills_list= FXCollections.observableArrayList();
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
    	userId=CurrentStatus.getCs().getMember_uid();
		Phone_No=CurrentStatus.getCs().getPh_no();
    	loadDate();
	}
    
    private void loadDate() {
    	connection=ConnectionUtil.ConDB();
    	 try {
    		 bills_list.clear();
             
             query = "SELECT UNIQUE B.BILL_NO,B.ROOM_CHARGE,B.TREAT_CHARGE,B.MED_CHARGE,NET_AMT FROM BILL B,IN_PAT I,OUT_PAT O where (B.BILL_NO=I.BILL_NO and I.PID="+userId+") OR (O.BILL_NO=B.BILL_NO AND O.PID="+userId+")";
             preparedStatement = connection.prepareStatement(query);
             resultSet = preparedStatement.executeQuery();
             
             while (resultSet.next()){
            	 int billno=resultSet.getInt("BILL_NO");
            	 int roomcharge=resultSet.getInt("ROOM_CHARGE");
            	 int treatmentCharge=resultSet.getInt("TREAT_CHARGE");
            	 int medicineCharge=resultSet.getInt("MED_CHARGE");
            	 int net=resultSet.getInt("NET_AMT");
            	 
            	 boolean add=bills_list.add(new  Bills(billno,roomcharge,treatmentCharge,medicineCharge,net));
            	 Bill_Report.setItems(bills_list);
             }
                        
         } catch (SQLException ex) {
        	 System.out.println("Error");
//             Logger.getLogger(med_report_controller.class.getName()).log(Level.SEVERE, null, ex);
         }
    	 BILL_NO.setCellValueFactory(new PropertyValueFactory<Bills,String>("bill_no"));
    	 ROOM_CHARGE.setCellValueFactory(new PropertyValueFactory<Bills,String>("room_charge"));
    	 TREAT_CHARGE.setCellValueFactory(new PropertyValueFactory<Bills,String>("treatment_charge"));
    	 MED_CHARGE.setCellValueFactory(new PropertyValueFactory<Bills,String>("medicinal_charge"));
    	 Net_Amount.setCellValueFactory(new PropertyValueFactory<Bills,String>("net_amount"));
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
