package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.xdevapi.Result;

import dao.ResultDao;


@WebServlet("/UpdateResultServlet")
public class UpdateResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String resultID = request.getParameter("ResultID");

            ResultDao dao = new ResultDao();
            Result result = (Result) dao.getResultById(resultID);

            request.setAttribute("result", result);

            request.getRequestDispatcher("UpdateResult.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
