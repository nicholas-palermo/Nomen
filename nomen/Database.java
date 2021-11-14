package nomen;

import java.sql.*;

public class Database {
	
	Connection con; //where to store results of quereies
	User use = new User();
	int ein;
	
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
	
	public boolean InsertPinfo(int id,String name,String address,String pNumber, String email, String dis) {
		String q = "Insert Into personal_information values (?,?,?,?,?,?);";
		PreparedStatement stat;
		try {
			stat = con.prepareStatement(q);
			stat.setInt(1,id);
			stat.setString(2,name);
			stat.setString(3,address);
			stat.setString(4,pNumber);
			stat.setString(5,email);
			stat.setString(6,dis);
			if(stat.execute()) {
				return true;
			}else 
				return false;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean UpdatePinfo(int id,String name,String address,String pNumber, String email, String dis) {
        String q = "UPDATE Personal_Information SET Employee_Name_FK = ?, Address = ?, Phone_Number = ?, Email = ?, Disability = ? WHERE Employee_ID_FK = "+id+";";
        PreparedStatement stat;
        try {
            stat = con.prepareStatement(q);
            stat.setString(1,name);
            stat.setString(2,address);
            stat.setString(3,pNumber);
            stat.setString(4,email);
            stat.setString(5,dis);
            if(stat.execute()) {
                return true;
            }else 
                return false;
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
	
	public boolean UpdateEMPinfo(int id,String name,String ssn,String empP, String pt, String pa) {
        String q = "UPDATE Employees SET Employee_Name = ?, SSN = ?, Employee_Position = ?, Pay_Type = ?, Pay_Amount = ? WHERE Employee_ID = "+id+";";
        PreparedStatement stat;
        try {
            stat = con.prepareStatement(q);
            stat.setString(1,name);
            stat.setString(2,ssn);
            stat.setString(3,empP);
            stat.setString(4,pt);
            stat.setString(5,pa);
            if(stat.execute()) {
                return true;
            }else 
                return false;
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

	public boolean UpdatetSheet(int id,String week,double sun,double mon,double tue, double wed, double thur, double fri, double sat, double vt, double st, String v) {
        String q = "UPDATE timesheet SET "
        		+ "Sunday = ?, Monday = ?, Tuesday = ?, Wednesday = ?,Thursday = ?, Friday = ? , Saturday = ?, Vaccation_Total = ?, Sick_Total = ?, Verified = ?"
        		+ "WHERE Employee_ID_FK = '"+id+"' and Week_Date = '"+week+"';";
        PreparedStatement stat;
        try {
            stat = con.prepareStatement(q);
            stat.setDouble(1,sun);
            stat.setDouble(2,mon);
            stat.setDouble(3,tue);
            stat.setDouble(4,wed);
            stat.setDouble(5,thur);
            stat.setDouble(6,fri);
            stat.setDouble(7,sat);
            stat.setDouble(8,vt);
            stat.setDouble(9,st);
            stat.setString(10,v);
            if(stat.execute()) {
                return true;
            }else 
                return false;
        }catch (SQLException e) {
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
			//System.out.print(set.getString("Employee_ID"));
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
			//System.out.print(set.getString("Employee_Password"));
			return (set.getString("Employee_Password"));
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "error";
	}
	
	public String getPinfo(int y) {
		String q = "SELECT * FROM Personal_information WHERE Employee_ID_FK = "+y+";";
		PreparedStatement stat;
		String ret = "";
		try {
			stat = con.prepareStatement(q);
			ResultSet set = stat.executeQuery();
			set.next();
			ret += "Employee Id: "+set.getString("Employee_ID_FK")+"\n";
			ret += "Name: "+set.getString("Employee_Name_FK")+"\n";
			ret += "Address: "+set.getString("Address")+"\n";
			ret += "Phone number: "+set.getString("Phone_Number")+"\n";
			ret += "Email: "+set.getString("Email")+"\n";
			ret += "Disability: "+set.getString("Disability")+"\n";

			return ret;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "error";
	}

	
	
	public ResultSet getPinfoU(int y) {
		String q = "SELECT * FROM Personal_information WHERE Employee_ID_FK = "+y+";";
		PreparedStatement stat;
		try {
			stat = con.prepareStatement(q);
			ResultSet set = stat.executeQuery();
			set.next();

			return set;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void setEin(String x,String y) {
		String q = "SELECT Company_FK FROM Employees WHERE Employee_ID ="+x+" AND Employee_Password = '"+y+"';";
		PreparedStatement stat;
		try {
			stat = con.prepareStatement(q);
			ResultSet set = stat.executeQuery();
			set.next();
			//System.out.print(set.getString("Employee_Password"));
			ein = set.getInt("Company_FK");
		}catch (SQLException e) {
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
			String q = "Select Employee_ID From Employees where Employee_Name = '"+x+"';";
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
