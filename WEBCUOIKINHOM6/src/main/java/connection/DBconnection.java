package connection;

import javax.servlet.http.HttpServlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static Connection con = null;
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
    	if(con == null)
    	
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clb","root","252513467980");

		return con;
    	
    }
}

