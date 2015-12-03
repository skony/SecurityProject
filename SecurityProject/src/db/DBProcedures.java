package db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import hsm.AdminInfo;
import hsm.InternalInfo;
import hsm.MedCaseInfo;
import hsm.MedRecord;
import hsm.PatReport;
import hsm.StatisticsIndicatorId;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
import security.Account;

public class DBProcedures {



	private static Connection getConn(){
		DataStoreInfo dsi = new DataStoreInfo();
		Connection conn = dsi.getMetaStore();
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


	public static boolean create_user(String username, String firstname, String lastname, String pwd, int role){
		Connection conn = getConn();
		try{
			CallableStatement stmt = conn.prepareCall("BEGIN create_user_sec(?,?,?,?,?); END;");
			stmt.setString(1, username); //username
			stmt.setString(2, firstname);
			stmt.setString(3, lastname);
			stmt.setInt(4, role);
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


	//HSM
	public static MedRecord create_medRecord(String username){
		Connection conn = getConn();
		int userid = getAccount(username).getId();
		int id=0;
		try{
			CallableStatement stmt = conn.prepareCall("BEGIN create_medicalrecord(?, ?); END;");
			stmt.setInt(1, userid); //username
			stmt.registerOutParameter(2, OracleTypes.CURSOR); //REF CURSOR
			stmt.execute();
			ResultSet rs = ((OracleCallableStatement)stmt).getCursor(2);
			while (rs.next()) {
				id = rs.getInt("id");
			}
			MedRecord rec = new MedRecord(id,null,null,null,null,null);
			stmt.close();
			stmt = null;
			conn.close();
			conn = null;
			return id!=0?rec:null;
		}
		catch (SQLException e) {
			System.out.println(e.getLocalizedMessage());
			return null;
		}
	}

	public static MedRecord update_patRecord(String username, int medrecordid, int patId, Date date, int age){
		Connection conn = getConn();
		Account user = getAccount(username);
		int userid = user.getId();
		int role = user.getRole();
		if(role != 3 && role !=4){
			return null;
		}
		try{
			CallableStatement stmt = conn.prepareCall("BEGIN update_patrecord(?,?,?,?,?, ?); END;");
			stmt.setInt(1, userid); //username
			stmt.setInt(2, medrecordid);
			stmt.setInt(3, patId);
			stmt.setDate(4, date);
			stmt.setInt(5, age);
			stmt.registerOutParameter(6, OracleTypes.CURSOR); //REF CURSOR
			stmt.execute();
			ResultSet rs = ((OracleCallableStatement)stmt).getCursor(6);
			MedRecord rec = createObject(rs);
			stmt.close();
			stmt = null;
			conn.close();
			conn = null;
			return rec;
		}
		catch (SQLException e) {
			System.out.println(e.getLocalizedMessage());
			return null;
		}
	}


	public static MedRecord update_medcaseinfo(String username, int medrecordid, int diseaseId, String prescription, String notes, int doctorid){
		Connection conn = getConn();
		Account user = getAccount(username);
		int userid = user.getId();
		int role = user.getRole();
		if(role != 3){
			return null;
		}
		try{
			CallableStatement stmt = conn.prepareCall("BEGIN update_medicalcase(?,?,?,?,?,?, ?); END;");
			stmt.setInt(1, userid); 
			stmt.setInt(2, medrecordid);
			stmt.setInt(3, diseaseId);
			stmt.setString(4, prescription);
			stmt.setString(5, notes);
			stmt.setInt(6, doctorid);
			stmt.registerOutParameter(7, OracleTypes.CURSOR); //REF CURSOR
			stmt.execute();
			ResultSet rs = ((OracleCallableStatement)stmt).getCursor(7);
			MedRecord rec = createObject(rs);
			stmt.close();
			stmt = null;
			conn.close();
			conn = null;
			return rec;
		}
		catch (SQLException e) {
			System.out.println(e.getLocalizedMessage());
			return null;
		}
	}

	public static MedRecord update_AdminInfo(String username, int medrecordid, double price, String medicalcenter){
		Connection conn = getConn();
		Account user = getAccount(username);
		int userid = user.getId();
		int role = user.getRole();
		if(role != 4){
			return null;
		}
		try{
			CallableStatement stmt = conn.prepareCall("BEGIN update_admininfo(?,?,?,?, ?); END;");
			stmt.setInt(1, userid);
			stmt.setInt(2, medrecordid);
			stmt.setDouble(3, price);
			stmt.setString(4, medicalcenter);
			stmt.registerOutParameter(5, OracleTypes.CURSOR); //REF CURSOR
			stmt.execute();
			ResultSet rs = ((OracleCallableStatement)stmt).getCursor(5);
			MedRecord rec = createObject(rs);
			stmt.close();
			stmt = null;
			conn.close();
			conn = null;
			return rec;
		}
		catch (SQLException e) {
			System.out.println(e.getLocalizedMessage());
			return null;
		}
	}

	public static MedRecord createObject(ResultSet rs){
		MedRecord result = null;
		try{
			while (rs.next()) {		
				//patreport
				int id = rs.getInt("id");
				PatReport pat;
				if(rs.getInt("patreportid")<=0)
					pat=null;
				else{
					int patreportid = rs.getInt("patreportid");
					int patientid = rs.getInt("patientid");
					Date date = rs.getDate("datepat");
					int age = rs.getInt("age");
					pat = new PatReport(patreportid,patientid,date,age);
				}
				//MEDCASEINFO && STATS				
				MedCaseInfo medinfo;
				StatisticsIndicatorId stats = null;

				if(rs.getInt("medicalcaseid")<=0)
					medinfo=null;
				else{
					int medicalcaseid = rs.getInt("medicalcaseid");
					int disease = rs.getInt("diseaseid");
					String prescription = rs.getString("prescription");
					String notes = rs.getString("noter");
					int doctor = rs.getInt("doctorid");
					medinfo = new MedCaseInfo(medicalcaseid,disease,prescription,notes,doctor);
					if(disease!=0)
						stats = getStatsForDisease(disease);
				}
				//Admin info
				AdminInfo adminfo;
				if(rs.getInt("admininfoid")<=0)
					adminfo=null;
				else{
					int adminfoid = rs.getInt("admininfoid");
					double price = rs.getDouble("price");
					String medicalCenter = rs.getString("medicalcenter");
					adminfo = new AdminInfo(adminfoid,price,medicalCenter);
				}
				InternalInfo internal = new InternalInfo(rs.getTimestamp("creationdate"),rs.getInt("createdby"),rs.getTimestamp("lastmodified"),rs.getInt("modifiedby"));

				result = new MedRecord(id,pat,medinfo,adminfo,internal,stats);

			}
		}catch (SQLException e) {
			System.out.println(e.getLocalizedMessage());
			return null;
		}



		return result;
	}


	public static MedRecord fetchMedRecordById(int id){
		Connection conn = getConn();
		try{
			CallableStatement stmt = conn.prepareCall("BEGIN fetchmedrecordbyid(?, ?); END;");
			stmt.setInt(1, id);
			stmt.registerOutParameter(2, OracleTypes.CURSOR); //REF CURSOR
			stmt.execute();
			ResultSet rs = ((OracleCallableStatement)stmt).getCursor(2);
			MedRecord rec = createObject(rs);
			stmt.close();
			stmt = null;
			conn.close();
			conn = null;
			return rec;
		}
		catch (SQLException e) {
			System.out.println(e.getLocalizedMessage());
			return null;
		}
	}


	public static MedRecord fetchMedRecordByPatientId(int id){
		Connection conn = getConn();
		try{
			CallableStatement stmt = conn.prepareCall("BEGIN fetchmedrecordbypatient(?, ?); END;");
			stmt.setInt(1, id);
			stmt.registerOutParameter(2, OracleTypes.CURSOR); //REF CURSOR
			stmt.execute();
			ResultSet rs = ((OracleCallableStatement)stmt).getCursor(2);
			MedRecord rec = createObject(rs);
			stmt.close();
			stmt = null;
			conn.close();
			conn = null;
			return rec;
		}
		catch (SQLException e) {
			System.out.println(e.getLocalizedMessage());
			return null;
		}
	}

	public static void updatestats(){
		Connection conn = getConn();
		try{
			CallableStatement stmt = conn.prepareCall("BEGIN update_stats; END;");
			stmt.execute();
			stmt.close();
			stmt = null;
			conn.close();
			conn = null;
		}
		catch (SQLException e) {
			System.out.println(e.getLocalizedMessage());

		}
	}

	public static StatisticsIndicatorId getStatsForDisease(int id){
		Connection conn = getConn();
		try{
			CallableStatement stmt = conn.prepareCall("BEGIN DISEASESTATS(?, ?); END;");
			stmt.setInt(1, id);
			stmt.registerOutParameter(2, OracleTypes.CURSOR); //REF CURSOR
			stmt.execute();
			ResultSet rs = ((OracleCallableStatement)stmt).getCursor(2);
			StatisticsIndicatorId stats = null;
			while(rs.next())
				stats = new StatisticsIndicatorId(rs.getFloat("percentageofpatients"), rs.getFloat("percentageofrecords"));
			stmt.close();
			stmt = null;
			conn.close();
			conn = null;
			return stats;
		}
		catch (SQLException e) {
			System.out.println(e.getLocalizedMessage());
			return null;
		}
	}

}
