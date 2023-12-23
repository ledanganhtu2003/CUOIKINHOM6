package servlet;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.TeacherDAO;
import model.Teacher;
@WebServlet("/TeacherServlet")
public class TeacherServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	 TeacherDAO teacherDAO = new TeacherDAO();
         List<Teacher> teachers = null;
		try {
			teachers = teacherDAO.getAllTeachers();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
      
        for (Teacher teacher : teachers) {
			System.out.println(teacher);
		}
        	 request.setAttribute("teacherList", teachers);
             request.getRequestDispatcher("Teacher.jsp").forward(request, response);
    }
    
}
