package servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TeacherDAO;

/**
 * Servlet implementation class AddTeacherServlet
 */
@WebServlet("/AddTeacherServlet")
public class AddTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AddTeacherServlet() {
        super();
    }

	
	  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        try {
	            String TeacherID = request.getParameter("TeacherID");
	            String firstName = request.getParameter("FirstName");
	            String lastName = request.getParameter("LastName");
	            Date dob = Date.valueOf(request.getParameter("DOB"));
	            String email = request.getParameter("Email");

	TeacherDAO dao = new TeacherDAO();
	dao.addTeacher(TeacherID, firstName, lastName, dob, email);
	            response.sendRedirect("Page.jsp");
	        } catch (NumberFormatException e) {
	            e.printStackTrace();
	            response.sendRedirect("error.jsp");
	        } 
	    }
}
