package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;


@WebServlet("/RegisServlet")
public class RegisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        UserDao dao = new UserDao();
	        dao.Regis(username, password);
	        System.out.println(username+password);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/Login.jsp");
	        
            dispatcher.forward(request, response);
            
	}

}
