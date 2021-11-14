package nomen.screens;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// for employee/manager account menu
public class AccountMenuController {

	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void logout(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("/Nomen/screens/StartUpScreen.fxml"));
		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void goToTimeSheet(ActionEvent event) throws IOException {
		// go to time sheet
		// pass parameters so that once it reaches the time table screen, it loads that specific employee's time table
		root = FXMLLoader.load(getClass().getResource("/Nomen/screens/TimeTable.fxml"));
		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	// HR methods
	public void goToIEM(ActionEvent event) throws IOException {

		root = FXMLLoader.load(getClass().getResource("/Nomen/screens/InputEmpMenu.fxml"));
		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void goToEEM(ActionEvent event) throws IOException {

		root = FXMLLoader.load(getClass().getResource("/Nomen/screens/EditEmpMenu.fxml"));
		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void goToCalcSal(ActionEvent event) throws IOException {

		root = FXMLLoader.load(getClass().getResource("/Nomen/screens/CalculateSalary.fxml"));
		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
