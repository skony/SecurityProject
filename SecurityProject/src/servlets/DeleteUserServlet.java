package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import security.Authenticator;

@WebServlet("/delete_user")
public class DeleteUserServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String username = request.getParameter("username");
		
		if(Authenticator.delete_account(username))
		{
			response.sendRedirect("/SecurityProject/home");
		}
		else
		{
			response.sendRedirect("/SecurityProject/delete_user");
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String login = (String) request.getSession().getAttribute("login");
		if(login.equals("admin"))
			request.getRequestDispatcher("/WEB-INF/delete_user.jsp").forward(request, response);
		else
			request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
	}
}