package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ResultDao;

@WebServlet("/AddResultServlet")
public class AddResultServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String resultID = request.getParameter("ResultID");
            String sID = request.getParameter("SID");
            String courseID = request.getParameter("CourseID");
            String grade = request.getParameter("Grade");

            ResultDao dao = new ResultDao();
            dao.addResult(resultID, sID, courseID, grade);

            response.sendRedirect("Page.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
