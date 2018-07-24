package servletapp;

import static org.junit.Assert.*;

import org.junit.Test;

public class CrudCreateTest {
	Crud c = new Crud();
	
	
	@Test
	public void testCreatePlayer_NumOfPlayersInHashMap() {
		c.createPlayer("Abhiram", "India", 20);
		assertEquals("No. of Players in HashMap",1,c.players.size());
	}
	
	@Test
	public void testCreatePlayer_NumOfPlayersAfterDeleting() {
		c.players.remove("Abhiram");
		assertEquals(0,0);
	}
	
	//Test case will fail as the age is given as String
	@Test
	public void testCreatePlayer_AllDetailsAreStrings() {
		
		//c.createPlayer("Sachin","India", "34");
	}
	
	//Failing Test Case as all details are integers , Player will not be created
	@Test
	public void testCreatePlayer_AllDetailsAreIntegers() {
		//c.createPlayer(23, 34, 12);
	}
}
