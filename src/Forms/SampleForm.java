package Forms;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SampleForm extends Application
{
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		try 
		{
			Parent root = FXMLLoader.load(getClass().getResource("SampleForm.fxml"));
			Scene scene = new Scene(root,1000,716);
			
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
