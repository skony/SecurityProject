package db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
import security.Account;

public class DBProcedures {

	
	
	private static Connection getConn(){
		//DataStoreInfo dsi = new DataStoreInfo();
		Connection conn = DataStoreInfo.getMetaStore();
		return conn;
	}
	public static Account login(String username, String pwd){
		Connection conn = getConn();
		Account acc = null;
		try{
			CallableStatement stmt = conn.prepareCall("BEGIN login_user_sec(?,?, ?); END;");
			stmt.setString(1, username); //username
			stmt.setString(2, pwd);// pw
			stmt.registerOutParameter(3, OracleTypes.CURSOR); //REF CURSOR
			stmt.execute();
			ResultSet rs = ((OracleCallableStatement)stmt).getCursor(3);
			while (rs.next()) {
				acc = new Account(rs.getInt("ID"), rs.getString("FIRSTNAME"), rs.getString("LASTNAME"), rs.getString("loginname"), rs.getString("pw"), rs.getInt("ROLEID"), true, rs.getBoolean("locked"));
			}
			rs.close();
			rs = null;
			stmt.close();
			stmt = null;
			conn.close();
			conn = null;
		}
		catch (SQLException e) {
			System.out.println(e.getLocalizedMessage());
		}
		
		return acc;
	}
	
	
	public static boolean create_user(String username, String firstname, String lastname, String pwd){
		Connection conn = getConn();
		try{
			CallableStatement stmt = conn.prepareCall("BEGIN create_user_sec(?,?,?,?,?); END;");
			stmt.setString(1, username); //username
			stmt.setString(2, firstname);
			stmt.setString(3, lastname);
			stmt.setInt(4, 2);
			stmt.setString(5, pwd);// pw
			stmt.execute();
			stmt.close();
			stmt = null;
			conn.close();
			conn = null;
			return true;
		}
		catch (SQLException e) {
			System.out.println(e.getLocalizedMessage());
			return false;
		}
	}
	
	public static Account getAccount(String username){
		Connection conn = getConn();
		Account acc = null;
		try{
			CallableStatement stmt = conn.prepareCall("BEGIN fetch_user_sec(?, ?); END;");
			stmt.setString(1, username); //username
			stmt.registerOutParameter(2, OracleTypes.CURSOR); //REF CURSOR
			stmt.execute();
			ResultSet rs = ((OracleCallableStatement)stmt).getCursor(2);
			while (rs.next()) {
				acc = new Account(rs.getInt("ID"), rs.getString("FIRSTNAME"), rs.getString("LASTNAME"), rs.getString("loginname"), rs.getString("pw"), rs.getInt("ROLEID"), false, rs.getBoolean("locked"));
			}
			rs.close();
			rs = null;
			stmt.close();
			stmt = null;
			conn.close();
			conn = null;
			return acc;
		}
		catch (SQLException e) {
			System.out.println(e.getLocalizedMessage());
			return null;
		}
	}
	
	public static boolean delete_user(String name){
		Connection conn = getConn();
		
		try{
			CallableStatement stmt = conn.prepareCall("BEGIN delete_user_sec(?); END;");
			stmt.setString(1, name); //username
			stmt.execute();
			stmt.close();
			stmt = null;
			conn.close();
			conn = null;
			return true;
		}
		catch (SQLException e) {
			System.out.println(e.getLocalizedMessage());
			return false;
		}
	}
	
	public static boolean change_pw(String name, String newpwd){
		Connection conn = getConn();
		
		try{
			CallableStatement stmt = conn.prepareCall("BEGIN updatepw_sec(?,?); END;");
			stmt.setString(1, name); //username
			stmt.setString(2, newpwd); //newpwd
			stmt.execute();
			stmt.close();
			stmt = null;
			conn.close();
			conn = null;
			return true;
		}
		catch (SQLException e) {
			System.out.println(e.getLocalizedMessage());
			return false;
		}
	}
	
}
