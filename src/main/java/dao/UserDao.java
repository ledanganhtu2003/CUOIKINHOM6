package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.annotation.WebServlet;
import connection.DBconnection;
import model.Users;

@WebServlet("/LoginDao")
public class UserDao {
    Connection con = null;
    PreparedStatement stm = null;
    ResultSet rs = null;
    public Users login(String username, String password)
    {
    	 String query = "SELECT * FROM clb.users where `username` = ? and `password` = ?";
    	 try {
    		con = DBconnection.getConnection();
    		stm = con.prepareStatement(query);
    		stm.setString(1, username);
    		stm.setString(2, password);
    		rs = stm.executeQuery();
    		while(rs.next())
    		{
    			return new Users (rs.getInt(1),
    					rs.getString(2),
    					rs.getString(3));
    		}
    	} catch (Exception e) {
    	}
    	 
    	return null;
    	  
    }
    public void Regis(String username, String password)
    {
    	 String query = "INSERT INTO `clb`.`users` ( `username`, `password`) VALUES (?, ?)";

    	 try {
    		con = DBconnection.getConnection();
    		stm = con.prepareStatement(query);
    		stm.setString(1, username);
    		stm.setString(2, password);
    	    stm.executeUpdate();
    }
    	 catch (Exception e) {
    	}
    } 
    
}