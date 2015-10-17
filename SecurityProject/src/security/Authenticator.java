package security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DBProcedures;

public class Authenticator 
{
	
	
	public static boolean create_account(String name, String pwd1, String pwd2)
	{
		String epwd = SecurityUtils.encrypt(pwd1);
		String epwd2 = SecurityUtils.encrypt(pwd2);
		pwd1= null;
		pwd2= null;
		if(SecurityUtils.checkString(name))
			return false;
		if(!epwd.equals(epwd2))
			return false;
		
		return DBProcedures.create_user(name, "john", name, epwd);
		
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
		String epwd = SecurityUtils.encrypt(pwd);
		pwd= null;
		if(SecurityUtils.checkString(name))
			return null;
		return DBProcedures.login(name, epwd);
	}
	
	public static void logout(Account acc)
	{
		
	}
	
	public static Account login(HttpServletRequest req, HttpServletResponse resp)
	{
		return null;
	}
}
