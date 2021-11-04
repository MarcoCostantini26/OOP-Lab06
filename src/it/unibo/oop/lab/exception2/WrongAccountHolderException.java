package it.unibo.oop.lab.exception2;

public class WrongAccountHolderException extends IllegalStateException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int userID;
	
	public WrongAccountHolderException(int userID) {
		this.userID = userID;
	}

	@Override
	public String toString() {
		return "WrongAccountHolderException [userID=" + userID + "]";
	}
	
	public String getMessage() {
		return this.toString();
	}

}
