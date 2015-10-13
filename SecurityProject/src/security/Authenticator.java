package security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Authenticator 
{
	public static void create_account(String name, String pwd1, String pwd2)
	{
		
	}
	
	public static void delete_account(String name)
	{
		
	}
	
	public static Account get_account(String name)
	{
		return null;
	}
	
	public static void change_pwd(String name, String pwd1, String pwd2)
	{
		
	}
	
	public static Account login(String name, String pwd)
	{
		return null;
	}
	
	public static void logout(Account acc)
	{
		
	}
	
	public static Account login(HttpServletRequest req, HttpServletResponse resp)
	{
		return null;
	}
}
