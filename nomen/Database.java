package nomen;

import java.sql.*;

public class Database {
	
	Connection con; //where to store results of quereies
	User use = new User();
	int ein;
	
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
						use.setaLv(uname);//sets 
						use.seteName(uname);
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
	
	public boolean CompanyExists(String comp) {//Checks if the company already exists within our DB
		int com = Integer.parseInt(comp);
		String q = "SELECT EIN FROM Company WHERE EIN = "+comp+";";
		PreparedStatement stat;
		try {
			stat = con.prepareStatement(q);
			ResultSet set = stat.executeQuery();
			if(!set.next()) {//if it is empty
				ein = com;
				return false;
			}else {
			do {//if it returns results if they are equal
			if(set.getInt("EIN")==com)
				return true;
			}while(set.next());
			}
			ein = com;//after checking the resultset if nothing matches its true
			return false;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public boolean InsertCompD(String si,String li,String compName,String numEmp, String ownerName,String ownerEmail) {
		//validators would go here 
		
		String q = "INSERT INTO Company (EIN,State_ID,Local_ID,Company_Name,Num_Employees,Owner_Name,Owner_Email) values( ?,?,?,?,?,?,? )";
		try {
			PreparedStatement stat = con.prepareStatement(q);
			stat.setInt(1,ein);
			stat.setString(2,si);
			stat.setString(3,li);
			stat.setString(4,compName);
			stat.setString(5,numEmp);
			stat.setString(6,ownerName);
			stat.setString(7,ownerEmail);
			if(stat.execute()) {
				return true;
			}else 
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean InsertEmp(String ePass,String eName,String ssn,String ePos,String pTy, String pAm) {
		//validators here
		int am = Integer.parseInt(pAm);
		String q = "INSERT INTO Employees (Employee_Password, Employee_Name, SSN, Company_FK, Employee_Position, Pay_Type, Pay_Amount) VALUES( ?,?,?,?,?,?,? );";
		try {
			PreparedStatement stat = con.prepareStatement(q);
			stat.setString(1,ePass);
			stat.setString(2,eName);
			stat.setString(3,ssn);
			stat.setInt(4,ein);
			stat.setString(5,ePos);
			stat.setString(6,pTy);
			stat.setInt(7,am);
			if(stat.execute()) {
				return true;
			}else 
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public String getID(String x,int y) {
		String q = "SELECT Employee_ID FROM Employees WHERE Employee_Name = '"+x+"' AND Company_FK = "+y+";";
		PreparedStatement stat;
		try {
			stat = con.prepareStatement(q);
			ResultSet set = stat.executeQuery();
			set.next();
			System.out.print(set.getString("Employee_ID"));
			return set.getString("Employee_ID");
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "error";
	}

	public String getPass(String x,int y) {
		String q = "SELECT Employee_Password FROM Employees WHERE Employee_Name ='"+x+"' AND Company_FK = "+y+";";
		PreparedStatement stat;
		try {
			stat = con.prepareStatement(q);
			ResultSet set = stat.executeQuery();
			set.next();
			System.out.print(set.getString("Employee_Password"));
			return (set.getString("Employee_Password"));
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "error";
	}
	
	public void testq() {
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
	
	public class User{
		
		int aLv;
		public String eName;
		
		void tmp() {System.out.println("test");}
		
		public void setaLv(String x) {
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
		public void seteName(String x) {
			eName = x;
		}
		
		
		public void seteNameSQl(String x) {
			String q = "SELECT Employee_Name FROM Employees WHERE Employee_ID = "+x+";";
			PreparedStatement stat;
			try {
				stat = con.prepareStatement(q);
				ResultSet set = stat.executeQuery();
				set.next();
				eName = set.getString("Employee_Name");
				//System.out.print(eName);
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		public int getEmpID(String x) {
			String q = "Select Employee_ID From Employees where Employee_Name = "+x+";";
			try {
				PreparedStatement stat = con.prepareStatement(q);
				stat = con.prepareStatement(q);
				ResultSet set = stat.executeQuery();
				set.next();
				return set.getInt(1);
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
		}
	}
		
}
