package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import security.Authenticator;

@WebServlet("/change_pwd")
public class ChangePwdServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String oldPass = request.getParameter("pass1"); 
		String newPass1 = request.getParameter("pass2");
		String newPass2 = request.getParameter("pass3");
		
		if(newPass1.equals(newPass2))
		{
			HttpSession session = request.getSession();
			String username = (String) session.getAttribute("username");	
			if( Authenticator.change_pwd(username, oldPass, newPass1) )
			{
				response.sendRedirect("/SecurityProject/home");
			}
			else
			{
				response.sendRedirect("/SecurityProject/change_pwd");
			}
		}
		else
		{
			response.sendRedirect("/SecurityProject/change_pwd");
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.getRequestDispatcher("/WEB-INF/change_pwd.jsp").forward(request, response);
	}
}
