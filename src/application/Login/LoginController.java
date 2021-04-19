package application.Login;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
//import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class LoginController implements Initializable 
{
//	private Label label;
    @FXML
    private Label lbl_close;
    
    public void handleButtonAction(MouseEvent event) //there was ActionEvent before MouseEvent
    {
    	if (event.getSource() == lbl_close)
    	{
    		System.exit(0);
    	}

//        if (event.getSource() == btnSignin) {
//            //login here
//            if (logIn().equals("Success")) {
//                try {
//
//                    //add you loading or delays - ;-)
//                    Node node = (Node) event.getSource();
//                    Stage stage = (Stage) node.getScene().getWindow();
//                    //stage.setMaximized(true);
//                    stage.close();
//                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/fxml/OnBoard.fxml")));
//                    stage.setScene(scene);
//                    stage.show();
//
//                } catch (IOException ex) {
//                    System.err.println(ex.getMessage());
//                }
//
//            }
//        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
    	//To do
    }

}
