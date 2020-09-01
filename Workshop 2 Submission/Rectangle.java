/***************************************************************/
/* Name: Giuliano Iannantuono                                  */
/* Completed On: 2020/06/06                                    */
/*                                                             */
/* Version: FINAL                                              */
/*                                                             */
/* I confirm that the content of this file was created by me   */
/* with exception of the parts provided to me by my professor  */                         
/***************************************************************/

package shapes;

// The rectangle class extends from the parallelogram class which
// implements the shape interface class.
public class Rectangle extends Parallelogram {

	// Rectangle Constructor
	// Passes the given width and length to the parallelogram classes
	// constructor and makes use of its other methods.
	public Rectangle(double width, double length) throws Exception {
		super(width, length);
	}
}
