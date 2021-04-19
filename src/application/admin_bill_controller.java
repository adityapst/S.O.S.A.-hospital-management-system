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

public class admin_bill_controller implements Initializable {
	
	@FXML
	private Button Adminhome;
	
	@FXML
	private Button Staff;
	
	@FXML
	private Button PatientHistory;
	
	@FXML
	private Button MedReports;
	
	@FXML
	private Button Rooms;
	
	@FXML
	private Button Inventory;
	
	@FXML
	private Button Settings;
	
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
		userId=CurrentStatus.getCs().getStaff_id();
		Phone_No=CurrentStatus.getCs().getPh_no();
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
    
	public void Adminhome(ActionEvent event) {
		try {
            //add you loading or delays - ;-)
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            //stage.setMaximized(true);
//            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("admin_home.fxml")));
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
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("settings.fxml")));
            stage.setScene(scene);
            stage.show();

        } 
        catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }


    
    
    
    
    

}
