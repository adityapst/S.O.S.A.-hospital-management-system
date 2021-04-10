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

public class Main extends Application 
{

    
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		try 
		{
			Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
			
			//we gonna remove the borderless thingie.  
	        primaryStage.initStyle(StageStyle.DECORATED);
			Scene scene = new Scene(root,900,716);
			primaryStage.setScene(scene);
			primaryStage.show();
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

