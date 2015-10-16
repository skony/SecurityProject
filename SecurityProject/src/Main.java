

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBProcedures;
import db.DataStoreInfo;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
import security.Authenticator;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Authenticator auth = new Authenticator();
		System.out.println(auth.login("root", "rootpw").toString());
		
	}

}


