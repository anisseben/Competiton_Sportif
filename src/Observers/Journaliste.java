package Observers;

import competition.Competition;
import competition.Competitor;

/**
* A Journalist Class
* The Journalist that will display the results of the matches
* @author BENABDALLAH Anisse, LARZUL Hippolyte
*/

public class Journaliste implements Observer {

	/**
	 * display the results of the match 
	 * @param ev CompetitionEvent
	 */
	public void MatchWatched(CompetitionEvent ev) {
		Competition c =  (Competition) ev.getSource();	
		Competitor winner = c.getMatch().getWinner();
		Competitor loser = c.getMatch().getLoser();
		
		System.out.println(winner.getName()+" winned against "+loser.getName());
	}

}
