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

import java.util.ArrayList;

// Consumer Class.
public class AccountWithdraw extends Thread {

	// Class field declarations.
	private SharedAccount accountWithdraw;
	private ArrayList<Fund> funds;

	// AccountWithdraw constructor.
	public AccountWithdraw(SharedAccount jointAccount, ArrayList<Fund> fundList){
		super("Withdrawing: ");
		this.accountWithdraw = jointAccount;
		this.funds = fundList;
	}

	// Run method override
	// When called this method will loop through the fundList, it will first try to put the current thread into
	// a sleeping state for a random alloted time up to three seconds, if it fails an InterruptedException error is
	// caught. If is exits the try catch block without incident then it will call the withdrawFromAccount method of the 
	// shared resource and passes it the default fund Amount.
	@Override
	public void run(){
		for(int i = 0; i < funds.size(); i++) {
			
			try {
				Thread.sleep((int) ( Math.random() * 3000 ) );
			} catch(InterruptedException err) {
				System.out.println(err.getMessage());
			}
		
			accountWithdraw.withdrawFromAccount(funds.get(i).getFundAmount());
		}
	}
}