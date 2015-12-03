


import java.sql.Date;

import javax.print.attribute.standard.DateTimeAtCompleted;

import db.DBProcedures;
import hsm.AdminInfo;
import hsm.HSMSystem;
import hsm.MedCaseInfo;
import hsm.MedRecord;
import hsm.PatReport;
import security.Account;
import security.Authenticator;
import security.BCrypt;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Authenticator auth = new Authenticator();
		//System.out.println(auth.create_account("PattiSmith", "rootpw", "rootpw"));
		
		//System.out.println(auth.create_account("DoctorWho", "thewho", "thewho",3));
		
		//Account acc = auth.login("regular2", "1234");
		//Account acc = auth.get_account("FrankZappa");
		//System.out.println(BCrypt.hashpw("1234", BCrypt.gensalt(12)));
		
		//System.out.println(acc!=null && acc.isLogged_in());
		
		//test HSM
		//HSMSystem.createNewRecord("DoctorWho");
		//HSMSystem.updatePatReport("Jimi", new MedRecord(1,null,null,null,null,null), new PatReport(0,25 ,new Date(2015,11,23), 50));
		//HSMSystem.updateMedCaseInfo("DoctorWho", new MedRecord(1,null,null,null,null,null), new MedCaseInfo(0, 1, "some prescription..", "some notes..", 26));
		//HSMSystem.updateAdminInfo("Jimi", new MedRecord(1,null,null,null,null,null), new AdminInfo(0, 5.5, "Houston"));
		
				
		
		//DBProcedures.create_medRecord(username);
		//System.out.println(auth.create_account("WayneCoyne", "flaming", "flaming"));
		//System.out.println(auth.delete_account("SydBarrett"));
		//System.out.println(auth.change_pwd("FrankZappa", "1234", "123456"));
		
		
		//PWTest.test1();
	}

}


