package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Result;


import connection.DBconnection;

public class ResultDao {
    private Connection con = null;
    private PreparedStatement stm = null;
    private ResultSet rs = null;

    public List<Result> getAllResults() {
        List<Result> resultList = new ArrayList<>();

        try {
            con = DBconnection.getConnection();
            String query = "SELECT * FROM results";
            stm = con.prepareStatement(query);
            rs = stm.executeQuery();

            while (rs.next()) {
                int resultID = rs.getInt("ResultID");
                int sID = rs.getInt("SID");
                int courseID = rs.getInt("CourseID");
                int grade = rs.getInt("Grade");

                Result result = new Result(resultID, sID, courseID, grade);
                resultList.add(result);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } 

        return resultList;
    }
    public void addResult(String ResultID, String SID, String CourseID, String Grade) {
        try {
            con = DBconnection.getConnection();
            String query = "INSERT INTO results (ResultID, SID, CourseID, Grade) VALUES (?, ?, ?, ?)";
            stm = con.prepareStatement(query);
            stm.setString(1, ResultID);
            stm.setString(2, SID);
            stm.setString(3, CourseID);
            stm.setString(4, Grade);

            stm.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
        }
    }

    public void updateResult(int ResultID, int SID, int CourseID, String Grade) {
        try {
            con = DBconnection.getConnection();
            String sql = "UPDATE results SET Grade=? WHERE ResultID=?";
            try (PreparedStatement statement = con.prepareStatement(sql)) {
                statement.setString(1, Grade);
                statement.setInt(2, ResultID);

                statement.executeUpdate();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
        }
    }
    public Result getResultById(String resultID) {
        Result result = null;

        try {
            con = DBconnection.getConnection();
            String query = "SELECT * FROM results WHERE ResultID=?";
            stm = con.prepareStatement(query);
            stm.setString(1, resultID);
            rs = stm.executeQuery();

            if (rs.next()) {
                int sID = rs.getInt("SID");
                int courseID = rs.getInt("CourseID");
                int grade = rs.getInt("Grade");
                result = new Result();
                result.setSID(sID);
                result.setCourseID(courseID);
                result.setGrade(grade);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return result;
    }

}
