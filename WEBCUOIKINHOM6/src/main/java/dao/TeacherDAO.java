package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import connection.DBconnection;
import model.Teacher;

public class TeacherDAO {
    Connection con = null;
    PreparedStatement stm = null;
    ResultSet rs = null;


    public List<Teacher> getAllTeachers()throws ClassNotFoundException {
        List<Teacher> teachers = new ArrayList<>();
        try {
        	con = DBconnection.getConnection();
            String query = "SELECT * FROM teachers";
            stm= con.prepareStatement(query);
                 rs = stm.executeQuery(); 
                	 
                 
                while (rs.next()) {
                    int TeacherID = rs.getInt("TeacherID");
                    String FirstName = rs.getString("FirstName");
                    String LastName = rs.getString("LastName");
                    Date DOB = rs.getDate("DOB");
 	               String Email = rs.getString("Email");
                    Teacher teacher = new Teacher(TeacherID, FirstName, LastName,DOB,Email);
                   
                teachers.add(teacher);
                }
                 }
            
         catch (SQLException e) {
            e.printStackTrace();
        }
        return teachers;
    }
    public void addTeacher(String TeacherID, String FirstName, String LastName, java.sql.Date DOB, String Email) {
        String query = "INSERT INTO teachers (TeacherID, FirstName, LastName, DOB, Email) VALUES (?, ?, ?, ?, ?)";
        
        try {
            con = DBconnection.getConnection();
            stm = con.prepareStatement(query);
            stm.setString(1, TeacherID);
            stm.setString(2, FirstName);
            stm.setString(3, LastName);
            stm.setDate(4, DOB);
            stm.setString(5, Email);

            stm.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    
    public Teacher getTeacherByTeacherID(String TeacherID) throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM teachers WHERE TeacherID=?";
        
        new DBconnection();
		con = DBconnection.getConnection();
        stm = con.prepareStatement(query);
        stm.setString(1, TeacherID);
        rs = stm.executeQuery();
        
        if (rs.next()) {
            int TeacherId= rs.getInt("TeacherID");  
            String firstName = rs.getString("FirstName");
            String lastName = rs.getString("LastName");
            Date dob = rs.getDate("DOB");
            String email = rs.getString("Email");

            return new Teacher(TeacherId, firstName, lastName, dob, email);
        }
        
        return null;
    }

  public void updateTeacher(String TeacherID, String FirstName, String LastName, String DOB, String Emai) {
String query = "UPDATE teachers SET FirstName = ?, LastName = ?, DOB = ?, Email = ? WHERE TeacherID = ?";
try {
con = DBconnection.getConnection();
stm = con.prepareStatement(query);
stm.setString(1, FirstName);
stm.setString(2, LastName);
stm.setString(3, DOB);
stm.setString(4, Emai);
stm.setString(5, TeacherID);
stm.executeUpdate();

}
catch (Exception e) {
}
  }
  public void deleteTeacherByTeacherID(String teacherID) throws ClassNotFoundException {
      String query = "DELETE FROM teachers WHERE TeacherID=?";
      try (Connection con = DBconnection.getConnection();
           PreparedStatement stm = con.prepareStatement(query)) {
          
          stm.setString(1, teacherID);
          stm.executeUpdate();

      } catch (SQLException e) {
          e.printStackTrace();
      }
  }
}
