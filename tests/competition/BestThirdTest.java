package competition;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import methods.BestThirds;
import methods.Method;
import util.MapUtil;

public class BestThirdTest extends MethodTest {
	
	private Method method ;
	private List<Map<Competitor, Integer>> ranks = new ArrayList<Map<Competitor, Integer>>();
	private Competitor c1 ;
	private Competitor c2 ;
	private Competitor c3 ;
	private Competitor c4 ;
	private Competitor c5 ;
	private Competitor c6 ;
	private Competitor c7 ;
	private Competitor c8 ;
	private Competitor c9 ;
	
	public Method createMethod(){
		return new BestThirds();
	}
	@Before
	public void init_3() {
		method = createMethod(); 
		
		// Group 1 :
		 c1 = new Competitor("Warriors");
		 c2 = new Competitor("Bulls");
		 c3 = new Competitor("Bucks");
		Map<Competitor, Integer> ranking1 = new HashMap<Competitor, Integer>();
		
		ranking1.put(c1, 4);
		ranking1.put(c2, 3);
		ranking1.put(c3, 1);
		
		// Group 2 :

		 c4 = new Competitor("Rocket");
		 c5 = new Competitor("Celtics");
		 c6 = new Competitor("Cavaliers");
		Map<Competitor, Integer> ranking2 = new HashMap<Competitor, Integer>();
		
		ranking2.put(c4, 4);
		ranking2.put(c5, 3);
		ranking2.put(c6, 2);
		
		// Group 3 :
		 c7 = new Competitor("Lakres");
		 c8 = new Competitor("wolves");
		 c9 = new Competitor("Raptors");
		Map<Competitor, Integer> ranking3 = new HashMap<Competitor, Integer>();
		ranking3.put(c7, 5);
		ranking3.put(c8, 4);
		ranking3.put(c9, 3);
		
		// List of Ranks :
		ranks.add(MapUtil.sortByDescendingValue(ranking1));
		ranks.add(MapUtil.sortByDescendingValue(ranking2));
		ranks.add(MapUtil.sortByDescendingValue(ranking3));

	}

	@Test
	public void QualifiedTest() {
		
		List<Competitor> qualified = method.Qualified(ranks, 3, 9);
		assertTrue(qualified.contains(c1));
		assertTrue(qualified.contains(c2));
		assertTrue(qualified.contains(c4));
		assertTrue(qualified.contains(c5));
		assertTrue(qualified.contains(c6));
		assertTrue(qualified.contains(c7));
		assertTrue(qualified.contains(c8));
		assertTrue(qualified.contains(c9));
		assertFalse(qualified.contains(c3));
	}
	

	

	
	
	public static junit.framework.Test suite() {
    	return new junit.framework.JUnit4TestAdapter(competition.BestThirdTest.class);
    }
}
