package it.unibo.oop.lab.exception2;

public class TransactionsOverQuotaException extends IllegalStateException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int totalTransactionCount;

	public TransactionsOverQuotaException(int totalTransactionCount) {
		super();
		this.totalTransactionCount = totalTransactionCount;
	}

	@Override
	public String toString() {
		return "TransactionsOverQuotaException [totalTransactionCount=" + totalTransactionCount + "]";
	}

	public String getMessage() {
		return this.toString();
	}
	

}
