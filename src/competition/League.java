package competition;
import java.util.List;

/**
 * A League Class
 * the league mode of competition
 * @author BENABDALLAH Anisse, LARZUL Hippolyte
 */


public class League extends Competition {
	
	
	
	/**
	 * create a League Competition
	 * @param competitors list of competitors
	 */
	public League(List<Competitor> competitors) {
		super(competitors);
		
	}
	
	/**
	 * play all the matches between competitors in league mode
	 * @param competitors list of competitors
	 */
	@Override
	protected void play(List<Competitor> competitors) {
		
		for (int i = 0; i < competitors.size(); i++) {
			for (int j = 0; j < competitors.size(); j++) {
				if(i!=j) {
					playMatch(competitors.get(i), competitors.get(j));
				}
			}
        }
		
		
	}
	 
}
