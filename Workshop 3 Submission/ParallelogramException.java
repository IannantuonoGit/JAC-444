/***************************************************************/
/* Name: Giuliano Iannantuono                                  */
/* Completed On: 2020/06/12                                    */
/*                                                             */
/* Version: FINAL                                              */
/*                                                             */
/* I confirm that the content of this file was created by me   */
/* with exception of the parts provided to me by my professor  */                         
/***************************************************************/

package exceptions;

//This exception class handles exceptions for the parallelogram class.
public class ParallelogramException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ParallelogramException(String errMessage) {
		super(errMessage);
	}
}
