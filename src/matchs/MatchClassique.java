package matchs;

import java.util.Random;

import competition.Competitor;

/**
 * A MatchClassic Class
 * play a classic random winner match between two competitors 
 * @author BENABDALLAH Anisse, LARZUL Hippolyte
 **/


public class MatchClassique implements Match {
	
	
	private Competitor winner ;
	private Competitor loser ;


	/**
	 * play a random match and return the winner
	 * @param c1 Competitor
	 * @param c2 Competitor
	 **/
	public void playMatch(Competitor c1, Competitor c2) {
		Random r = new Random();
        int n = r.nextInt(2);
        c1.addMatch(1);
		c2.addMatch(1);
        if(n==1) {
        	c1.AddPoints(1);
        	winner = c1;
        	loser= c2;
        	System.out.println(c1.getName() +" vs "+c2.getName() +" --> "+c1.getName()+" WIN !!");
        	
        }
        else {
        	c2.AddPoints(1);
        	winner = c2;
        	loser= c1;
        	System.out.println(c1.getName() +" vs "+c2.getName() +" --> "+c2.getName()+" WIN !!");
        	
        }
	}
	
	
	/**
	 * return the winner of the match 
	 * @return the winner of the match 
	 */
	public Competitor getWinner() {
		return winner;
	};
	
	
	/**
	 * return the Loser of the match 
	 * @return the Loser of the match 
	 */
	public Competitor getLoser() {
		return loser;
	};

}
