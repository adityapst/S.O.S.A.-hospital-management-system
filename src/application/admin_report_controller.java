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

public class admin_report_controller implements Initializable {
	@FXML
	private Button Adminhome;
	
	@FXML
	private Button Staff;
	
	@FXML
	private Button PatientHistory;
	
	@FXML
	private Button Bills;
	
	@FXML
	private Button Rooms;
	
	@FXML
	private Button Inventory;
	
	@FXML
	private Button Settings;
	
	@FXML
	private TableView<med_report> Med_Report;
	
	@FXML
	private TableColumn<med_report,String>staff_id;
	
	@FXML
	private TableColumn<med_report,String>dis_diag;
	
	@FXML
	private TableColumn<med_report,String>BP;
	
	@FXML
	private TableColumn<med_report,String>temp;
	
	@FXML
	private TableColumn<med_report,String>report_no;
	
	@FXML
	private TableColumn<med_report,String>weight;
	
	@FXML
	private TableColumn<med_report,String>pulse;
	
	String query = null;
    Connection connection = null ;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;
    med_report report=null;
    
    ObservableList<med_report>report_list= FXCollections.observableArrayList();
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
    	loadDate();
	}
    
    private void loadDate() {
    	connection=ConnectionUtil.ConDB();
    	 try {
    		 report_list.clear();
             
             query = "SELECT * FROM med_rep";
             preparedStatement = connection.prepareStatement(query);
             resultSet = preparedStatement.executeQuery();
             
             while (resultSet.next()){
            	 boolean add=report_list.add(new  med_report(
                         resultSet.getInt("report_no"),
                         resultSet.getInt("staff_id"),
                         resultSet.getString("dis_diag"),
                         resultSet.getString("BP"),
                         resultSet.getInt("temp"),
                         resultSet.getInt("weight"),
                         resultSet.getInt("pulse")));
            	 Med_Report.setItems(report_list);
                 
             }
             
             
         } catch (SQLException ex) {
        	 System.out.println("Error");
//             Logger.getLogger(med_report_controller.class.getName()).log(Level.SEVERE, null, ex);
         }
    	report_no.setCellValueFactory(new PropertyValueFactory<>("report_no"));
     	staff_id.setCellValueFactory(new PropertyValueFactory<>("staff_id"));
     	weight.setCellValueFactory(new PropertyValueFactory<>("weight"));
     	pulse.setCellValueFactory(new PropertyValueFactory<>("pulse"));
     	dis_diag.setCellValueFactory(new PropertyValueFactory<>("dis_diag"));
     	BP.setCellValueFactory(new PropertyValueFactory<>("BP"));
     	temp.setCellValueFactory(new PropertyValueFactory<>("temp"));
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
