package db;

import java.sql.Connection;
import java.sql.DriverManager;


public class DataStoreInfo {

	public static Connection getMetaStore() {
		return getConnection("jdbc:oracle:thin:@localhost:1521:xe","USERNAME","PASSWORD");
	}
	
	private static Connection getConnection(final String url, String user, String pw) {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(url,user,pw);
			System.out.println("connected boy");
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		return connection;
	}
}
