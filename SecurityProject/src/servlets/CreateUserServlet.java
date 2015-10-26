package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import security.Authenticator;

@WebServlet("/create_user")
public class CreateUserServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String username = request.getParameter("username");
		String pass1 = request.getParameter("pass1");
		String pass2 = request.getParameter("pass1");
		
		if(Authenticator.create_account(username, pass1, pass2))
		{
			response.sendRedirect("/SecurityProject/home");
		}
		else
		{
			response.sendRedirect("/SecurityProject/create_user");
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String login = (String) request.getSession().getAttribute("login");
		if(login.equals("admin"))
			request.getRequestDispatcher("/WEB-INF/create_user.jsp").forward(request, response);
		else
			request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
	}
}