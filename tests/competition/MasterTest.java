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

import methods.BestSeconds;


public class MasterTest extends CompetitionTest{
	
	
	private Competition master;
	private List<Competitor> competitors= new ArrayList<Competitor>();;
	
	protected Competition createCompetition() throws IllegalNumberException{

		competitors.add(new Competitor(" Blastoff"));
		competitors.add(new Competitor(" Lynx"));
		competitors.add(new Competitor(" Catalyst"));
		competitors.add(new Competitor(" Raven"));
		competitors.add(new Competitor(" Midas"));
		competitors.add(new Competitor(" Barca"));
		competitors.add(new Competitor(" Bayern"));
		competitors.add(new Competitor(" Real"));
		competitors.add(new Competitor(" Lakers"));
		competitors.add(new Competitor(" Warriors"));
		competitors.add(new Competitor(" Cleapers"));
		competitors.add(new Competitor(" Rockets"));
		competitors.add(new Competitor(" Thunders"));
		competitors.add(new Competitor(" Heat"));
		competitors.add(new Competitor(" Celtics"));
		competitors.add(new Competitor(" Bucks"));
		return new Master(competitors,4,new BestSeconds());
	};  
	
	@Before
	public void init() throws IllegalNumberException {
		this.master = createCompetition();
	}
	
	

	@Test
	public void TesttheGoodNumberOfMatch() throws IllegalNumberException{
		
		master.play();
		Map<Competitor,Integer> map=master.ranking();  
		Competitor winner = map.entrySet().iterator().next().getKey();// get the winner 
		assertEquals(2,winner.getPoints());
		assertEquals(8,winner.getnbrMatch());
	
	}
	
	
	@Test (expected = IllegalNumberException.class)
	public void TestIllegalNumberException() throws IllegalNumberException{
		
		List<Competitor> competitors = new ArrayList<Competitor>();
		competitors.add(new Competitor(" Blastoff"));
		competitors.add(new Competitor(" Lynx"));
		competitors.add(new Competitor(" Catalyst"));
		competitors.add(new Competitor(" Raven"));
		competitors.add(new Competitor(" Midas"));
		competitors.add(new Competitor(" Barca"));
		competitors.add(new Competitor(" Bayern"));
		competitors.add(new Competitor(" Real"));
		competitors.add(new Competitor(" Lakers"));
		competitors.add(new Competitor(" Warriors"));
		competitors.add(new Competitor(" Cleapers"));
		competitors.add(new Competitor(" Rockets"));
		competitors.add(new Competitor(" Thunders"));
		competitors.add(new Competitor(" Heat"));
		competitors.add(new Competitor(" Celtics"));
		competitors.add(new Competitor(" Bulls"));
		
		
		new Master(competitors,5,new BestSeconds());
	   
	}
	
	 public static junit.framework.Test suite() {
    	return new junit.framework.JUnit4TestAdapter(competition.MasterTest.class);
    }
}
