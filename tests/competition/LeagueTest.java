package competition;

import static org.junit.Assert.*;

/**
*
* The Test Class of the class League
*
* @author BENABDALLAH ; LARZUL
*
**/

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class LeagueTest extends CompetitionTest{
	
	private Competition league;
	 
	protected Competition createCompetition(){
		List<Competitor> competitors = new ArrayList<Competitor>();
		competitors.add(new Competitor(" Blastoff"));
		competitors.add(new Competitor(" Lynx"));
		competitors.add(new Competitor(" Catalyst"));
		competitors.add(new Competitor(" Raven"));
		competitors.add(new Competitor(" Midas"));
		competitors.add(new Competitor(" Barca"));
		competitors.add(new Competitor(" Bayern"));
		competitors.add(new Competitor(" Real"));
		return new League(competitors);
	}; 
	
	
	@Before
	public void init() {
		this.league = createCompetition();
	}
	
	
	@Test
	public void GoodNumberOfMatchTest() throws IllegalNumberException{
		
		
		league.play();	
		Map<Competitor,Integer> map=league.ranking();
		Competitor winner = map.entrySet().iterator().next().getKey();// get the winner 
		assertEquals(14,winner.getnbrMatch());
	}
	
	
	public static junit.framework.Test suite() {
    	return new junit.framework.JUnit4TestAdapter(competition.LeagueTest.class);
    }
}