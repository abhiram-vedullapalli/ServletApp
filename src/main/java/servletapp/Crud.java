package servletapp;

import java.io.PrintWriter;
import java.util.*;

public class Crud {
	static HashMap<String, Details> players = new HashMap<>();

	public static void createPlayer(String name, String team, int age) {

		players.put(name, new Details(name, team, age));

	}

	public static String retrievePlayer(String name) {
	if(players.containsKey(name)) {
		String result = players.get(name).toString();
		return result;
	}else {
		String doNotExist = "Oops ...!!! Player does not Exist on list";
		return doNotExist;
	}
		
	}

	public static String updatePlayer(String name ,String team , int age) {
		if(players.containsKey(name)) {
			players.get(name).setTeam(team);
			players.get(name).setAge(age);
			String result= "Player value updated";
			return result;
		}else {
			String doNotExist = "Oops ...!!! Player does not Exist on list";
			return doNotExist;

		}
	}
	

	public static String deletePlayer(String name) {
		if(players.containsKey(name)) {
			players.remove(name);
			String removed = "Player removed";
			return removed;
		}else {
			String doNotExist = "Player doesn't exist in list";
			return doNotExist;
		}
	}

	public static void listAllPlayers(PrintWriter out) {
		if(players.isEmpty()) {
			out.println("List is Empty. Create Players");
		}
		else {
		for (HashMap.Entry<String, Details> entry : players.entrySet()) {
			out.println("<p> " + entry.getValue() + "</p> <form action=\"DeleteButton\" method=\"post\"> <input type=\"hidden\" value="+ entry.getKey() +" name=\"username\"> <input type=\"submit\" value=\"Delete this Player\"></form>");
			out.println("<br>");
		}
		}
	}

	// whatever the case , the user may give his inputs.
	// this function converts input such that (Starting letter of every word in
	// string is in upper case)
	// this helps while retrieving and updating the data from the Hashmap
	public static String anyCase(String s) {
		char[] c = s.toCharArray();
		for(int i =0; i < s.length(); i++) {
			c[i] = Character.toLowerCase(c[i]);
		}
		c[0] = Character.toUpperCase(s.charAt(0));
		for (int i = 1; i < s.length(); i++) {
			
			if (c[i] == ' ') {
				c[i + 1] = Character.toUpperCase(c[i + 1]);
			}
		}

		return String.valueOf(c);

	}
	

}
