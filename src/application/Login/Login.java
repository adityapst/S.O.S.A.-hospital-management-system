package application.Login;
	
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import javafx.fxml.FXMLLoader;


public class Login extends Application 
{
	@Override
	public void start(Stage primaryStage) 
	{
		//define your offsets here
//	    private double xOffset = 0;
//	    private double yOffset = 0;
	    
		try 
		{
			Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
			
			//we gonna remove the borderless thingie.
            primaryStage.initStyle(StageStyle.DECORATED);
            primaryStage.setMaximized(false);
            Scene scene = new Scene(root,1000,716);
            primaryStage.setScene(scene);
            primaryStage.show();
            
	        
			
//			//grab your root here
//	        root.setOnMousePressed(new EventHandler<MouseEvent>() {
//	            @Override
//	            public void handle(MouseEvent event) {
//	                xOffset = event.getSceneX();
//	                yOffset = event.getSceneY();
//	            }
//	        });
//
//	        //sorry about that - Windows defender issue.
//	        //move around here
//	        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
//	            @Override
//	            public void handle(MouseEvent event) {
//	                primaryStage.setX(event.getScreenX() - xOffset);
//	                primaryStage.setY(event.getScreenY() - yOffset);
//	            }
//	        });
			
		}
		
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}
