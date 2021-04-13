/*
--module-path "C:\Users\Samarth Soni\Desktop\Java Projects\openjfx-16_windows-x64_bin-sdk\javafx-sdk-16\lib"
--add-modules javafx.controls,javafx.fxml
*/
package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.StageStyle;

/**
*
* @author Sammy Diesel
*/

public class Main extends Application 
{
	//define your offsets here
    private double xOffset = 0;
    private double yOffset = 0;
    
    
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		try 
		{
			Parent root = FXMLLoader.load(getClass().getResource("Login/Login.fxml"));
			
			//we gonna remove the borderless thingie.  
	        primaryStage.initStyle(StageStyle.DECORATED);
	        primaryStage.setMaximized(false);

	        //grab your root here
	        root.setOnMousePressed(new EventHandler<MouseEvent>() {
	            @Override
	            public void handle(MouseEvent event) {
	                xOffset = event.getSceneX();
	                yOffset = event.getSceneY();
	            }
	        });

	        //sorry about that - Windows defender issue.
	        //move around here
	        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
	            @Override
	            public void handle(MouseEvent event) {
	                primaryStage.setX(event.getScreenX() - xOffset);
	                primaryStage.setY(event.getScreenY() - yOffset);
	            }
	        });
			
			Scene scene = new Scene(root,1000,716);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} 
		
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
     * @param args the command line arguments
     */
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}

