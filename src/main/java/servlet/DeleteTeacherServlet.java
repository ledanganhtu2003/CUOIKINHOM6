package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TeacherDAO;


@WebServlet("/DeleteTeacherServlet")
public class DeleteTeacherServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String teacherID = request.getParameter("TeacherID");
            TeacherDAO dao = new TeacherDAO();
            dao.deleteTeacherByTeacherID(teacherID);
            response.sendRedirect("Page.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");

        }
    }
}
