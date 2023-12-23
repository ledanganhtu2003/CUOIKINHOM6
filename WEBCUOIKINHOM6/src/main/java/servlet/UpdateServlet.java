package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDAO;
import model.Student;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String id = request.getParameter("SID");

            StudentDAO studentDAO = new StudentDAO();
            Student student = studentDAO.getStudentBySID(id);

            request.setAttribute("st", student);

         request.getRequestDispatcher("Update.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String sid = request.getParameter("SID");
    	String Fname = request.getParameter("firstName");
    	String Lname = request.getParameter("lastName");
    	String dob = request.getParameter("DOB");
    	String Email = request.getParameter("email");
    	String CourseID = request.getParameter("courseID");
         StudentDAO dao = new StudentDAO();
         dao.updateStudent(sid, Fname, Lname, dob, Email, CourseID);
         response.sendRedirect("Page.jsp");

    }
}
