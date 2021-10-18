package nomen;

import java.sql.*;

public class Database {
	
	Connection con; //where to store results of quereies

	//Constructor that connects to database upon inilization 
	public Database() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Nomen?useSSL=false", "api", "pass");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
