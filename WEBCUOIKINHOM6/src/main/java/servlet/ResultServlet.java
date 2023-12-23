package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ResultDao;
import model.Result; 

@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ResultDao resultDao = new ResultDao();
        List<Result> resultList = resultDao.getAllResults();

        request.setAttribute("resultList", resultList);
        request.getRequestDispatcher("Result.jsp").forward(request, response);
    }
}
