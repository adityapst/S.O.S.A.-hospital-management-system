package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import Utils.ConnectionUtil;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LoginController implements Initializable 
{
//	private Label label;
    @FXML
    private Label lbl_close;
    
    @FXML
    private Label lblErrors;
    
    @FXML
    private TextField txtUsername;
    
    @FXML
    private TextField txtPassword;
    
    @FXML
    private Button BtnSignin;
    
//    @FXML
//    private Button BtnSignup;
    
//    @FXML
//    private Label btnForgot;
    
    Connection con=null;
    PreparedStatement preparedStatement=null;
    ResultSet resultSet=null;
    
    String designation;
    public void getPerson(String Person) {
    	designation=Person;
    }
    
    public void lbl_Close(MouseEvent event) {
    	System.exit(0);
    }
    
    public void BtnSignin(ActionEvent event) {
    	if(logIn(designation).equals("Success")) {
    		if(designation.equals("Patient")) {
    			try {
    			  CurrentStatus.getCs().setMember_uid(Integer.parseInt(txtUsername.getText()));
    			  CurrentStatus.getCs().setPh_no(txtPassword.getText());
              	  FXMLLoader loader=new FXMLLoader(getClass().getResource("patient_details.fxml"));
              	  Parent root=loader.load();
              	  patient_details_controller patient_controller=loader.getController();
//                  patient_controller.showInfo(txtUsername.getText(),txtPassword.getText());
                  
                  Stage stage=new Stage();
                  stage.setScene(new Scene(root));
                  stage.show();
  
              } 
              catch (IOException ex) {
                  System.err.println(ex.getMessage());
              }
    		}
            if(designation.equals("Doctor")) {
            try {
            	CurrentStatus.getCs().setStaff_id(Integer.parseInt(txtUsername.getText()));
            	CurrentStatus.getCs().setPh_no(txtPassword.getText());
              	FXMLLoader loader=new FXMLLoader(getClass().getResource("doctor_home.fxml"));
              	Parent root=loader.load();
              	Doc_Home_Controller dr_controller=loader.getController();
                  Stage stage=new Stage();
                  stage.setScene(new Scene(root));
                  stage.show();
  
              } 
              catch (IOException ex) {
                  System.err.println(ex.getMessage());
              }	
    		}
            if(designation.equals("Receptionist")) {
            	try {
            		CurrentStatus.getCs().setStaff_id(Integer.parseInt(txtUsername.getText()));
                	CurrentStatus.getCs().setPh_no(txtPassword.getText());
                  	FXMLLoader loader=new FXMLLoader(getClass().getResource("reception_home.fxml"));
                  	Parent root=loader.load();
                  	Reception_home_controller rec_controller=loader.getController();
                      Stage stage=new Stage();
                      stage.setScene(new Scene(root));
                      stage.show();
      
                  } 
                  catch (IOException ex) {
                      System.err.println(ex.getMessage());
                  }
    		}
            if(designation.equals("Admin")) {
            	try {
            		CurrentStatus.getCs().setStaff_id(Integer.parseInt(txtUsername.getText()));
                	CurrentStatus.getCs().setPh_no(txtPassword.getText());
                  	FXMLLoader loader=new FXMLLoader(getClass().getResource("admin_home.fxml"));
                  	Parent root=loader.load();
                  	Admin_home_controller admin_controller=loader.getController();
                      Stage stage=new Stage();
                      stage.setScene(new Scene(root));
                      stage.show();
      
                  } 
                  catch (IOException ex) {
                      System.err.println(ex.getMessage());
                  }
    		}
    	}
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
    	//To do
    	if(con==null) {
    		lblErrors.setTextFill(Color.TOMATO);
    		lblErrors.setText("Server Error: Check!!");
    	}
    	else 
    	{
    		lblErrors.setTextFill(Color.GREEN);
    		lblErrors.setText("Server is Up: Good to go");
    	}
    }
    public LoginController() {
    	con=ConnectionUtil.ConDB();
    }
    private String logIn_patient() {
    	String status="Success";
    	String userId=txtUsername.getText().toString();
    	String password=txtPassword.getText().toString();
    	if(userId.isEmpty() || password.isEmpty()) {
    		setLblError(Color.TOMATO,"Empty Credentials");
    		status="Error";
    	}
    	//query
    	else 
    	{
    	   String sql="SELECT * FROM patient where p_id= "+userId+" and ph_no= '"+password+"'";
    	   try {
    		  preparedStatement= con.prepareStatement(sql);
//    		  preparedStatement.setString(1, userId);
//    		  preparedStatement.setString(2, password);
    		  resultSet=preparedStatement.executeQuery();
    		  if(!resultSet.next()) {
    			  setLblError(Color.TOMATO,"Enter correct UserId/Password");
    			  status="Error";
    		   }
    		   else 
    		   {
    			 setLblError(Color.GREEN,"Login Successful...Redirecting");
    		   }
    	    }
    	    catch(Exception ex) {
    		   System.err.println(ex.getMessage());
    		   status="Exception";
    	    }
    	}
    	return status;
    }
    
    private String logIn(String designation) {
    	String status="Success";
    	String userId=txtUsername.getText().toString();
    	String password=txtPassword.getText().toString();
    	if(userId.isEmpty() || password.isEmpty()) {
    		setLblError(Color.TOMATO,"Empty Credentials");
    		status="Error";
    	}
    	//query
    	else 
    	{
    	   String sql=null;
    	   
    	   if(designation.equals("Doctor")) {
    		   sql="SELECT * FROM STAFF where STAFF_ID= "+userId+" and ph_no= '"+password+"' AND DESIG='Doctor'";
    	   }
    	   
    	   if(designation.equals("Patient")) {
    		   sql="SELECT * FROM patient where p_id= "+userId+" and ph_no= '"+password+"'";
    	   }
    	   
    	   if(designation.equals("Admin")) {
    		   sql="SELECT * FROM STAFF where STAFF_ID= "+userId+" and ph_no= '"+password+"' AND DESIG='Admin'";
    	   }
    	   
    	   if(designation.equals("Receptionist")) {
    		   sql="SELECT * FROM STAFF where STAFF_ID= "+userId+" and ph_no= '"+password+"' AND DESIG='Receptionist'";
    	   }
    	   
    	   try 
    	   {
    		  preparedStatement= con.prepareStatement(sql);
//    		  preparedStatement.setString(1, userId);
//    		  preparedStatement.setString(2, password);
    		  resultSet=preparedStatement.executeQuery();
    		  if(!resultSet.next()) {
    			  setLblError(Color.TOMATO,"Enter correct UserId/Password");
    			  status="Error";
    		   }
    		   else 
    		   {
    			 setLblError(Color.GREEN,"Login Successful...Redirecting");
    		   }
    	    }
    	    catch(Exception ex) {
    		   System.err.println(ex.getMessage());
    		   status="Exception";
    	    }
    	}
    	return status;
    }
    
    private String logIn_Staff() {
    	String status="Success";
    	String userId=txtUsername.getText().toString();
    	String password=txtPassword.getText().toString();
    	if(userId.isEmpty() || password.isEmpty()) {
    		setLblError(Color.TOMATO,"Empty Credentials");
    		status="Error";
    	}
    	//query
    	else 
    	{
    	   String sql="SELECT * FROM staff where staff_id= "+userId+" and ph_no= '"+password+"'";
    	   try {
    		  preparedStatement= con.prepareStatement(sql);
//    		  preparedStatement.setString(1, userId);
//    		  preparedStatement.setString(2, password);
    		  resultSet=preparedStatement.executeQuery();
    		  if(!resultSet.next()) {
    			  setLblError(Color.TOMATO,"Enter correct UserId/Password");
    			  status="Error";
    		   }
    		   else 
    		   {
    			 setLblError(Color.GREEN,"Login Successful...Redirecting");
    		   }
    	    }
    	    catch(Exception ex) {
    		   System.err.println(ex.getMessage());
    		   status="Exception";
    	    }
    	}
    	return status;
    }
   
    private void setLblError(Color color,String text) {
    	lblErrors.setTextFill(color);
    	lblErrors.setText(text);
    	System.out.println(text);
    }

}
 