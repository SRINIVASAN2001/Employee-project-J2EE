package employee;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Employee_DAO
{
	public Connection getConnection() throws SQLException, IOException
	{
		Driver d=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		
		FileInputStream fis=new FileInputStream("C:\\Users\\ELCOT\\eclipse-workspace\\Employee_demo\\src\\main\\java\\def.properties");
		Properties p=new Properties();
		p.load(fis);
		
		String url=p.getProperty("url");
		Connection con=DriverManager.getConnection(url, p);
		return con;
	}
	
	public int saveEmployee(Employee_DTO e) throws SQLException, IOException
	{
		Connection con=getConnection();
		PreparedStatement pst=con.prepareStatement("insert into employeedata values(?,?,?,?,?)");
		pst.setInt(1, e.getId());
		pst.setString(2,e.getName());
		pst.setString(3,e.getEmail());
		pst.setLong(4,e.getContact());
		
		pst.setString(5,e.getPassword());
		
		return pst.executeUpdate();
	}
	
	public List<Employee_DTO> getAll() throws SQLException, IOException
	{
		Connection con=getConnection();
		Statement st=con.createStatement();
		String query="select * from employeedata";
		ResultSet rs=st.executeQuery(query);
		List<Employee_DTO> list=new ArrayList();
		while(rs.next())
		{
			Employee_DTO e=new Employee_DTO();
			e.setId(rs.getInt(1));
			e.setName(rs.getString(2));
			e.setEmail(rs.getString(3));
			e.setContact(rs.getLong(4));
			e.setPassword(rs.getString(5));
			list.add(e);
		}
		return list;
	}
	
	public Employee_DTO findById(int id) throws SQLException, IOException 
	{
		Connection con=getConnection();
		PreparedStatement pst=con.prepareStatement("select * from employeedata where id=?");
		pst.setInt(1,id);
		ResultSet rs=pst.executeQuery();
		
		Employee_DTO e=new Employee_DTO();
		rs.next();
		e.setId(rs.getInt(1));
		e.setName(rs.getString(2));
		e.setEmail(rs.getString(3));
		e.setContact(rs.getLong(4));
		e.setPassword(rs.getString(5));
		return e;
	}
	
	public Employee_DTO findByName(String name) throws SQLException, IOException 
	{
		Connection con=getConnection();
		PreparedStatement pst=con.prepareStatement("select * from employeedata where name=?");
		pst.setString(1,name);
		ResultSet rs=pst.executeQuery();
		
		Employee_DTO e=new Employee_DTO();
		
		rs.next();
		e.setId(rs.getInt(1));
		e.setName(rs.getString(2));
		e.setEmail(rs.getString(3));
		e.setContact(rs.getLong(4));
		e.setPassword(rs.getString(5));
		return e;
	}
	public Employee_DTO findByEmail(String email) throws SQLException, IOException 
	{
		Connection con=getConnection();
		PreparedStatement pst=con.prepareStatement("select * from employeedata where email=?");
		pst.setString(1,email);
		ResultSet rs=pst.executeQuery();
		
		Employee_DTO e=new Employee_DTO();
		rs.next();
		e.setId(rs.getInt(1));
		e.setName(rs.getString(2));
		e.setEmail(rs.getString(3));
		e.setContact(rs.getLong(4));
		e.setPassword(rs.getString(5));
		return e;
	}
	
	public int update(Employee_DTO e) throws SQLException, IOException 
	{
		Connection con=getConnection();
		PreparedStatement pst=con.prepareStatement("update employeedata set name=?,email=?,contact=?,password=? where id=?");
		
		pst.setInt(5, e.getId());
		pst.setString(1,e.getName() );
		pst.setString(2,e.getEmail());
		pst.setLong(3,e.getContact());
		pst.setString(4,e.getPassword());
		
		return pst.executeUpdate();
	}
	
	public int delete(int id) throws SQLException, IOException
	{
		Connection con=getConnection();
		PreparedStatement pst=con.prepareStatement("delete from employeedata where id=?");
		pst.setInt(1,id);
		return pst.executeUpdate();
	}
	

}
