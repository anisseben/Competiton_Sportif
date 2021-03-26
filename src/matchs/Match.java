package matchs;

import competition.Competitor;

/**
 * Match Interface
 *
 * @author BENABDALLAH Anisse, LARZUL Hippolyte
 *
 **/


public interface Match {
	
	
	/**
	 * play a match and return the winner
	 * @param c1 Competitor
	 * @param c2 Competitor
	 **/
	public void playMatch(Competitor c1,Competitor c2);
	
	
	/**
	 * return the winner of the match 
	 * @return the winner of the match 
	 */
	public Competitor getWinner();
	
	
	/**
	 * return the Loser of the match 
	 * @return the Loser of the match 
	 */
	public Competitor getLoser();
	
	
}
