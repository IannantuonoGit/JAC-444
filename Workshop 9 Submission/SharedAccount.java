/***************************************************************/
/* Name: Giuliano Iannantuono                                  */
/* Completed On: 2020-08-03                                    */
/*                                                             */
/* Version: FINAL                                              */
/*                                                             */
/* I confirm that the content of this file was created by me   */
/* with exception of the parts provided to me by my professor  */                         
/***************************************************************/

package threaded;

// Container Class.
public class SharedAccount {

	// Class field declarations.
	private int sharedBalance = 0;
	private String sharedCurrencyType;

	// Deposit transaction.
	public synchronized void depositToAccount(Fund deposit){
		// While the shared balance does not equal to zero and the sharedCurrencyType is not equal to the deposits
		// currency type the wait method will be called to wait until a withdraw happens as the producer should not be
		// able to deposit money of another currency type if there is money already deposited and if it is of a different currency type.
		while(sharedBalance != 0 && sharedCurrencyType != deposit.getFundCurrencyType()){
			try {
				System.out.println("\nWaiting for Withdraw...");
				wait();
			} catch (InterruptedException err) {
				System.out.println(err.getMessage());
			}
		}

		// Checks to see if the currency type of the passed object is not of the same type
		// located within the sharedCurrencyType, if this is true then it will set the sharedCurrencyType
		// to the currency type of the passed object.
		if(deposit.getFundCurrencyType() != sharedCurrencyType) {
			sharedCurrencyType = deposit.getFundCurrencyType();
		}

		// Adds the deposit amount located within the deposit to the sharedBalance.
		sharedBalance += deposit.getFundAmount();

		System.out.println("\n-----DEPOSIT-----");
		// Prints out the current threads name, the deposit amount and the currency type of the deposit.
		System.out.println(Thread.currentThread().getName() + deposit.getFundAmount() + " " + deposit.getFundCurrencyType());
		// Prints out the shared balance and the shared currency type.
		System.out.println("Shared Balance: " + sharedBalance + " " + sharedCurrencyType);

		// Wakes up the withdraw thread that is waiting on this monitor.
		notify();
	}

	// Withdraw transaction.
	public synchronized void withdrawFromAccount(int withdrawAmount) {
		// While the sharedBalance equals 0 or the sharedBalance is less then the withdrawAmount 
		// the wait method will be called to wait until a deposit happens as the consumer should not be
		// able to withdraw money if the balance is 0 and or if the withdraw amount is more than the sharedAmount.
		while (sharedBalance == 0 || sharedBalance < withdrawAmount) {
			try {
				System.out.println("\nWaiting for deposit...");
				wait();
			} catch (InterruptedException err) {
				System.out.println(err.getMessage());
			}
		}

		// Subtracts the incoming withdrawAmount from the sharedBalance.
		sharedBalance -= withdrawAmount;

		System.out.println("\n-----WITHDRAW-----");
		// Prints out the current threads name and the withdrawAmount.
		System.out.println(Thread.currentThread().getName() + withdrawAmount);
		// Prints out the shared balance and the shared currency type.
		System.out.println("Shared Balance: " + sharedBalance + " " + sharedCurrencyType);

		// Wakes up the deposit thread that is waiting on this monitor.
		notify();
	}
}