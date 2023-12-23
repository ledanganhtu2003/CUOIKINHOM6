package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDAO;
import model.Student;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StudentDAO studentDAO = new StudentDAO();
        List<Student> studentList = null;
		try {
			studentList = studentDAO.getAllStudents();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		  for (Student student : studentList) {
				System.out.println(student);
			}
        request.setAttribute("studentList", studentList);
        request.getRequestDispatcher("Thongtinsinhvien.jsp").forward(request, response);

    }
    
    
}
