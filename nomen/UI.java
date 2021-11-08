package nomen;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UI extends Application{
	
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
		TextField username = new TextField("username");
		TextField password = new TextField("password");
		TextField confirm = new TextField("confirm password");
		
		Button submit = new Button("Submit");
		
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
		layout.getChildren().addAll(title, username, password, confirm, buttons);
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
		
		Button submit = new Button("Submit");
		
		// navigates back to the first screen
		Button back = new Button("Return");
		back.setOnAction(e->{
			Stage stage = (Stage) back.getScene().getWindow();
			stage.setScene(firstScreen());
			});
		
		//tmp button to get to account menu to follow flow
		Button tmp = new Button("tmp");
		tmp.setOnAction(e->{
			Stage stage = (Stage) tmp.getScene().getWindow();
			stage.setScene(accMenuEmp());
			});
		
		
		HBox buttons = new HBox();
		buttons.getChildren().addAll(submit, back);
		buttons.setSpacing(20);
		
		VBox layout = new VBox();
		layout.getChildren().addAll(title, username, password, buttons,tmp);
		layout.setSpacing(20);
		Scene scene = new Scene(layout, 500, 500);
		return scene;
	}
	
	// accmenu
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
