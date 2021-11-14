package nomen;

public class Main extends UI{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Database db = new Database(); //for testing db stuff
		db.UpdatetSheet(1, "10-15-2021", 1, 2, 3, 4, 5, 6, 7, 3, 6, "yes");
		
		
		launch(args);
	}
	
}
