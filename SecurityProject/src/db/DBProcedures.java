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
	
	
}
