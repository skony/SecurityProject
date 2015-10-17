


import security.Authenticator;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Authenticator auth = new Authenticator();
		System.out.println(auth.login("root", "rootpw").toString());
		System.out.println(auth.create_account("john5", "1235", "1235"));
		
	}

}


