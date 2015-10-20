package security;

public class SecurityUtils {

	
	public static String encrypt(String pw){
		//TODO ENCRYPT PWD
		String epw = BCrypt.hashpw(pw, BCrypt.gensalt(12));
		pw = null;
		return epw;
	}
	
	public static boolean checkString(String text){
		//TODO add other verifications later
		return !text.contains("'");
	}
}
