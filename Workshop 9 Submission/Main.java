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

public class Main {

	public static void main(String[] args) {

		System.out.println("------->JAC 444 Assignment 9<-------");

		// Declares a new empty arrayList of type fund to hold all transaction information
		// including the currency type and its amount. 
		ArrayList<Fund> fundList = new ArrayList<>();

		// Creates six objects of type fund. One Dollar, two Euro's, and three Pound's.  
		fundList.add(new Fund("Dollar(s)"));
		fundList.add(new Fund("Euro(s)"));
		fundList.add(new Fund("Euro(s)"));
		fundList.add(new Fund("Pound(s)"));
		fundList.add(new Fund("Pound(s)"));
		fundList.add(new Fund("Pound(s)"));

		// Creates a new sharedAccount object called jointAccount which will allow for
		// each thread to act upon the shared balance resource.
		SharedAccount jointAccount = new SharedAccount();

		// Declares the depositThread and constructs it passing the jointAccount object and the fund list.
		AccountDeposit depositThread = new AccountDeposit(jointAccount, fundList);
		// Declares the withdrawThread and constructs it passing the jointAccount object and the fund list.
		AccountWithdraw withdrawThread = new AccountWithdraw(jointAccount, fundList);

		// Starts both the depositThread and the withdrawThread.
		depositThread.start();
		withdrawThread.start();
	}
}