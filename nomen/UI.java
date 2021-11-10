package nomen;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UI extends Application{
	
	Database db = new Database();
	
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub

		primaryStage.setTitle("Nomen");

		// begin application on the login screen
		Scene scene1 = firstScreen();
		primaryStage.setScene(scene1);
		primaryStage.show();
	}
	
	/**
	 * opening screen with sign in and sign up buttons
	 * @return login screen
	 */
	public Scene firstScreen() {
		Label title = new Label("NOMEN");
		
		// navigates to sign in screen
		Button signIn = new Button("Login");
		signIn.setOnAction(e->{
			Stage stage = (Stage) ((Node) e.getTarget()).getScene().getWindow();
			stage.setScene(logInScreen());
			}
		);
		
		// navigates to sign up screen
		Button signUp = new Button("Sign up");
		signUp.setOnAction(e->{
			Stage stage = (Stage) ((Node) e.getTarget()).getScene().getWindow();
			stage.setScene(signUpScreen());
			});
		
		HBox buttons = new HBox();
		buttons.getChildren().addAll(signIn, signUp);
		buttons.setSpacing(20);
		
		VBox layout1 = new VBox();
		layout1.getChildren().addAll(title, buttons);
		layout1.setSpacing(20);
		Scene scene1 = new Scene(layout1, 500,500);
		return scene1;
	}
	
	/**
	 * sign up screen for creating an account
	 * @return sign up screen
	 */
	public Scene signUpScreen() {
		Label title = new Label("Sign Up");
		
		TextField EIN = new TextField("EIN");
		Alert errorAlert = new Alert(AlertType.ERROR);
		
		Button submit = new Button("Submit");
		submit.setOnAction(e->{
			if(!db.CompanyExists(EIN.getText())) {
				//System.out.print("Company doesnt exist");
				Stage stage = (Stage) ((Node) e.getTarget()).getScene().getWindow();
				stage.setScene(compSignup());
			}else {	//error pop up
					errorAlert.setHeaderText("Error");
					errorAlert.setContentText("Invalid Company already exists.");
					errorAlert.showAndWait();
			}
		});
		// navigates back to the first screen
		Button back = new Button("Return");
		back.setOnAction(e->{
			Stage stage = (Stage) ((Node) e.getTarget()).getScene().getWindow();
			stage.setScene(firstScreen());
			});
		
		HBox buttons = new HBox();
		buttons.getChildren().addAll(submit, back);
		buttons.setSpacing(20);
		
		VBox layout = new VBox();
		layout.getChildren().addAll(title, EIN, buttons);
		layout.setSpacing(20);
		Scene scene = new Scene(layout, 500, 500);
		return scene;
	}
	/*
	 * Continued from signup this screen puts the company into the DB
	 * */
	public Scene compSignup() {
		Label title = new Label("Sign Up");
		
		TextField stateID = new TextField("State ID");
		TextField localID = new TextField("Local ID");
		TextField name = new TextField("Company Name");
		TextField empNum = new TextField("Number of employees");
		TextField oName = new TextField("Owner's Name");
		TextField oEmail = new TextField("Owner's Email");
		Alert errorAlert = new Alert(AlertType.ERROR);
		
		Button submit = new Button("Submit");
		submit.setOnAction(e->{
			if(!db.InsertCompD(stateID.getText(), localID.getText(), name.getText(), empNum.getText(), oName.getText(), oEmail.getText())) {
				//System.out.print("Company doesnt exist");
				Stage stage = (Stage) ((Node) e.getTarget()).getScene().getWindow();
				stage.setScene(hrSignup());
			}else {	//error pop up
					errorAlert.setHeaderText("Error");
					errorAlert.setContentText("Invalid input please retype and try again.");
					errorAlert.showAndWait();
			}
		});
		
		Button exit = new Button("Exit");
		exit.setOnAction(e->{
			Stage stage = (Stage) ((Node) e.getTarget()).getScene().getWindow();
			stage.setScene(firstScreen());
			});
		
		VBox layout = new VBox();
		layout.getChildren().addAll(title, stateID,localID,name,empNum,oName,oEmail, submit,exit);
		layout.setSpacing(20);
		Scene scene = new Scene(layout, 500, 500);
		return scene;
	}
	/*
	 * continued from compSignup now the head of hr is being inputted into the system
	 * */
	public Scene hrSignup() {
		Label title = new Label("Sign Up");
		
		TextField password = new TextField("password");
		TextField confirm = new TextField("confirm password");
		TextField name = new TextField("Your Full Name");
		TextField ssn = new TextField("Social Security Number");
		TextField pTy = new TextField("Payment type");
		TextField pAm = new TextField("Payment amount");
		Alert errorAlert = new Alert(AlertType.ERROR);
		
		Button submit = new Button("Submit");
		submit.setOnAction(e->{
			if(password.getText().equals(confirm.getText())) {//password check
				if(!db.InsertEmp(password.getText(), name.getText(), ssn.getText(),"HR", pTy.getText(), pAm.getText())) {
					//System.out.print("Company doesnt exist");
					db.use.seteName(name.getText());
					Stage stage = (Stage) ((Node) e.getTarget()).getScene().getWindow();
					stage.setScene(finalSignup());
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
		});
		
		Button exit = new Button("Exit");
		exit.setOnAction(e->{
			Stage stage = (Stage) ((Node) e.getTarget()).getScene().getWindow();
			stage.setScene(firstScreen());
			});
		
		VBox layout = new VBox();
		layout.getChildren().addAll(title, password, confirm, name, ssn, pTy, pAm, submit,exit);
		layout.setSpacing(20);
		Scene scene = new Scene(layout, 500, 500);
		return scene;
	}
	
	public Scene finalSignup() {
		Label title = new Label("Sign Up");
		
		Label a1 = new Label("Your Id number is "+db.getID(db.use.eName, db.ein)+"\n"
						   + "your password is "+db.getPass(db.use.eName, db.ein));
		
		Button fscreen = new Button("Return");
		fscreen.setOnAction(e->{
			Stage stage = (Stage) ((Node) e.getTarget()).getScene().getWindow();
			stage.setScene(firstScreen());
			});
		
		VBox layout = new VBox();
		layout.getChildren().addAll(title,a1,fscreen);
		layout.setSpacing(20);
		Scene scene = new Scene(layout, 500, 500);
		return scene;
	}
	/**
	 * sign in screen for logging in to existing account
	 * @return sign in screen
	 */
	public Scene logInScreen() {
		Label title = new Label("Login");
		TextField username = new TextField("username");
		TextField password = new TextField("password");
		Alert errorAlert = new Alert(AlertType.ERROR);
		
		Button submit = new Button("Submit");
		submit.setOnAction(e->{
		//System.out.print(db.loginCheck(username.getText(), password.getText()));
			if(db.loginCheck(username.getText(), password.getText())) {//checks if username and password true
				Stage stage = (Stage) submit.getScene().getWindow();
				stage.setScene(accMenuEmp());
				//System.out.print(db.use.aLv);
			}else {//error pop up
				errorAlert.setHeaderText("Error");
				errorAlert.setContentText("Invalid Username or Password.");
				errorAlert.showAndWait();
			}
		});
		
		// navigates back to the first screen
		Button back = new Button("Return");
		back.setOnAction(e->{
			Stage stage = (Stage) back.getScene().getWindow();
			stage.setScene(firstScreen());
			});
		
		HBox buttons = new HBox();
		buttons.getChildren().addAll(submit, back);
		buttons.setSpacing(20);
		
		VBox layout = new VBox();
		layout.getChildren().addAll(title, username, password, buttons);
		layout.setSpacing(20);
		Scene scene = new Scene(layout, 500, 500);
		return scene;
	}
	
	
	public Scene accMenuEmp() {
		Label title = new Label("Account Menu");
		
		Button pFile = new Button("Personal information");
		Button tTable= new Button("Time Table");
		
		VBox layout = new VBox();
		layout.getChildren().addAll(title, pFile, tTable);
		
		Scene scene = new Scene(layout, 500,500);
		return scene;
	}
	
}
