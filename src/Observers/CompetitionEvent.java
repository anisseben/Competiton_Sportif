package Observers;

import competition.Competition;

public class CompetitionEvent extends java.util.EventObject {
	
	public CompetitionEvent(Competition source) {
		super(source);
	}
}