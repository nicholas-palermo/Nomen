package nomen.screens;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import nomen.Database;

// login controller
public class LoginControllers {
	
	Database db = new Database();

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
	public void switchToAccountPage(ActionEvent event) throws IOException {
		/*
		 * Here it will need to be checked whether the user logging in is an employee, HR, or manager
		 * and switch to the according account menu
		 */
		String url = "/Nomen/screens/";
		// if (account == employee) 
		url += "acMenuHR.fxml";
		root = FXMLLoader.load(getClass().getResource(url));
		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	
	@FXML TextField username;
	@FXML TextField password;
	// login code
	public void login(ActionEvent e) throws IOException {
		Alert errorAlert = new Alert(AlertType.ERROR);
		if(db.loginCheck(username.getText(), password.getText())) {//checks if username and password true
			switchToAccountPage(e);
			//Stage stage = (Stage) submit.getScene().getWindow();
			//stage.setScene(accMenuEmp());
			System.out.print(db.use.getALv());
		}else {//error pop up
			errorAlert.setHeaderText("Error");
			errorAlert.setContentText("Invalid Username or Password.");
			errorAlert.showAndWait();
		}
	}
}
