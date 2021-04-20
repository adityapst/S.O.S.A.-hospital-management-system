
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

public class admin_med_rep_controller implements Initializable {
	
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
	private TableView<admin_med_rep> Med_Report;
	
	@FXML
	private TableColumn<admin_med_rep,String>staff_id;
	
	@FXML
	private TableColumn<admin_med_rep,String>patient_id;
	
	@FXML
	private TableColumn<admin_med_rep,String>dis_diag;
	
	@FXML
	private TableColumn<admin_med_rep,String>BP;
	
	@FXML
	private TableColumn<admin_med_rep,String>temp;
	
	@FXML
	private TableColumn<admin_med_rep,String>report_no;
	
	@FXML
	private TableColumn<admin_med_rep,String>weight;
	
	@FXML
	private TableColumn<admin_med_rep,String>pulse;
	
	String query = null;
    Connection connection = null ;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;
    admin_med_rep report=null;
    
    ObservableList<admin_med_rep>report_list= FXCollections.observableArrayList();
    
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
            	 boolean add=report_list.add(new  admin_med_rep(
                         resultSet.getInt("REPORT_NO"),
                         resultSet.getInt("STAFF_ID"),
                         resultSet.getString("DIS_DIAG"),
                         resultSet.getString("BP"),
                         resultSet.getInt("TEMP"),
                         resultSet.getInt("WEIGHT"),
                         resultSet.getInt("PULSE"),
            			 resultSet.getInt("P_ID")));
            	 Med_Report.setItems(report_list);
                 
             }
             
             
         } catch (SQLException ex) {
        	 System.out.println("Error");
//             Logger.getLogger(med_report_controller.class.getName()).log(Level.SEVERE, null, ex);
         }
    	report_no.setCellValueFactory(new PropertyValueFactory<>("report_no"));
     	staff_id.setCellValueFactory(new PropertyValueFactory<>("staff_id"));
     	dis_diag.setCellValueFactory(new PropertyValueFactory<>("dis_diag"));
     	BP.setCellValueFactory(new PropertyValueFactory<>("BP"));
     	temp.setCellValueFactory(new PropertyValueFactory<>("temp"));
     	weight.setCellValueFactory(new PropertyValueFactory<>("weight"));
     	pulse.setCellValueFactory(new PropertyValueFactory<>("pulse"));
     	patient_id.setCellValueFactory(new PropertyValueFactory<>("patient_id"));
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

