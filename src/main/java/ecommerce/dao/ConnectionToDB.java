package ecommerce.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ecommerce.model.User;



public class ConnectionToDB 
{

	public void getConnection(User user)
	{
	try
	{
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "AJAY", "0998");
		PreparedStatement preparedStatement=connection.prepareStatement("insert into users values(?,?,?,?)");
		preparedStatement.setString(1, user.getUserName());
		preparedStatement.setString(2, user.getPassword());
		preparedStatement.setString(3, user.getEmail());
		preparedStatement.setString(4, user.getMobileNo());
		preparedStatement.executeUpdate();
		preparedStatement.close();
	}
	catch(SQLException sqe)
	{
		sqe.printStackTrace();
	}
	
	}
}
