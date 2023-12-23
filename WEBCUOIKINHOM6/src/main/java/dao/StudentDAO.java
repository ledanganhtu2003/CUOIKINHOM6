package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import connection.DBconnection;
import model.Student;

public class StudentDAO {
	   Connection con = null;
	    PreparedStatement stm = null;
	    ResultSet rs = null;
	    public List<Student>getAllStudents()throws ClassNotFoundException{
	    	List<Student> studentList = new ArrayList<>();

	        try {
	            con = DBconnection.getConnection();
	   	   	 String query = "SELECT * FROM clb.student ";
	            stm = con.prepareStatement(query);
	            rs = stm.executeQuery();

	            while (rs.next()) {
	               int SID = rs.getInt("SID");
	               String FirstName = rs.getString("FirstName");
	               String LastName = rs.getString("LastName");
	               Date DOB = rs.getDate("DOB");
	               String Email = rs.getString("Email");
	               int CourseID = rs.getInt("CourseID");
	               
	               Student student = new Student(SID,FirstName,LastName,DOB,Email,CourseID);
	               studentList.add(student);
	            }
	        }
	           catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return studentList;
	    }
	    public void deleteStudentBySID(String sID)  {
	        String query = "DELETE FROM student WHERE SID=?";
	      try { 
	     new DBconnection();
		con = DBconnection.getConnection();
	      
	      stm = con.prepareStatement(query); 
	      stm.setString(1, sID);
	      stm.executeUpdate();
	      }
	      
	      
	      catch (Exception e) {
		}
}
	        
	    


	    public void addStudent(String sID, String FirstName, String LastName, java.sql.Date DOB, String Email, String courseID) {
	        String query = "INSERT INTO student (SID, FirstName, LastName, DOB, Email, CourseID) VALUES (?, ?, ?, ?, ?, ?)";
	        
	        try {
	            con = DBconnection.getConnection();
	            stm = con.prepareStatement(query);
	            stm.setString(1, sID);
	            stm.setString(2, FirstName);
	            stm.setString(3, LastName);
	            stm.setDate(4, DOB);
	            stm.setString(5, Email);
	            stm.setString(6, courseID);

	            stm.executeUpdate();
	        } catch (SQLException | ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	    }
	    public Student getStudentBySID(String SID) throws SQLException, ClassNotFoundException {
	        String query = "SELECT * FROM student WHERE SID=?";
	        
	        new DBconnection();
			con = DBconnection.getConnection();
	        stm = con.prepareStatement(query);
	        stm.setString(1, SID);
	        rs = stm.executeQuery();
	        
	        if (rs.next()) {
	            int studentID = rs.getInt("SID");  
	            String firstName = rs.getString("FirstName");
	            String lastName = rs.getString("LastName");
	            Date dob = rs.getDate("DOB");
	            String email = rs.getString("Email");
	            int courseID = rs.getInt("CourseID");

	            return new Student(studentID, firstName, lastName, dob, email, courseID);
	        }
	        
	        return null;
	    }

	  public void updateStudent(String sID, String FirstName, String LastName, String dob, String Email, String courseID) {
String query = "UPDATE student SET FirstName = ?, LastName = ?, DOB = ?, Email = ?, CourseID = ? WHERE SID = ?";
try {
    con = DBconnection.getConnection();
    stm = con.prepareStatement(query);
    stm.setString(1, FirstName);
    stm.setString(2, LastName);
    stm.setString(3, dob);
    stm.setString(4, Email);
    stm.setString(5, courseID);
    stm.setString(6, sID);
stm.executeUpdate();

	}
catch (Exception e) {
		// TODO: handle exception
	}
	  }
}

