package methods;

/**
* A Method Class 
* A abstract Method that will select the best player from each group and the best seconds to the final stage.
* @author BENABDALLAH Anisse, LARZUL Hippolyte
*/


import java.util.ArrayList;
import java.util.Iterator;

/**
 * Method Interface
 *
 * @author BENABDALLAH Anisse, LARZUL Hippolyte
 *
 **/

import java.util.List;
import java.util.Map;

import competition.Competitor;
import util.MapUtil;

public abstract class Method {
	
	/**
	 * @param methodeNbr a number 
	 * @param nbrGrp number of groups 
	 * @return the number of player in the third or second position that will be selected 
	 */
	public int qualifiedPowerOfTwo(int nbrGrp, int methodeNbr) {
		int n= nbrGrp*methodeNbr;
		int p=1;
		while(p<n) {
		p=p*2;;
		}
		if (p==n){
			 return 0;
		}	 
		else {
			return p-n;
		}	        
	}
	
	/**
	  * @param comp List of Competitors
	  * @param nbrGrp number of groups 
	  * @param nbrPlayer number of player qualified 
	  * @return the qualified Competitors
	  */
	 abstract public List<Competitor> Qualified(List<Map<Competitor, Integer>> comp, int nbrGrp, int nbrPlayer ) ;
	 	
    /**	
	 * @param comp a Map of the competitors 
	 * @param nbrQualified number of qualified player 
	 * @return the best competitors 
	*/
	public List<Competitor> selection(Map<Competitor, Integer> comp,int nbrQualified){
		List<Competitor> qualified = new ArrayList<Competitor>();
		Map<Competitor, Integer> map = MapUtil.sortByDescendingValue(comp);
		Iterator<Competitor> it = map.keySet().iterator();
		for (int i=0; i<nbrQualified;i++) {
			Competitor c = it.next();
			qualified.add(c);
		}
		return qualified;
			
			
		}
}
