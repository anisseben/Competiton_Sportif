package competition;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
*
* The Test Class of the class Competitor
*
* @author BENABDALLAH ; LARZUL
*
**/


public class CompetitorTests {
	
	private Competitor c1;
	private Competitor c2;
	
	@Before
	public void init() {
		this.c1= new Competitor("Blastoff");
		this.c2=new Competitor("Drift");
	}

	@Test
	public void getNameTest() {
		assertEquals("Blastoff",this.c1.getName());
		assertEquals("Drift",this.c2.getName());
	}
	
	@Test
	public void getPointsTest() {
		assertEquals(0,this.c1.getPoints());
		assertEquals(0,this.c2.getPoints());
	}
	
	@Test
	public void AddPointsTest() {
		c1.AddPoints(1);
		assertEquals(1,this.c1.getPoints());
		c2.AddPoints(2);
		assertEquals(2,this.c2.getPoints());
	}
	
	@Test
	public void addMatchTest() {
		c1.addMatch(1);
		assertTrue(this.c1.getnbrMatch()==1);
		c2.addMatch(1);
		assertTrue(this.c2.getnbrMatch()==1);
	}
	
	
	@Test 
	public void setInitialPointTest() {
		c1.AddPoints(1);
		assertEquals(1,this.c1.getPoints());
		c2.AddPoints(2);
		assertEquals(2,this.c2.getPoints());
		c1.setInitialPoint(); 
		assertTrue(this.c1.getPoints()==0);
		c2.setInitialPoint();
		assertTrue(this.c2.getPoints()==0);
	}
	
	
	public static junit.framework.Test suite() {
    	return new junit.framework.JUnit4TestAdapter(competition.CompetitorTests.class);
    }

}
