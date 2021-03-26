package competition;

/**
*
* The Test Class of the class Tournament
*
* @author BENABDALLAH ; LARZUL
*
**/


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import competition.Competition;
import competition.Competitor;
import competition.IllegalNumberException;
import competition.Tournament;

public class TournamentTest extends CompetitionTest{
	
	
	private Competition tournoi;
	
	protected Competition createCompetition() throws IllegalNumberException{
		List<Competitor> competitors = new ArrayList<Competitor>();
		competitors.add(new Competitor(" Blastoff"));
		competitors.add(new Competitor(" Lynx"));
		competitors.add(new Competitor(" Catalyst"));
		competitors.add(new Competitor(" Raven"));
		competitors.add(new Competitor(" Midas"));
		competitors.add(new Competitor(" Barca"));
		competitors.add(new Competitor(" Bayern"));
		competitors.add(new Competitor(" Real"));
		return new Tournament(competitors);
	};  
	
	@Before
	public void init() throws IllegalNumberException {
		this.tournoi = createCompetition();
	}

	@Test
	public void TesttheGoodNumberOfMatch() throws IllegalNumberException{
		
		tournoi.play();
		Map<Competitor,Integer> map=tournoi.ranking();
		Competitor winner = map.entrySet().iterator().next().getKey();// get the winner 
		assertEquals(3,winner.getPoints());
		assertEquals(3,winner.getnbrMatch());
	
	}
	
	
	@Test (expected = IllegalNumberException.class)
	public void TestIllegalNumberException() throws IllegalNumberException{
		List<Competitor> competitors = new ArrayList<Competitor>();
		competitors.add(new Competitor(" Midas"));
		competitors.add(new Competitor(" Barca"));
		competitors.add(new Competitor(" Bayern"));
		
		
		new Tournament(competitors);
	   
	}
	
	 public static junit.framework.Test suite() {
    	return new junit.framework.JUnit4TestAdapter(competition.TournamentTest.class);
    }
}
