package nomen;

public class Main extends UI{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Database db = new Database(); //for testing db stuff
		System.out.print(db.InsertPinfo(10000,"hi","this","is","a","test"));
		
		
		launch(args);
	}
	
}
