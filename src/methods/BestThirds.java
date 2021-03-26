package methods;

/**
* A BestThirds Class 
* A Method that will select the best two player from each group and the best thirds to the final stage.
* @author BENABDALLAH Anisse, LARZUL Hippolyte
*/


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import competition.Competitor;


public class BestThirds extends Method {
	
	private static final int nbrOfqualification = 2;
	
	
	 /**
	  * @param ranks ranks of ranks
	  * @param nbrGrp number of groups 
	  * @param nbrComp number of Competitors
	  * @return the qualified Competitors
	  */
	 public List<Competitor> Qualified(List<Map<Competitor, Integer>> ranks, int nbrGrp , int nbrComp){
		
		List<Competitor> qualified = new ArrayList<Competitor>();
		Map<Competitor, Integer> thirds= new HashMap<Competitor, Integer>();
		int nbrOfThirds = qualifiedPowerOfTwo(nbrGrp,nbrOfqualification);
		for (int i =0 ; i< nbrGrp ;i++) {
			
			Iterator<Competitor> it = ranks.get(i).keySet().iterator();
			Competitor c1 = it.next();
			Competitor c2 = it.next();;
			Competitor c3 = it.next();;
			qualified.add(c1);
			qualified.add(c2);
			thirds.put(c3, ranks.get(i).get(c3));
		}
		qualified.addAll(selection(thirds,nbrOfThirds));
		return qualified;
	 }
	
	
	 
		 



	


}
