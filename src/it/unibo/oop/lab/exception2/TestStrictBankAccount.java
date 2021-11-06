package it.unibo.oop.lab.exception2;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * JUnit test to test
 * {@link StrictBankAccount}.
 * 
 */
public final class TestStrictBankAccount {

    /**
     * Used to test Exceptions on {@link StrictBankAccount}.
     */
    @Test
    public void testBankOperations() {
    	AccountHolder account1 = new AccountHolder("Mario", "Rossi", 1);
    	AccountHolder account2 = new AccountHolder("Filippo", "Verdi", 2);
    	
    	BankAccount MarioRossiBank = new StrictBankAccount(1, 10_000, 10);
    	BankAccount FilippoVerdiBank = new StrictBankAccount(2, 10_000, 10);
    	
    	try {
            MarioRossiBank.deposit(2, 100);
            fail();
        }catch (WrongAccountHolderException e) {
            assertNotNull(e);
        }
    	
        for (int i = 0; i < 5; i++) {
            try {
                FilippoVerdiBank.depositFromATM(account2.getUserID(), 1);
            } catch (TransactionsOverQuotaException e) {
                fail("Not exceeded yet max no. transactions!");
            }
        }

        try {
            FilippoVerdiBank.depositFromATM(account2.getUserID(), 1);
            fail("Should raise the exception signaling that we exceeded max no. transactions!");
        } catch (TransactionsOverQuotaException | WrongAccountHolderException e) {
            assertNotNull(e);
        }
        
        try {
            MarioRossiBank.withdraw(account1.getUserID(), 50_000);
        } catch (WrongAccountHolderException e) {
            fail();
        } catch (NotEnoughFoundsException e) {
            assertNotNull(e);
        }
    }
}
