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
    
    public void lbl_Close(MouseEvent event) {
    	System.exit(0);
    }
    public void BtnSignin(ActionEvent event) {
    	if (logIn().equals("Success")) {
            try {
                //add you loading or delays - ;-)
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                //stage.setMaximized(true);
                stage.close();
                Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Inventory.fxml")));
                stage.setScene(scene);
                stage.show();

            } 
            catch (IOException ex) {
                System.err.println(ex.getMessage());
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
    private String logIn() {
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
    	   String sql="SELECT * FROM users where username= '"+userId+"' and password= '"+password+"'";
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
 