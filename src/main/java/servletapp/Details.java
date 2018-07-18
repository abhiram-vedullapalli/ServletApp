package servletapp;

public class Details {
	
	private String name;
	private String team;
	private String age;
	Details(String name ,String team, String age){
		this.name = name;
		this.team = team;
		this.age = age;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String n) {
		this.name = n;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String n) {
		this.team = n;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String toString() {
		return "Name : " + name + " ; Team : " + team + "; Age : " + age ;
		
	}
}
