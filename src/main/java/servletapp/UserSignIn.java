package servletapp;
import java.util.*;

public class UserSignIn {
	static HashMap<String,String> credentials = new HashMap<>();
	
	public static void addUser(String uname , String pword) {
		credentials.put(uname, pword);
	}
	
	public static boolean getUser(String uname , String pword) {
		if(credentials.containsKey(uname) && (credentials.get(uname) == pword)) {
			return true;
		}else {
			return false;
		}
	}
} 
