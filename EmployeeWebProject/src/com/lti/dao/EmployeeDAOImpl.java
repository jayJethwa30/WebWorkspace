package com.lti.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.lti.bean.Employee;
import java.util.ArrayList;


public class EmployeeDAOImpl implements EmployeeDAO {

	private Connection con;

	@Override
	public boolean insertEmployee(Employee emp) {
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
			PreparedStatement ps1=con.prepareStatement("insert into Employee values(?, ?, ?, ?, ?)");
			ps1.setInt(1,  emp.getId());
			ps1.setString(2, emp.getFname());
			ps1.setString(3,  emp.getIname());
			LocalDate id=emp.getDoj();
			//Date d=new Date(id.getYear(), id.getMonthValue()-1, id.getDayOfMonth());
			Date d=Date.valueOf(id);
			ps1.setDate(4, d);
			ps1.setInt(5, emp.getDept());
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
	public List<Employee> getAllEmployees() {
		List<Employee> acclist=new ArrayList<Employee>();
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
			PreparedStatement ps1=con.prepareStatement("select * from Employee");
			ResultSet rs=ps1.executeQuery();
			while(rs.next()) {
				Employee emp=new Employee();
				int id=rs.getInt(1);
				emp.setId(id);
				String fname=rs.getString(2);
				emp.setFname(fname);
				String iname=rs.getString(3);
				emp.setIname(iname);
				emp.setDoj(rs.getDate(4).toLocalDate());
				emp.setDept(rs.getInt(5));
				acclist.add(emp);
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

	@Override
	public boolean deleteEmployee(int id) {
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
			PreparedStatement ps1=con.prepareStatement("delete from employee where id=?");
			ps1.setInt(1,  id);
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
	public List<Employee> getEmployeeByDept(int dept) {
		List<Employee> acclist=new ArrayList<Employee>();
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
			PreparedStatement ps1=con.prepareStatement("select * from employee where dept=?");
			ps1.setInt(1,  dept);
			ResultSet rs=ps1.executeQuery();
			
			while(rs.next()) {
				Employee emp=new Employee();
				int id=rs.getInt(1);
				emp.setId(id);
				String fname=rs.getString(2);
				emp.setFname(fname);
				String iname=rs.getString(3);
				emp.setIname(iname);
				emp.setDoj(rs.getDate(4).toLocalDate());
				emp.setDept(rs.getInt(5));
				acclist.add(emp);
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

	@Override
	public boolean updateEmployeeDept(Employee emp) {
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
			PreparedStatement ps1=con.prepareStatement("update Employee set fname=?, iname=?, doj=?, dept=?  where id=?");
			ps1.setString(1, emp.getFname());
			LocalDate id=emp.getDoj();
			//Date d=new Date(id.getYear(), id.getMonthValue()-1, id.getDayOfMonth());
			Date d=Date.valueOf(id);
			ps1.setDate(3, d);
			ps1.setString(2, emp.getIname());
			ps1.setInt(4, emp.getDept());
			ps1.setInt(5,  emp.getId());
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
	
	
}
