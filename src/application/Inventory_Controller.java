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

public class Inventory_Controller implements Initializable {
	
	@FXML
	private Button Adminhome;
	
	@FXML
	private Button refresh;
	
	@FXML
	private Button Staff;
	
	@FXML
	private Button PatientHistory;
	
	@FXML
	private Button Bills;
	
	@FXML
	private Button Rooms;
	
	@FXML
	private Button MedReports;
	
	@FXML
	private Button Settings;
	
	@FXML
	private Button add;
	
	@FXML
	private TableView<Inventory> inventory;
	
	@FXML
	private TableColumn<Inventory,String>good_id;
	
	@FXML
	private TableColumn<Inventory,String>p_name;
	
	@FXML
	private TableColumn<Inventory,String>qty;
	
	String query = null;
    Connection connection = null ;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;
    Inventory inv=null;
    
    ObservableList<Inventory>Inventory_list= FXCollections.observableArrayList();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		loadDate();
	}
	private void loadDate() {
    	connection=ConnectionUtil.ConDB();
    	 try {
    		 Inventory_list.clear();
             
             query = "SELECT * FROM Inventory";
             preparedStatement = connection.prepareStatement(query);
             resultSet = preparedStatement.executeQuery();
             
             while (resultSet.next()){
            	 int good_id=resultSet.getInt("GOODS_ID");
            	 String name=resultSet.getString("P_NAME");
            	 int quant=resultSet.getInt("QTY");
//            	 int net=medicineCharge+treatmentCharge+roomcharge;
            	 
            	 boolean add=Inventory_list.add(new  Inventory(good_id,name,quant));
            	 inventory.setItems(Inventory_list);
             }
                        
         } catch (SQLException ex) {
        	 ex.printStackTrace();
//             Logger.getLogger(med_report_controller.class.getName()).log(Level.SEVERE, null, ex);
         }
    	 good_id.setCellValueFactory(new PropertyValueFactory<>("goods_id"));
    	 p_name.setCellValueFactory(new PropertyValueFactory<>("p_Name"));
    	 qty.setCellValueFactory(new PropertyValueFactory<>("qty"));
    }
	
	public void  refresh(ActionEvent event) {
		loadDate();
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
    
    public void add(ActionEvent event) {
    	try {
    		FXMLLoader loader=new FXMLLoader(getClass().getResource("admin_inventory_add_item.fxml"));
        	Parent root=loader.load();
        	Add_Item_Controller add_controller=loader.getController();
        	
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
