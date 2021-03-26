package competition;

/**
* A Master Class
* the Master mode of competition
* @author BENABDALLAH Anisse, LARZUL Hippolyte
*/


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import methods.Method;


public class Master extends Competition{
	
	/* the method of selection */
	private Method methode ;
	/* number of groups */
	private int nbrGroups;
	
	/**
	 * create a Master Competition 
	 * @param competitors list of competitors
	 * @param nbrGroups number of groups 
	 * @param methode the method of selection
	 **/
	public Master(List<Competitor> competitors,int nbrGroups, Method methode) throws IllegalNumberException  {
		super(competitors);
		this.methode = methode;
		this.nbrGroups = nbrGroups;
		assertNumber(competitors);
	}
	
	
	/** 
	 * @param comp competitors
	 * @throws IllegalNumberException 
	 *  
	 **/
	public void assertNumber(List<Competitor> comp) throws IllegalNumberException {
		int size = comp.size();
		if (!(size%nbrGroups==0)||(size==0)) {
		throw new IllegalNumberException("Illegal number of competitors most be multiple of eight");
		}		
	};
	 
	/**
	 * Initial the number of points of each competitors to 0
	 * @param comp list of competitors
	 * 
	 */
	public void setInitialPoints(List<Competitor> comp) {
		for (int i=0;i<comp.size();i++) {
			comp.get(i).setInitialPoint();
		}
	}
	
	
	/*
	 * play the group stage and return the ranks 
	 * @param comp List of competitors
	 * @return the ranks 
	 */
	public List<Map<Competitor,Integer>> league (List<Competitor> comp) throws IllegalNumberException{
		
		List<Competitor> group = new ArrayList<Competitor>();
		List<Map<Competitor, Integer>> ranks = new ArrayList<Map<Competitor, Integer>>();
		int playerNbr = comp.size()/nbrGroups;
		
		int c=0;
		for (int j=0;j<nbrGroups;j++) {
			for (int x=0;x<playerNbr;x++) {
				group.add(comp.get(c));
				c++;
			}
			League league = new League(group);
			
			// add the observers of the super class
			league.addObservers(this.observers);
			// play the league 
			league.play();
			// display the results
			league.display(league.ranking());
			ranks.add(league.ranking());	
			group.clear();
		}	
		
		return ranks;
	}
	
	
	/*
	 * play the final stage the tournament 
	 * @param qualified the qualified players for the final stage
	 */
	public void tournoi(List<Competitor> qualified) throws IllegalNumberException{
		
		Tournament tournoi = new Tournament(qualified);
		// add the observers of the super class
		tournoi.addObservers(this.observers);
		// play the tournament
		tournoi.play();
		// display the results 
		this.display(ranking());
	}
	
	
	
	/**
	 * play all the matches between competitors in Master mode
	 * @param comp list of competitors
	 * @throws IllegalNumberException
	 */
	@Override
	protected void play(List<Competitor> comp) throws IllegalNumberException {
		
		
		// groups stage :
		
		List<Map<Competitor,Integer>> ranks = league(comp);
		
		// selection :
		
		List<Competitor> qualified = new ArrayList<Competitor>();
		qualified = methode.Qualified(ranks,nbrGroups,comp.size());
		
		// final stage :
		
		setInitialPoints(competitors);
		setInitialPoints(qualified);
		
		tournoi(qualified);
		

	}
	
}
