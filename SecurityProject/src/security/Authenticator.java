package security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DBProcedures;

public class Authenticator 
{
	
	
	public static boolean create_account(String name, String pwd1, String pwd2)
	{
	
		if(!pwd1.equals(pwd2))
			return false;
		String epwd = SecurityUtils.encrypt(pwd1);
		pwd1= null;
		pwd2= null;
		if(!SecurityUtils.checkString(name))
			return false;
		return DBProcedures.create_user(name, "Mr.", name, epwd);
		
	}
	
	public static boolean delete_account(String name)
	{
		if(!SecurityUtils.checkString(name)){
			return false;
		}
		if(get_account(name) == null)
			return false;
		return DBProcedures.delete_user(name);
			
	}
	
	public static Account get_account(String name)
	{
		if(!SecurityUtils.checkString(name)){
			return null;
		}
		Account acc = DBProcedures.getAccount(name);
		return acc;
	}
	
	public static boolean change_pwd(String name, String pwd1, String pwd2)
	{
		boolean result = false;
		if(!SecurityUtils.checkString(name)){
			return result;
		}
		Account acc = get_account(name);
		if(acc != null && !acc.isLocked() && BCrypt.checkpw(pwd1, acc.getPassword())){
			pwd1=null;
			result = DBProcedures.change_pw(name, BCrypt.hashpw(pwd2, BCrypt.gensalt(12)));
			pwd2=null;
			return result;
		}
		else
			return result;
		
	}
	
	public static Account login(String name, String pwd)
	{
		if(!SecurityUtils.checkString(name)){
			pwd = null;
			return null;
		}
		Account acc = DBProcedures.getAccount(name);
		if(acc != null && !acc.isLocked() && BCrypt.checkpw(pwd, acc.getPassword())){
			acc = new Account(acc.getId(), acc.getFirstname(), acc.getLastname(), acc.getUsername(),
					acc.getPassword(), acc.getRole(), true, acc.isLocked());
		}
		else{
			pwd= null;
		}
		return acc;
		
		
		
	}
	
	public static void logout(Account acc)
	{
		
	}
	
	public static Account login(HttpServletRequest req, HttpServletResponse resp)
	{
		return null;
	}
}
