package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CourseDAO;
import model.Course;

@WebServlet("/UpdateCourseServlet")
public class UpdateCourseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String courseID = request.getParameter("CourseID");

            CourseDAO courseDAO = new CourseDAO();
            Course course = courseDAO.getCourseById(Integer.parseInt(courseID));

            request.setAttribute("course", course);

            request.getRequestDispatcher("UpdateCourse.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String courseIdParam = request.getParameter("CourseID");
            String courseName = request.getParameter("CourseName");
            String teacherIdParam = request.getParameter("TeacherID");
            String time = request.getParameter("Time");

            int courseId = Integer.parseInt(courseIdParam);
            int teacherId = Integer.parseInt(teacherIdParam);

            CourseDAO dao = new CourseDAO();
            dao.updateCourse(courseId, courseName, teacherId, time);

            response.sendRedirect("Page.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
