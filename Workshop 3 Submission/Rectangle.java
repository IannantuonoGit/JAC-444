/***************************************************************/
/* Name: Giuliano Iannantuono                                  */
/* Completed On: 2020/06/12                                    */
/*                                                             */
/* Version: FINAL                                              */
/*                                                             */
/* I confirm that the content of this file was created by me   */
/* with exception of the parts provided to me by my professor  */                         
/***************************************************************/

package shapes;

import exceptions.ParallelogramException;

// The rectangle class extends from the parallelogram class which
// implements the shape interface class.
public class Rectangle extends Parallelogram {

	// Rectangle Constructor
	// Passes the given width and length to the parallelogram classes
	// constructor and makes use of its other methods.
	public Rectangle(double width, double length) throws ParallelogramException {
		super(width, length);
	}
}
