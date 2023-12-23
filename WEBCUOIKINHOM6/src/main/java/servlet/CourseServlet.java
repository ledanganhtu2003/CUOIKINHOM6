package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CourseDAO;
import model.Course;

@WebServlet("/CourseServlet")
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
   
	   protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		   CourseDAO courseDAO = new CourseDAO();
	        List<Course> courseList = null;
			try {
				courseList = courseDAO.getAllCourses();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			  for (Course course : courseList) {
					System.out.println(course);
				}
	        request.setAttribute("courseList", courseList);
	        request.getRequestDispatcher("Course.jsp").forward(request, response);

	    }
}
