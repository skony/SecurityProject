package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import security.Account;
import security.Authenticator;

@WebServlet("/login")
public class LoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    
    public LoginServlet() 
    {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		Account acc = Authenticator.login(user, password);
		
		if(acc != null)
		{  
			if(acc.getRole() == 1) //admin
			{
				HttpSession session = request.getSession();
				session.setAttribute("login", "admin");
				response.sendRedirect("/SecurityProject/home");
			}
			else if(acc.getRole() == 2)
			{
				HttpSession session = request.getSession();
				session.setAttribute("login", "user");
				response.sendRedirect("/SecurityProject/home");
			}
			HttpSession session = request.getSession();
			session.setAttribute("username", user);
		}
		else
		{
			HttpSession session = request.getSession();
			session.setAttribute("login", "error");
			response.sendRedirect("/SecurityProject/login");
		}
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String login = (String) request.getSession().getAttribute("login");
		request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}
}
