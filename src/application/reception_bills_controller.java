package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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

public class reception_bills_controller implements Initializable  {
	
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
	private Button reset;
	
	@FXML
	private Button save;
	
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
	private Button AddPatient;
	
	
	int userId;
	public String Phone_No;
	
	String query = null;
    Connection connection = null ;
    PreparedStatement preparedStatement = null ;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		userId=CurrentStatus.getCs().getStaff_id();
		Phone_No=CurrentStatus.getCs().getPh_no();
	}
	
	public void save(ActionEvent event) {
		connection=ConnectionUtil.ConDB();
        try {
        	 int reportno=Integer.parseInt(l2.getText());
        	 int roomcharge=Integer.parseInt(l3.getText());
        	 int treatcharge=Integer.parseInt(l4.getText());
        	 int medcharge=Integer.parseInt(l5.getText());
        	 int total=roomcharge+treatcharge+medcharge;
        	 query="SELECT MAX(BILL_NO) FROM BILL";
        	 preparedStatement = connection.prepareStatement(query);
        	 ResultSet resultSet = preparedStatement.executeQuery();
        	 int nw=0;
        	 while(resultSet.next()) {
        		 nw=resultSet.getInt("Max(BILL_NO)");
        	 }
        	 nw++;
//        	 System.out.println("Line 99");
        	 PreparedStatement st= connection.prepareStatement("INSERT INTO bill (BILL_NO,ROOM_CHARGE,TREAT_CHARGE,MED_CHARGE,NET_AMT) values(?,?,?,?,?)");
        	 st.setInt(1,nw);
//        	 st.setInt(2,reportno);
        	 st.setInt(2,roomcharge);
        	 st.setInt(3,treatcharge);
        	 st.setInt(4,medcharge);
        	 st.setInt(5,total);
        	 int res=st.executeUpdate();
//        	 System.out.println("Line 108");
        	 st=connection.prepareStatement("UPDATE IN_PAT SET BILL_NO="+nw+" WHERE REPORT_NO="+reportno);
        	 res=st.executeUpdate();
//        	 System.out.println("Line 111");
        	 if(res<=0) {
        		 st=connection.prepareStatement("UPDATE OUT_PAT SET BILL_NO="+nw+" WHERE REPORT_NO="+reportno);
        		 res=st.executeUpdate();
//        		 System.out.println("Line 114");
        	 }
        	  Date date = new Date();  
        	  SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");  
        	  String strDate= formatter.format(date);  
        	l1.setText(String.valueOf(nw));
//        	System.out.println("UPDATE IN_PAT SET BILL NO="+nw+" where REPORT_NO="+l2.getText());
        	st= connection.prepareStatement("UPDATE IN_PAT SET BILL_NO="+nw+" where REPORT_NO="+l2.getText());
        	preparedStatement = connection.prepareStatement(query);
//        	System.out.println("Line 122");
        	res=st.executeUpdate();
        	if(res<=0) {
        		st= connection.prepareStatement("UPDATE OUT_PAT SET BILL_NO="+nw+" where REPORT_NO="+l2.getText());
        		preparedStatement = connection.prepareStatement(query);
        		res=st.executeUpdate();
        	}
//        	System.out.println("Line 124");
        	st= connection.prepareStatement("UPDATE IN_PAT SET OUT_DATE='"+strDate+"' where REPORT_NO="+l2.getText());
//        	System.out.println("Line 126");
        	res=st.executeUpdate();
//        	System.out.println("Line 128");
        	System.out.println("UPDATE IN_PAT SET BILL NO="+nw+" where REPORT_NO="+l2.getText());
		} catch (SQLException e) {
//			System.out.println("UPDATE IN_PAT SET BILL NO="+nw+" where REPORT_NO="+l2.getText());
			// TODO Auto-generated catch block
//			System.out.println("Line 133");
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
	
	public void AddPatient(ActionEvent event) {
		try {
            //add you loading or delays - ;-)
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            //stage.setMaximized(true);
//            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("reception_add_patient_details.fxml")));
            stage.setScene(scene);
            stage.show();

        } 
        catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
	}
}
