package competition;
import java.util.ArrayList;
import java.util.List;

import Observers.Bookmaker;
import Observers.Journaliste;
import Observers.Observer;
import methods.BestSeconds;



/**
 * A Main Competition Class
 * @author BENABDALLAH Anisse, LARZUL Hippolyte
 */


public class CompetitionMain {
	
	public static void main(String[]args) throws IllegalNumberException{
		List<Competitor> competitors = new ArrayList<Competitor>();
		competitors.add(new Competitor(" Blastoff"));
		competitors.add(new Competitor(" Lynx"));
		competitors.add(new Competitor(" Catalyst"));
		competitors.add(new Competitor(" Raven"));
		competitors.add(new Competitor(" Midas"));
		competitors.add(new Competitor(" Barca"));
		competitors.add(new Competitor(" Bayern"));
		competitors.add(new Competitor(" Real"));
		competitors.add(new Competitor(" Lakers"));
		competitors.add(new Competitor(" Warriors"));
		competitors.add(new Competitor(" Cleapers"));
		competitors.add(new Competitor(" Rockets"));
		competitors.add(new Competitor(" Thunders"));
		competitors.add(new Competitor(" Heat"));
		competitors.add(new Competitor(" Celtics"));
		competitors.add(new Competitor(" Bucks"));/**
		competitors.add(new Competitor(" Sixers"));
		competitors.add(new Competitor(" Bulls"));
		competitors.add(new Competitor(" Nuggets"));
		competitors.add(new Competitor(" Suns"));
		competitors.add(new Competitor(" Wolves"));
		competitors.add(new Competitor(" Grizles"));
		competitors.add(new Competitor(" Raptors"));
		competitors.add(new Competitor(" Piston"));

**/
		
		Observer journalist = new Journaliste();
		Observer bookmaker = new Bookmaker();
		
		//Competition league = new League(competitors);
		//league.play();
		
		//Competition tournoi = new Tournament(competitors);
		
		//tournoi.addObserver(journalist);
		//tournoi.play();
		
		Competition master = new Master(competitors,4,new BestSeconds());
		master.addObserver(journalist);
		master.addObserver(bookmaker);
		master.play();
		



	}
	
}
