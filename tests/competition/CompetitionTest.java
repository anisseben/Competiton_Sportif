package competition;

/**
*
* The Test Class of the class Competition
*
* @author BENABDALLAH ; LARZUL
*
**/


public abstract class CompetitionTest {
	
	
	// Factory method for the subclass
	protected abstract Competition createCompetition() throws IllegalNumberException;
	
		
	 
	public static junit.framework.Test suite() {
    	return new junit.framework.JUnit4TestAdapter(competition.CompetitionTest.class);
    }

}
 