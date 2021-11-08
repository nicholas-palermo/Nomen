package nomen;

import java.sql.*;

public class Database {
	
	Connection con; //where to store results of quereies

	public ResultSet employeeLookup(Connection db, String uName, String pass) {
		String mainQuery = "SELECT E.Employee_Name, E.Employee_Password FROM Employees "
				+ "E WHERE E.Employee_Name = " + "'" + uName + "'"
				+ " AND E.Employee_Password = " + "'" + pass + "'";
		Statement statement;
		ResultSet queryOutput = null;
		try {
			statement = db.createStatement();
			queryOutput = statement.executeQuery(mainQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return queryOutput; 
	}
	
	
	public  void testq() {
		PreparedStatement Q;
		try {
			Q = con.prepareStatement("SELECT * FROM Employees;");
			ResultSet res = Q.executeQuery();
			while(res.next()) {
				System.out.println(res);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Constructor that connects to database upon inilization 
	public Database() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nomenpayroll?allowPublicKeyRetrieval=true&useSSL=false", "root", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

