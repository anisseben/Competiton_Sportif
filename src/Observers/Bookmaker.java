package Observers;
import competition.Competition;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import competition.Competition;
import competition.Competitor;

/**
* A Bookmaker Class
* The Bookmaker that will display the cotes of the player after every match
* @author BENABDALLAH Anisse, LARZUL Hippolyte
*/



public class Bookmaker implements Observer {
	
	// List of competitors
	private List<Competitor> competitors = new ArrayList<Competitor>();
	// map of the cotes of the palyers
	private Map<Competitor,Integer> cotes = new HashMap<Competitor,Integer>();
	// the initial cote of every player 
	private static int coteInit = 5;
	
	
	/**
	 * display the cotes of the players after the match 
	 * @param ev CompetitionEvent
	 */
	public void MatchWatched(CompetitionEvent ev) {
		int c1,c2;
		Competition c =  (Competition) ev.getSource();	
		competitors = c.getCompetitors();
		Competitor winner = c.getMatch().getWinner();
		Competitor loser = c.getMatch().getLoser();

		updateCotes(competitors);

		c1= cotes.get(winner);
		c2= cotes.get(loser);

		cotes.replace(winner, c1-1);
		cotes.replace(loser, c2+1);
		System.out.println("Victoire de "+winner.getName()+" (cote "+ c1+") face à "+loser.getName()+" (cote "+c2+"). La cote de "+winner.getName()+" passe à "+ (c1-1)+", celle de "+loser.getName()+" à "+ (c2+1));
	}
	
	
	
	/**
	 * update the map of cotes  
	 * @param competitors list of competitors
	 */
	public void updateCotes(List<Competitor> competitors) {
		
		for (Competitor c : competitors) {
			if (!(cotes.containsKey(c)))
			   cotes.put(c,coteInit);
		}
	}
}
