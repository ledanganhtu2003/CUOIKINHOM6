package servlet;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDAO;

@WebServlet("/AddStudentServlet")
public class AddStudentServlet  {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String SID = request.getParameter("SID");
            String firstName = request.getParameter("FirstName");
            String lastName = request.getParameter("LastName");
            Date dob = Date.valueOf(request.getParameter("DOB"));
            String email = request.getParameter("Email");
            String courseID = request.getParameter("CourseID");

      StudentDAO dao = new StudentDAO();
      dao.addStudent(SID, firstName, lastName, dob, email, courseID);
            response.sendRedirect("Page.jsp");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        } 
    }

   
}
