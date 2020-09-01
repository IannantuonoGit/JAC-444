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

public class Fund {

	// Class field declarations.
	private static int FUND_AMT_DEFUALT = 1;
	private String fundCurrencyType;

	// Fund Constructor.
	public Fund(String fundCurrencyType) {
		this.fundCurrencyType = fundCurrencyType;
	}

	// Setter(s).
	// Sets the fund currency type.
	public void setFundCurrencyType(String fundCurrencyType) {
		this.fundCurrencyType = fundCurrencyType;
	}
	
	// Getter(s).
	// Returns the fund amount.
	public int getFundAmount() {
		return FUND_AMT_DEFUALT;
	}
	
	// Returns the fund currency type.
	public String getFundCurrencyType() {
		return fundCurrencyType;
	}
}
