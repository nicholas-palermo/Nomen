package nomen;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginControllers {

	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void switchToSignIn(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("/Nomen/screens/SignInScreen.fxml"));
		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void switchToSignUp(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("/Nomen/screens/SignUpScreen.fxml"));
		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void switchToStartUp(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("/Nomen/screens/StartUpScreen.fxml"));
		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
