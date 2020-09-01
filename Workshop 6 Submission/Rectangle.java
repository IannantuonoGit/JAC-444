/***************************************************************/
/* Name: Giuliano Iannantuono                                  */
/* Completed On: 2020-07-10                                    */
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
	
	// Workshop 6 implementation.
	// Creates an rectangleArea object of type ShapeProperty which will
	// access the calculateProperty Method.
	private ShapeProperty rectangleArea;

	// Rectangle Constructor
	// Passes the given width and length to the parallelogram classes
	// constructor and makes use of its other methods.
	public Rectangle(double width, double length) throws Exception {
		super(width, length);
		// Workshop 6 implementation.
		// Calculates the area of a rectangle and then
		// returns a double containing the shapes area.
		this.rectangleArea = () -> width * length;
	}

	// toString override.
	// Prints out the given rectangle width and height, its calculated perimeter and area.
	@Override
	public String toString() {
		return getClass().getSimpleName() + " {w=" + getWidth() + ", h=" + getLength() + "} perimeter = " + (String.format("%4g",calculatePerimeter())
				+ " area = " + String.format("%4g", rectangleArea.calculateProperty()));
	}
}
