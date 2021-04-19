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

public class HomeController implements Initializable  {
	
	@FXML
	private Button doc;
	
	@FXML
	private Button staff;
	
	@FXML
	private Button pat;
	
	@FXML
	private Button rcp;
	
	public void doc(ActionEvent event) {
		try {
            //add you loading or delays - ;-)
//            Node node = (Node) event.getSource();
//            Stage stage = (Stage) node.getScene().getWindow();
            //stage.setMaximized(true);
//            stage.close();
            FXMLLoader loader=new FXMLLoader(getClass().getResource("Login.fxml"));
        	Parent root=loader.load();
        	LoginController controller=loader.getController();
            controller.getPerson("Doctor");
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.show();
//            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Login.fxml")));
//            stage.setScene(scene);
//            stage.show();

        } 
        catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
	}
	
	public void staff(ActionEvent event) {
		try {
			FXMLLoader loader=new FXMLLoader(getClass().getResource("Login.fxml"));
        	Parent root=loader.load();
        	LoginController controller=loader.getController();
            controller.getPerson("Admin");
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            //add you loading or delays - ;-)
//            Node node = (Node) event.getSource();
//            Stage stage = (Stage) node.getScene().getWindow();
            //stage.setMaximized(true);
//            stage.close();
//            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Login.fxml")));
//            stage.setScene(scene);
//            stage.show();

        } 
        catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
	}
	
	public void pat(ActionEvent event) {
		try {
			FXMLLoader loader=new FXMLLoader(getClass().getResource("Login.fxml"));
        	Parent root=loader.load();
        	LoginController controller=loader.getController();
            controller.getPerson("Patient");
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            //add you loading or delays - ;-)
//            Node node = (Node) event.getSource();
//            Stage stage = (Stage) node.getScene().getWindow();
            //stage.setMaximized(true);
//            stage.close();
//            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Login.fxml")));
//            stage.setScene(scene);
//            stage.show();

        } 
        catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
	}
	
	public void rcp(ActionEvent event) {
		try {
			FXMLLoader loader=new FXMLLoader(getClass().getResource("Login.fxml"));
        	Parent root=loader.load();
        	LoginController controller=loader.getController();
            controller.getPerson("Receptionist");
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            //add you loading or delays - ;-)
//            Node node = (Node) event.getSource();
//            Stage stage = (Stage) node.getScene().getWindow();
            //stage.setMaximized(true);
//            stage.close();
//            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Login.fxml")));
//            stage.setScene(scene);
//            stage.show();

        } 
        catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
}
