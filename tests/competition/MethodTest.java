package competition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import methods.Method;
import util.MapUtil;

public abstract class MethodTest {
	
	protected Method meth ;
	
	// Factory method for the subclass
	protected abstract Method createMethod();
	
	@Before
	public void init() {
		this.meth = this.createMethod();
	}
	
	@Test
	public void qualifiedPowerOfTwoTest() {
		
		assertEquals(2,meth.qualifiedPowerOfTwo(6,1));
		assertEquals(0,meth.qualifiedPowerOfTwo(4, 1));
		assertEquals(1,meth.qualifiedPowerOfTwo(3, 1));
		
	}
	
	@Test 
	public void selectionTest() {
		 Competitor c1 = new Competitor("Warriors");
		 Competitor c2 = new Competitor("Bulls");
		 Competitor c3 = new Competitor("Bucks");
		Map<Competitor, Integer> ranking1 = new HashMap<Competitor, Integer>();
		
		ranking1.put(c1, 4);
		ranking1.put(c2, 3);
		ranking1.put(c3, 1);
		
		List<Competitor> selection = meth.selection(MapUtil.sortByDescendingValue(ranking1),2);
		assertTrue(selection.contains(c1));
		assertTrue(selection.contains(c2));
		assertFalse(selection.contains(c3));
	}
	
	
	

	public static junit.framework.Test suite() {
    	return new junit.framework.JUnit4TestAdapter(competition.MethodTest.class);
    }
}
