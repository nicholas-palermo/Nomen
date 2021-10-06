package nomen;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//UI tmp = new UI();
		//tmp.start();
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub

		primaryStage.setTitle("Nomen");
		/*Label title = new Label("NOMEN");
		
		Button signIn = new Button("Sign in");
		
		signIn.setOnAction(e->primaryStage.setScene(signInScreen()));
		
		Button signUp = new Button("Sign up");
		
		signUp.setOnAction(e -> primaryStage.setScene(signUpScreen()));
		
		VBox layout1 = new VBox();
		layout1.getChildren().addAll(title, signIn, signUp);
		Scene scene1 = new Scene(layout1, 500,500);*/
		Scene scene1 = firstScreen();
		primaryStage.setScene(scene1);
		primaryStage.show();
	}
	
	public Scene firstScreen() {
		Label title = new Label("NOMEN");
		
		Button signIn = new Button("Sign in");
		
		signIn.setOnAction(e->{
			Stage stage = (Stage) signIn.getScene().getWindow();
			stage.setScene(signInScreen());
			}
		);
		
		Button signUp = new Button("Sign up");
		
		signUp.setOnAction(e->{
			Stage stage = (Stage) signUp.getScene().getWindow();
			stage.setScene(signUpScreen());
			});
		
		VBox layout1 = new VBox();
		layout1.getChildren().addAll(title, signIn, signUp);
		Scene scene1 = new Scene(layout1, 500,500);
		return scene1;
	}
	
	public Scene signUpScreen() {
		Label title = new Label("Sign Up");
		TextField field = new TextField("enter");
		
		Button back = new Button("Return");
		back.setOnAction(e->{
			Stage stage = (Stage) back.getScene().getWindow();
			stage.setScene(firstScreen());
			});
		
		VBox layout = new VBox();
		layout.getChildren().addAll(title, field, back);
		Scene scene = new Scene(layout, 500, 500);
		return scene;
	}
	public Scene signInScreen() {
		Label title = new Label("Sign In");
		TextField field = new TextField("enter");
		
		Button back = new Button("Return");
		back.setOnAction(e->{
			Stage stage = (Stage) back.getScene().getWindow();
			stage.setScene(firstScreen());
			});
		
		VBox layout = new VBox();
		layout.getChildren().addAll(title, field, back);
		Scene scene = new Scene(layout, 500, 500);
		return scene;
	}
	
}
