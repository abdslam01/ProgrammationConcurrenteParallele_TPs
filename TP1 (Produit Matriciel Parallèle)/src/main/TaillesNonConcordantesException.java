package main;

class TaillesNonConcordantesException extends Exception{
	private static final long serialVersionUID = 1L;

	TaillesNonConcordantesException(String message){
		super(message);
	}
}