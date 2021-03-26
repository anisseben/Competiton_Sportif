package methods;

/**
* A BestSeconds Class 
* A Method that will select the best player from each group and the best seconds to the final stage.
* @author BENABDALLAH Anisse, LARZUL Hippolyte
*/


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import competition.Competitor;


public class BestSeconds extends Method {
	
	
	private static final int nbrOfqualification = 1;

	
	/**
	  * @param ranks List of ranks
	  * @param nbrGrp number of groups 
	  * @param nbrComp number of competitors
	  * @return the qualified Competitors
	  */
	public List<Competitor> Qualified(List<Map<Competitor, Integer>> ranks, int nbrGrp , int nbrComp){
		
		List<Competitor> qualified = new ArrayList<Competitor>();
		Map<Competitor, Integer> seconds= new HashMap<Competitor, Integer>();
		int nbrOfSeconds = qualifiedPowerOfTwo(nbrGrp,nbrOfqualification);
		for (int i =0 ; i< nbrGrp ;i++) {
			
			Iterator<Competitor> it = ranks.get(i).keySet().iterator();
			Competitor c1 = it.next();
			Competitor c2 = it.next();
			qualified.add(c1);
			seconds.put(c2, ranks.get(i).get(c2));
		}
		qualified.addAll(selection(seconds,nbrOfSeconds));
		return qualified;
	 }
	
	
		
	


}
