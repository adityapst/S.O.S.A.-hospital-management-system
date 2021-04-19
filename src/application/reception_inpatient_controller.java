package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Utils.ConnectionUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class reception_inpatient_controller implements Initializable {
	
	private static final int NULL = 0;

	@FXML
	private TextField l1;
	
	@FXML
	private TextField l2;
	
	@FXML
	private TextField l3;
	
	@FXML
	private TextField l4;
	
	@FXML
	private TextField l5;
	
	@FXML
	private TextField l6;
	
	@FXML
	private TextField l7;
	
	@FXML
	private TextField l8;
	
	@FXML
	private Button reset;
	
	@FXML
	private Button save;
	
	@FXML
	private Button ReceptionHome;
	
	@FXML
	private Button OutPatient;
	
	@FXML
	private Button Bills;
	
	@FXML
	private Button Rooms;
	
	@FXML
	private Button settings;
	
	
	String query = null;
    Connection connection = null ;
    PreparedStatement preparedStatement = null ;
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void save(ActionEvent event) {
		connection=ConnectionUtil.ConDB();
        try {
        	 int pid=Integer.parseInt(l1.getText());
        	 String in_date=l2.getText();
        	 int reportNo=Integer.parseInt(l3.getText());
        	 int room_no=Integer.parseInt(l4.getText());
        	 String out_date=l5.getText();
        	 String treat=l6.getText();
        	 String presc=l7.getText();
        	 int adv_pay=Integer.parseInt(l8.getText());
        	 PreparedStatement st= connection.prepareStatement("INSERT INTO IN_PAT (PID,IN_DATE,REPORT_NO,BILL_NO,ROOM_NO,OUT_DATE,TREAT,PRESC,ADV_PAY) values(?,?,?,?,?,?,?,?,?)");
        	 st.setInt(1,pid);
        	 st.setString(2,in_date);
        	 st.setInt(3,reportNo);
        	 st.setInt(4,NULL);
        	 st.setInt(5,room_no);
        	 st.setString(6,out_date);
        	 st.setString(7,treat);
        	 st.setString(8,presc);
        	 st.setInt(9,adv_pay);
        	 int res=st.executeUpdate(); 
        	l1.clear();
     		l2.clear();
     		l3.clear();
     		l4.clear();
     		l5.clear();
     		l6.clear();
     		l7.clear();
     		l8.clear();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void reset(ActionEvent event) {
		l1.clear();
		l2.clear();
		l3.clear();
		l4.clear();
		l5.clear();
		l6.clear();
		l7.clear();
		l8.clear();
	}
	
	public void ReceptionHome(ActionEvent event) {
		try {
            //add you loading or delays - ;-)
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            //stage.setMaximized(true);
//            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("reception_home.fxml")));
            stage.setScene(scene);
            stage.show();

        } 
        catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
	}
	
	public void OutPatient(ActionEvent event) {
		try {
            //add you loading or delays - ;-)
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            //stage.setMaximized(true);
//            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("reception_patient_add_outpatient.fxml")));
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
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("reception_bills.fxml")));
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
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("reception_rooms.fxml")));
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
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("settings.fxml")));
            stage.setScene(scene);
            stage.show();

        } 
        catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
	}
}
