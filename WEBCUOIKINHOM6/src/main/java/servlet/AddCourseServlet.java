package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CourseDAO;

/**
 * Servlet implementation class AddCourseServlet
 */
@WebServlet("/AddCourseServlet")
public class AddCourseServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String CourseID = request.getParameter("CourseID");
            String CourseName = request.getParameter("CourseName");
            String TeacherID = request.getParameter("TeacherID");
            String Time = request.getParameter("Time");


      CourseDAO dao = new CourseDAO();
      dao.addCourse(CourseID, CourseName, TeacherID, Time);
            response.sendRedirect("Page.jsp");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        } 
    }


}
