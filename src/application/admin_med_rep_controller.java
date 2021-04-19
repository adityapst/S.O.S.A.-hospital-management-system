
package application.Patient_view_details;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Utils.ConnectionUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class admin_med_rep_controller implements Initializable {
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
                         resultSet.getInt("report_no"),
                         resultSet.getInt("staff_id"),
                         resultSet.getInt("patient_id"),
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
     	patient_id.setCellValueFactory(new PropertyValueFactory<>("patient_id"));
     	weight.setCellValueFactory(new PropertyValueFactory<>("weight"));
     	pulse.setCellValueFactory(new PropertyValueFactory<>("pulse"));
     	dis_diag.setCellValueFactory(new PropertyValueFactory<>("dis_diag"));
     	BP.setCellValueFactory(new PropertyValueFactory<>("BP"));
     	temp.setCellValueFactory(new PropertyValueFactory<>("temp"));
    }

}

