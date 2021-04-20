package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Patient_Add_Details_Controller implements Initializable  {
	
	@FXML
	private Button save;
	
	@FXML
	private Button reset;
	
	@FXML
	private TextField P_ID;
	
	@FXML
	private TextField NAME;
	
	@FXML
	private TextField DOB;
	
	@FXML
	private TextField BLOOD_GRP;
	
	@FXML
	private TextField GENDER;
	
	@FXML
	private TextField  PH_NO;
	
	@FXML
	private Button ReceptionHome;
	
	@FXML
	private Button OutPatient;
	
	@FXML
	private Button Rooms;
	
	@FXML
	private Button InPatient;
	
	@FXML
	private Button settings;
	
	@FXML
	private Button Bills;

	
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
        	 query="SELECT MAX(P_ID) FROM PATIENT";
        	 preparedStatement = connection.prepareStatement(query);
        	 ResultSet resultSet = preparedStatement.executeQuery();
        	 int nw=0;
        	 while(resultSet.next()) {
        		 nw=resultSet.getInt("Max(P_ID)");
        	 }
			PreparedStatement st= connection.prepareStatement("INSERT INTO PATIENT (P_ID,NAME,DOB, BLOOD_GRP,GENDER,PH_NO) values(?,?,?,?,?,?)");
			String s=NAME.getText();
			String d=DOB.getText();
			String bp=BLOOD_GRP.getText();
			String gen=GENDER.getText();
			String gn=PH_NO.getText();
			nw++;
			st.setInt(1,nw);
			st.setString(2,s);
			st.setString(3,d);
			st.setString(4,bp);
			st.setString(5,gen);
			st.setString(6,gn);
			int res=st.executeUpdate();
			P_ID.setText(String.valueOf(nw));
//			Staff_Id.clear();
//	    	Staff_controller stff=new Staff_controller(); 
//	    	stff.loadDate();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void reset(ActionEvent event) {
		P_ID.clear();
    	DOB.clear();
    	NAME.clear();
    	BLOOD_GRP.clear();
    	GENDER.clear();
    	PH_NO.clear();
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
	
	public void InPatient(ActionEvent event) {
		try {
            //add you loading or delays - ;-)
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            //stage.setMaximized(true);
//            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("reception_patient_add_inpatient.fxml")));
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
	
	

}
