package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

	public boolean autenticaUser(String username, String password) throws ClassNotFoundException {
        String SELECT_USER = "SELECT username from employee where username = ? and password=? ;";        
        ResultSet rs;
        boolean result = false;
        Class.forName("com.mysql.jdbc.Driver");
        
        try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/employees", "root", "");

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER)) {
	            //preparedStatement.setInt(1, 2);
	            preparedStatement.setString(1, username);
	            preparedStatement.setString(2, password);
	            
	            System.out.println(preparedStatement);
	            
	            rs = preparedStatement.executeQuery();
	            
	            if(rs.next()){
	            	result = true;
	            }else {
	            	result = false;
	            }

	        } catch (SQLException e) {
	            // process sql exception
	            e.printStackTrace();
	        }
        return result;
    }
	
}
