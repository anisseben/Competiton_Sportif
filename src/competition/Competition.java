package competition;
import Observers.*;
import matchs.Match;
import matchs.MatchClassique;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import util.MapUtil;


/**
 * A abstract Competition Class
 * Creat a Type of Competition
 * @author BENABDALLAH Anisse, LARZUL Hippolyte
 */



public abstract class Competition {
	/* the list of the competitors */
	protected List<Competitor> competitors;
	
	/* the Type of the Match */
	private final Match match;
	
	/* observers */
	protected ArrayList<Observer> observers = new ArrayList<Observer>();
	
	/**
	 * create a competition
	 * @param competitors the list of competitors 
	 **/
	public Competition(List<Competitor> competitors) {
		this.match = new MatchClassique();
		this.competitors= competitors;		
			
		}
	
	
	/**
	 * Add an observer to the list of the observers
	 * @param obs the Observer 
	 */
	public void addObserver (Observer obs) {
		observers.add(obs);
	}
	
	/**
	 * Add observers to the list of the observers
	 * @param obs the list of Observers to add
	 */
	protected void addObservers (List<Observer> obs) {
		for (Observer o : obs) {
			observers.add(o);
		}
	}
	
	/**
	 * Remove an observer from the list of the observers
	 * @param obs the Observer 
	 */
	public void removeObserver (Observer obs) {
		observers.remove(obs);
	}
	

	/**
	 * prevent the Observers when a match is played 
	 */
	protected void fireCompetition() {
		ArrayList<Observer> cl = (ArrayList<Observer>) observers.clone();
		if (cl.size() == 0) { return; }
		CompetitionEvent event = new CompetitionEvent(this);
		for (Observer obs : cl) {
			obs.MatchWatched(event);
		}
	}
	
	/**
	 * play competition between competitors
	 * @throws IllegalNumberException 
	 **/
	public void play() throws IllegalNumberException {
		for(int i=0;i<competitors.size();i++) {
			competitors.get(i).setInitialPoint();
		}
		play(competitors);
		Map<Competitor,Integer> resultat = new LinkedHashMap<Competitor,Integer>();
		resultat=ranking();
		//display(resultat);
		
	}
	
	
	/**
	 * return the match
	 * @return the match 
	 */
	public Match getMatch() {
		return match;
	}
	
	
	/**
	 *  play a Match 
	 * @param c1 Competitor
	 * @param c2 Competitor
	 **/
	protected void playMatch(Competitor c1,Competitor c2) {
		this.match.playMatch(c1, c2);
		fireCompetition();
	}

	
	/**
	 *  abstract method play 
	 * @param competitors the competitors
	 * @throws IllegalNumberException 
	 **/
	protected abstract  void play(List<Competitor> competitors) throws IllegalNumberException;
	
		
	/**
	 * sort the competitors
	 * @return a sorted Map of the competitors
	**/
	public Map<Competitor, Integer> ranking(){
		Map<Competitor, Integer> map= new HashMap<Competitor, Integer>();
		for(Competitor c: this.competitors){
			map.put(c, c.getPoints());
			}
		return MapUtil.sortByDescendingValue(map);
	}
	
	
	/**
	 * display the result of the ranking 
	 * @param result the sorted map
	 **/
	protected void display(Map<Competitor,Integer> result) {
		System.out.println("---------------------------------------------------");
		System.out.println("**Ranking**");
		for(Map.Entry<Competitor,Integer> c : result.entrySet() ){
        	System.out.println(c.getKey().getName()+" - "+c.getValue());
		}
        System.out.println("\n"+"------------------------------"+"\n");
 
	}


	/**
	 * return the list of competitors
	 * @return the list of competitors
	 */
	public List<Competitor> getCompetitors() {
		
		return competitors;
	}

	
	 
}