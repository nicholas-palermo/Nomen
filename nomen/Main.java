package nomen;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{


	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub
		try {
			Parent root = FXMLLoader.load(getClass().getResource("StartUpScreen.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/*
	 * 
	 * public Scene firstScreen() {
		Label title = new Label("NOMEN");
		
		// navigates to sign in screen
		Button signIn = new Button("Sign in");
		signIn.setOnAction(e->{
			Stage stage = (Stage) ((Node) e.getTarget()).getScene().getWindow();
			stage.setScene(signInScreen());
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
	
	public Scene signInScreen() {
		Label title = new Label("Sign In");
		TextField username = new TextField("username");
		TextField password = new TextField("password");
		
		Button submit = new Button("Submit");
		
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
	 */
	
	

	
}


