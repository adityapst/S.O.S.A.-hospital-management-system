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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class Staff_controller implements Initializable  {
	
	@FXML
	private Button Adminhome;
	
	@FXML
	private Button Bills;
	
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
	private Button add_new;
	
	@FXML
	private Button refresh;
	
	@FXML
	private Button remove;
	
	@FXML
	private TableView<Staff> staff;
	
	@FXML
	private TableColumn<Staff,String>staff_id;
	
	@FXML
	private TableColumn<Staff,String>DOB;
	
	@FXML
	private TableColumn<Staff,String>salary;
	
	@FXML
	private TableColumn<Staff,String>st_name;
	
	@FXML
	private TableColumn<Staff,String>ph_no;
	
	@FXML
	private TableColumn<Staff,String>desig;
	
	@FXML
	private TableColumn<Staff,String>dept;
	
	String query = null;
    Connection connection = null ;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;
    Staff staff_obj=null;
    
    ObservableList<Staff>staff_list= FXCollections.observableArrayList();
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		loadDate();		
	}
	
    
    private void loadDate() {
    	connection=ConnectionUtil.ConDB();
    	 try {
    		 staff_list.clear();
             
             query = "SELECT * FROM staff";
             preparedStatement = connection.prepareStatement(query);
             resultSet = preparedStatement.executeQuery();
             
             while (resultSet.next()){
            	 boolean add=staff_list.add(new  Staff(
                         resultSet.getInt("staff_id"),
                         resultSet.getDate("DOB"),
                         resultSet.getString("st_name"),
                         resultSet.getInt("salary"),
                         resultSet.getString("ph_no"),
                         resultSet.getString("desig"),
                         resultSet.getString("dept")));
            	 staff.setItems(staff_list); 
             }
             
             
         } catch (SQLException ex) {
        	 System.out.println("Error");
//             Logger.getLogger(med_report_controller.class.getName()).log(Level.SEVERE, null, ex);
         }
    	 staff_id.setCellValueFactory(new PropertyValueFactory<>("staff_id"));
    	 DOB.setCellValueFactory(new PropertyValueFactory<>("dOB"));
    	 st_name.setCellValueFactory(new PropertyValueFactory<>("st_name"));
    	 salary.setCellValueFactory(new PropertyValueFactory<>("salary"));
    	 ph_no.setCellValueFactory(new PropertyValueFactory<>("ph_no"));
    	 desig.setCellValueFactory(new PropertyValueFactory<>("desig"));
    	 dept.setCellValueFactory(new PropertyValueFactory<>("dept"));
    }
    
    public void refresh(ActionEvent event ) {
    	loadDate();
    }
    
    public void add(ActionEvent event) {
    	try {
    		FXMLLoader loader=new FXMLLoader(getClass().getResource("admin_add_new_staff.fxml"));
        	Parent root=loader.load();
        	Add_Staff_Controller add_controller=loader.getController();
        	
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
