package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.DBconnection;
import model.Course;

public class CourseDAO {
    Connection con = null;
    PreparedStatement stm = null;
    ResultSet rs = null;

    public Course getCourseById(int courseId) {
        Course course = null;
        try {
            con = DBconnection.getConnection();
            String sql = "SELECT * FROM course WHERE CourseID = ?";
            try (PreparedStatement statement = con.prepareStatement(sql)) {
                statement.setInt(1, courseId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        int fetchedCourseId = resultSet.getInt("CourseID");
                        String courseName = resultSet.getString("CourseName");
                        int teacherId = resultSet.getInt("TeacherID");
                        String time = resultSet.getString("Time");

                        course = new Course();
                        course.setCourseId(fetchedCourseId);
                        course.setCourseName(courseName);
                        course.setTeacherId(teacherId);
                        course.setTime(time);
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return course;
    }

    public List<Course> getAllCourses() throws ClassNotFoundException {
        List<Course> courseList = new ArrayList<>();

        try {
            con = DBconnection.getConnection();
            String query = "SELECT * FROM clb.course ";
            stm = con.prepareStatement(query);
            rs = stm.executeQuery();

            while (rs.next()) {
                int courseId = rs.getInt("CourseID");
                String courseName = rs.getString("CourseName");
                int teacherId = rs.getInt("TeacherID");
                String time = rs.getString("Time");

                Course course = new Course(courseId, courseName, teacherId, time);
                courseList.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return courseList;
    }


    public void addCourse(String courseID, String courseName, String teacherID, String time) {
        String query = "INSERT INTO course (CourseID, CourseName, TeacherID, Time) VALUES (?, ?, ?, ?)";

        try {
            con = DBconnection.getConnection();
            stm = con.prepareStatement(query);
            stm.setString(1, courseID);
            stm.setString(2, courseName);
            stm.setString(3, teacherID);
            stm.setString(4, time);

            stm.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updateCourse(int courseId, String courseName, int teacherId, String time) {
        try {
            con = DBconnection.getConnection();
            String sql = "UPDATE course SET CourseName=?, TeacherID=?, Time=? WHERE CourseID=?";
            try (PreparedStatement statement = con.prepareStatement(sql)) {
                statement.setString(1, courseName);
                statement.setInt(2, teacherId);
                statement.setString(3, time);
                statement.setInt(4, courseId);

                statement.executeUpdate();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
