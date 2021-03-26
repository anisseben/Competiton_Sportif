package competition;

import java.util.ArrayList;
import java.util.List;

/**
 * A Tournament Class
 * the tournament mode of competition
 * @author BENABDALLAH Anisse, LARZUL Hippolyte
 **/


public class Tournament extends Competition{
	

		
	/**
	 * create a Tournament Competition
	 * @param competitors list of competitors
	 **/
	public Tournament(List<Competitor> competitors) throws IllegalNumberException  {
		super(competitors);
		assertNumbers(competitors);
	}
	
	
	/**
	 * @param competitors
	 * @throws IllegalNumberException 
	 *  
	 **/
	public void assertNumbers(List<Competitor> competitors) throws IllegalNumberException{
		int size = competitors.size();
		if (size > 0 && ( size & (size - 1)) != 0)
			throw new IllegalNumberException("La size ne convient pas au tournoi");
	}
	 
	
	
	/**
	 * play all the matches between competitors in tournament mode
	 * @param competitors list of competitors
	 **/
	@Override
	protected void play(List<Competitor> competitors) {	
        System.out.println("\nTOURNAMENT\n------------------------------\n");

		List<Competitor> comp = new ArrayList<Competitor>();
		comp.addAll(competitors);
		int round=1;
		 while(comp.size()>1) {
			 System.out.println("Round : "+round+"\n");		
			 for (int i = 0;  i<  comp.size(); i++) {
				   playMatch(comp.get(i),comp.get(i+1));
					if(comp.get(i).getPoints()==round) {
						comp.remove(i+1);
					}
					else {
						comp.remove(i); 
					}	
		 }
			 round++;
			 System.out.println("-----------------------------------------------");
			 
			
		 }
		 System.out.println("The Winner is :"+comp.get(0).getName()+" !!!"); 
	}

	
}
