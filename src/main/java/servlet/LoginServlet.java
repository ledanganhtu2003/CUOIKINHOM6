package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.Users;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserDao dao = new UserDao();
        Users u = dao.login(username, password);

        if (u != null) {
            HttpSession session = request.getSession();
            session.setAttribute("users", u);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/Page.jsp");
            dispatcher.forward(request, response);
        } else {
            response.getWriter().write("Invalid login");
        }
    }
}
