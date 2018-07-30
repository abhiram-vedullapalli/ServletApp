package servletapp;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CrudCreateTest {
	Crud c = new Crud();

	@Before
	public void testCrud_CheckInitialSize() {
		int size = c.players.size();
	}
	
	@Test
	public void testCrud_NumOfPlayersInHashMap() {
		c.createPlayer("Abhiram", "India", 20);
		
		assertEquals("No. of Players in HashMap",1,c.players.size());
	}
	
	@After
	public void testCrud_DeleteAllPlayers() {
		c.players.clear();
	}
	

	
	}
