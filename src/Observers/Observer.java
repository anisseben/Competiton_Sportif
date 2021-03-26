package Observers;

/**
 * The Observer Interface 
 */

public interface Observer extends java.util.EventListener {

	/*
	 * Display the results of the matches depending on the observer  
	 */
	public void MatchWatched(CompetitionEvent ev);

}
