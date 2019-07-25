package com.lti.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import com.lti.bean.Account;
import java.util.ArrayList;

public class AccountDAOImpl implements AccountDAO {
	private Connection con;
	@Override
	public boolean insertAccount(Account ob) {
		boolean inserted=false;
		// load the driver
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="hr";
		String password="hr";
		//establish connection
		try {
			con=DriverManager.getConnection(url, username, password);
			System.out.println("connected");
			//Parameterized Query
			PreparedStatement ps1=con.prepareStatement("insert into Account values(?, ?, ?, ?)");
			ps1.setInt(1,  ob.getAid());
			ps1.setString(2, ob.getAname());
			LocalDate id=ob.getDob();
			//Date d=new Date(id.getYear(), id.getMonthValue()-1, id.getDayOfMonth());
			Date d=Date.valueOf(id);
			ps1.setDate(3, d);
			ps1.setDouble(4, ob.getBalance());
			int i=ps1.executeUpdate();
			System.out.println("Records inserted is : "+i);
			
			inserted=true;
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
			inserted=false;
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return inserted;
	}

	@Override
	public boolean updateAccount(Account ob) {
		boolean updated=false;
		// load the driver
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="hr";
		String password="hr";
		//establish connection
		try {
			con=DriverManager.getConnection(url, username, password);
			System.out.println("connected");
			//Parameterized Query
			PreparedStatement ps1=con.prepareStatement("update Account set aname=?, dob=?, balance=? where aid=?");
			ps1.setString(1, ob.getAname());
			LocalDate id=ob.getDob();
			//Date d=new Date(id.getYear(), id.getMonthValue()-1, id.getDayOfMonth());
			Date d=Date.valueOf(id);
			ps1.setDate(2, d);
			ps1.setDouble(3, ob.getBalance());
			ps1.setInt(4,  ob.getAid());
			int i=ps1.executeUpdate();
			System.out.println("Records updated is : "+i);
			
			updated=true;
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
			updated=false;
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return updated;
	}

	@Override
	public boolean deleteAccount(Account ob) {
		boolean deleted=false;
		// load the driver
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="hr";
		String password="hr";
		//establish connection
		try {
			con=DriverManager.getConnection(url, username, password);
			System.out.println("connected");
			//Parameterized Query
			PreparedStatement ps1=con.prepareStatement("delete from account where aid=?");
			ps1.setInt(1,  ob.getAid());
			int i=ps1.executeUpdate();
			System.out.println("Records Deleted is : "+i);
			
			deleted=true;
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
			deleted=false;
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return deleted;
	}

	@Override
	public Account getAccountById(int aid) {
		// TODO Auto-generated method stub
		//select * from account where aid=?
		return null;
	}

	@Override
	public List<Account> getAllAccount() {
		List<Account> acclist=new ArrayList<Account>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="hr";
		String password="hr";
		
		//establish connection
		try {
			con=DriverManager.getConnection(url, username, password);
			System.out.println("connected");
			
			//Parameterized Query
			PreparedStatement ps1=con.prepareStatement("select * from Account");
			ResultSet rs=ps1.executeQuery();
			while(rs.next()) {
				Account ob=new Account();
				int id=rs.getInt(1);
				ob.setAid(id);
				String aname=rs.getString(2);
				ob.setAname(aname);
				ob.setDob(rs.getDate(3).toLocalDate());
				ob.setBalance(rs.getDouble(4));
				acclist.add(ob);
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return acclist;
	}
	
}
