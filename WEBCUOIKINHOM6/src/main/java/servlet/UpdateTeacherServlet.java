package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TeacherDAO;
import model.Teacher;


@WebServlet("/UpdateTeacherServlet")
public class UpdateTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String id = request.getParameter("TeacherID");

            TeacherDAO teacherDAO = new TeacherDAO();
             Teacher teacher = teacherDAO.getTeacherByTeacherID(id);

            request.setAttribute("tc", teacher);

         request.getRequestDispatcher("UpdateTeacher.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String TeacherID = request.getParameter("teacherID");
    	String Fname = request.getParameter("firstName");
    	String Lname = request.getParameter("lastName");
    	String dob = request.getParameter("DOB");
    	String Email = request.getParameter("email");
        TeacherDAO dao = new TeacherDAO();
         dao.updateTeacher(TeacherID, Fname, Lname, dob, Email);
         response.sendRedirect("Page.jsp");

    }
}
