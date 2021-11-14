package nomen.screens;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import nomen.Database;

public class SignUpControllers {

	
	Database db = new Database();

	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void switchToStartUp(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("/Nomen/screens/StartUpScreen.fxml"));
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
	public void switchToCompSignUp(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("/Nomen/screens/CompSignUpScreen.fxml"));
		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void switchToHrSignUp(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("/Nomen/screens/HrSignUpScreen.fxml"));
		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	@FXML TextField EIN;
	public void signUp(ActionEvent event) throws IOException {
		Alert errorAlert = new Alert(AlertType.ERROR);
		System.out.println(EIN.getText());
		if(!db.CompanyExists(EIN.getText())) {
			//System.out.print("Company doesnt exist");
			//Stage stage = (Stage) ((Node) e.getTarget()).getScene().getWindow();
			//stage.setScene(compSignup());
			root = FXMLLoader.load(getClass().getResource("/Nomen/screens/CompSignUp.fxml"));
			stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}else {	//error pop up
				errorAlert.setHeaderText("Error");
				errorAlert.setContentText("Invalid Company already exists.");
				errorAlert.showAndWait();
		}
	}
	
	@FXML TextField stateID, localID, compName, empNum, oName, oEmail;
	public void compSignUp(ActionEvent event) throws IOException{
		Alert errorAlert = new Alert(AlertType.ERROR);
		if(!db.InsertCompD(stateID.getText(), localID.getText(), compName.getText(), empNum.getText(), 
				oName.getText(), oEmail.getText())) {
			//System.out.print("Company doesnt exist");
			//Stage stage = (Stage) ((Node) e.getTarget()).getScene().getWindow();
			//stage.setScene(hrSignup());
			root = FXMLLoader.load(getClass().getResource("/Nomen/screens/HrSignUp.fxml"));
			stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}else {	//error pop up
				errorAlert.setHeaderText("Error");
				errorAlert.setContentText("Invalid input please retype and try again.");
				errorAlert.showAndWait();
		}
	}
	
	@FXML TextField name, ssn, password, confirm, pTy, pAm;
	public void HrSignUp(ActionEvent event) throws IOException {
		Alert errorAlert = new Alert(AlertType.ERROR);
		if(password.getText().equals(confirm.getText())) {//password check
			if(!db.InsertEmp(password.getText(), name.getText(), ssn.getText(),"HR", pTy.getText(), pAm.getText())) {
				//System.out.print("Company doesnt exist");
				db.use.seteName(name.getText());
				//Stage stage = (Stage) ((Node) e.getTarget()).getScene().getWindow();
				//stage.setScene(pinfoSignup());
				
				showFinalSignUp();
				
			}else {	//error pop up
				errorAlert.setHeaderText("Error");
				errorAlert.setContentText("Invalid input please retype and try again.");
				errorAlert.showAndWait();
			}
		}else{
			errorAlert.setHeaderText("Error");
			errorAlert.setContentText("Passwords do not match");
			errorAlert.showAndWait();
		}
	}
	
	@FXML TextField address, pNumber, email, dis;
	public void pInfoSignUp(ActionEvent event) throws IOException {
		Alert errorAlert = new Alert(AlertType.ERROR);
		if(!db.InsertPinfo(db.use.getEmpID(db.use.eName),db.use.eName,address.getText(),pNumber.getText(),
				email.getText(),dis.getText())) {
			//Stage stage = (Stage) ((Node) e.getTarget()).getScene().getWindow();
			//stage.setScene(finalSignup());
			
			showFinalSignUp();
			
		}else {	//error pop up
			errorAlert.setHeaderText("Error");
			errorAlert.setContentText("Invalid input please retype and try again.");
			errorAlert.showAndWait();
		}
	}
	
	public Stage showFinalSignUp() throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Nomen/screens/FinalSignUp.fxml"));
		
		Stage stage = new Stage();
		stage.setScene(new Scene(loader.load()));
		
		String s = "Your Id number is "+db.getID(db.use.eName, db.ein)+"\n"
				   + "your password is "+db.getPass(db.use.eName, db.ein);
		
		FinalSignUpController controller = loader.getController();
		controller.initData(s);
		
		stage.show();
		return stage;
	}
	
	

	
	
	
}
