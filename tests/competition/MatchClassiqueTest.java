package competition;

import static org.junit.Assert.*;

import org.junit.Test;

import matchs.MatchClassique;


/**
*
* The Test Class of the class ClassiqueMatch
*
* @author BENABDALLAH ; LARZUL
*
**/
 

public class MatchClassiqueTest {

	@Test
	public void Testplay() {
			
		Competitor competitor1 = new Competitor("real");
		Competitor competitor2 = new Competitor("barca");
		MatchClassique match = new MatchClassique();
		match.playMatch(competitor1, competitor2);
		assertEquals(1,competitor1.getnbrMatch());
		assertEquals(1,competitor2.getnbrMatch());
		int nbrTotalepoints= competitor1.getPoints()+competitor2.getPoints();
		assertEquals(1,nbrTotalepoints);

	}

	 public static junit.framework.Test suite() {
    	return new junit.framework.JUnit4TestAdapter(competition.MatchClassiqueTest.class);
    }
}

