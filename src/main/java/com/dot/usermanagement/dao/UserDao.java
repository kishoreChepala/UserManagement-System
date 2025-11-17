package com.dot.usermanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dot.usermanagement.model.Users;

public class UserDao {

	private static final String insert_users="INSERT INTO users(name,email,country) VALUES(?,?,?)";
	private static final String select_users_by_id="SELECT id,name,email,country FROM users WHERE id=?";
	private static final String select_all_users="SELECT * FROM users";
	private static final String delete_users="DELETE FROM users WHERE id=?";
	private static final String update_users="UPDATE users SET name=?,email=?,country=? WHERE id=?";
	
	protected Connection getConnection()
	{
		Connection connection=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
		}
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
		
	}
	
	//insert user
	public void insertUser(Users users) throws SQLException
	{
		try(Connection connection=getConnection();
				PreparedStatement ps=connection.prepareStatement(insert_users);)
		{
			ps.setString(1, users.getName());
			ps.setString(2,users.getEmail());
			ps.setString(3, users.getCountry());
			ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	//update user
	public boolean updateUser(Users users) throws SQLException
	{
		boolean rowupdate = false;
		try(Connection connection=getConnection();
				PreparedStatement ps=connection.prepareStatement(update_users);)
		{
			ps.setString(1, users.getName());
			ps.setString(2, users.getEmail());
			ps.setString(3, users.getCountry());
			ps.setInt(4, users.getId());
			rowupdate=ps.executeUpdate()>0;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return rowupdate;
	}
	
	
	//select user by id
	public Users selectUser(int id) throws SQLException
	{
		Users users=null;
		try(Connection connection=getConnection();
				PreparedStatement ps=connection.prepareStatement(select_users_by_id);)
		{
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				String name=rs.getString("name");
				String email=rs.getString("email");
				String country=rs.getString("country");
				users=new Users(id,name,email,country);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return users;
	}
	
	
	//select all users
	public List<Users> selectAllUsers() throws SQLException
	{
		List<Users> users=new ArrayList<>();
		try(Connection connection=getConnection();
				PreparedStatement ps=connection.prepareStatement(select_all_users);)
		{
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String email=rs.getString("email");
				String country=rs.getString("country");
				users.add(new Users(id,name,email,country));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return users;
	}
	
	//delete user
	public boolean deleteUser(int id) throws SQLException
	{
		boolean rowdeleted=false;
		try(Connection connection=getConnection();
				PreparedStatement ps=connection.prepareStatement(delete_users);)
		{
			ps.setInt(1, id);
			rowdeleted=ps.executeUpdate()>0;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rowdeleted;
	}
}
