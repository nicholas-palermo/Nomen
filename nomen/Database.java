package nomen;

import java.sql.*;

public class Database {
	
	Connection con; //where to store results of quereies
	User use = new User();
	
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
	
	public boolean loginCheck(String uname, String pass) {
		String q = "SELECT Employee_ID, Employee_Password FROM Employees WHERE Employee_ID = "+uname+";";
		PreparedStatement stat;
		try {
			stat = con.prepareStatement(q);
			ResultSet set = stat.executeQuery();
			set.next();
			/*while(set.next()) {
				System.out.print(set.getString(1)+" ");
				System.out.print(set.getString(2));
			}*/
				if(set.getString(1).equals(uname)){
					if(pass.equals(set.getString(2))) {
						use.setaLv(uname);
						return true;
				}else {
					return false;
				}
					
				}else {
					return false;
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		}
		
	public  void testq() {
		PreparedStatement Q;
		try {
			Q = con.prepareStatement("SELECT * FROM Employees;");
			ResultSet res = Q.executeQuery();
			while(res.next()) {
				System.out.print(res.getString(1)+" ");
				System.out.print(res.getString(2)+" ");
				System.out.print(res.getString(3)+" ");
				System.out.print(res.getString(4)+" ");
				System.out.print(res.getString(5)+" ");
				System.out.print(res.getString(6)+" ");
				System.out.print(res.getString(7)+" ");
				System.out.println(res.getString(8));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Constructor that connects to database upon inilization 
	public Database() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nomenpayroll?allowPublicKeyRetrieval=true&useSSL=false", "emp", "pass");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	class User{
		
		int aLv;
	
		void tmp() {System.out.println("test");}
		
		void setaLv(String x) {
			int uid = Integer.parseInt(x);
			String q = "SELECT Employee_Position FROM Employees WHERE Employee_ID ="+uid+";";
			PreparedStatement stat;
			try {
				stat = con.prepareStatement(q);
				ResultSet set = stat.executeQuery();
				set.next();
				//System.out.println(set.getString(1)); //to show what querey gives
				if(set.getString(1).equals("HR")) {
					aLv = 1;
				}else if(set.getString(1).equals("Manager")) {
					aLv = 2;
				}else if(set.getString(1).equals("Employee")) {
					aLv = 3;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
		
}
