package nomen;

public class Main extends UI{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Database db = new Database(); //for testing db stuff
		System.out.print(db.getID("qqqq", 12334));
		
		
		launch(args);
	}
	
}
