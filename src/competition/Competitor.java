package competition;

/**
 * A Competitors Class
 * Create a Competitor
 * @author BENABDALLAH Anisse, LARZUL Hippolyte
 *
 */


public class Competitor {
	
	
	/** name of competitor */
	private String name;
	
	/** number of points */
	private  int nb_points;
	
	/** number of matches **/
	private int nbrMatchs;
	
	/**
	 * create a competitor
	 * @param name competitor name
	 **/
	public Competitor(String name) {
		this.name = name;
		this.nb_points =0;
		this.nbrMatchs = 0 ;
		
	}
	
	/**
	 * return the name of the competitor
	 * @return name of competitor
	 **/
	public String getName() {
		return this.name;
	}
	
	/**
	 * return the competitor's points
	 * @return number of points of the competitor
	 **/
	public int getPoints() {
		return this.nb_points;
	}
	
	
	
	/**
	 * add the points earned by the competitor
	 * @param points earned
	 **/
	public void AddPoints(int points) {
		this.nb_points+=points;
	}
	
	
	
	/**
	 * return the string presentation of competitor
	 * @return string presentation of competitor
	 **/
	public String toString(){
		return "name of the competiteur :"+this.name+"\nnbr of points :"+this.nb_points;
	}
	
	
	
	/** add match to the competitor
	 *
	 * @param points the number of match that you can add to the competitor
	 **/
	  public void addMatch (int points) {
	    this.nbrMatchs += points;
	  }
	  
	  /**
	   * Initial the number of points to 0
	   */
	  public void setInitialPoint(){
	    this.nb_points=0;
	  }
	

	/**
	 * return the competitor's number of matchs
	 * @return number of matchs of the competitor
	 **/
	public int getnbrMatch() {
		return this.nbrMatchs;
	}
}
