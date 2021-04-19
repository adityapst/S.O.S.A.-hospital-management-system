package Forms;

import javafx.fxml.FXML;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class SampleFormController implements Initializable 
{
	@FXML
    private Label label;
	
	@FXML
	private void handleButtonAction(ActionEvent event) //there was ActionEvent before MouseEvent
    {
    	System.out.println("You clicked");
    	label.setText("Hellow World");
    	//    	if (event.getSource() == lbl_close)
//    	{
//    		System.exit(0);
//    	}
    }
	
	@Override
    public void initialize(URL url, ResourceBundle rb)
    {
    	//To do
    }
}