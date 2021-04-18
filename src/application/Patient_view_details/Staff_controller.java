package application.Patient_view_details;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Utils.ConnectionUtil;
import application.med_report;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Staff_controller implements Initializable  {
	
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
	private TableColumn<Staff,String>design;
	
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
             
             query = "SELECT * FROM med_rep";
             preparedStatement = connection.prepareStatement(query);
             resultSet = preparedStatement.executeQuery();
             
             while (resultSet.next()){
            	 boolean add=staff_list.add(new  Staff(
                         resultSet.getInt("staff_id"),
                         resultSet.getString("st_name"),
                         resultSet.getDate("DOB"),
                         resultSet.getInt("salary"),
                         resultSet.getString("ph_no"),
                         resultSet.getString("design"),
                         resultSet.getString("dept")));
            	 staff.setItems(staff_list);
                 
             }
             
             
         } catch (SQLException ex) {
        	 System.out.println("Error");
//             Logger.getLogger(med_report_controller.class.getName()).log(Level.SEVERE, null, ex);
         }
    	 staff_id.setCellValueFactory(new PropertyValueFactory<>("staff_id"));
    	 st_name.setCellValueFactory(new PropertyValueFactory<>("st_name"));
    	 DOB.setCellValueFactory(new PropertyValueFactory<>("DOB"));
    	 salary.setCellValueFactory(new PropertyValueFactory<>("salary"));
    	 ph_no.setCellValueFactory(new PropertyValueFactory<>("ph_no"));
    	 design.setCellValueFactory(new PropertyValueFactory<>("design"));
    	 dept.setCellValueFactory(new PropertyValueFactory<>("dept"));
    }





}
