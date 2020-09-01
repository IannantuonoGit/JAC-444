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

public class Parallelogram implements Shape{
	// Variable declarations.
	private double width;
	private double length;

	// Parallelogram constructor.
	// Checks to see if the passed width and length are greater than 0
	// if they are then it initializes both of them, if not it throws an exception.
	Parallelogram(double width, double length) throws Exception{
		if(width > 0 && length > 0) {
			this.width = width;
			this.length = length;
		} else {
			throw new Exception("Invalid side(s)!");
		}
	}

	// Setter method(s).
	// Checks to see if the passed width and length are greater than 0
	// if they are then it initializes both of them, if not they throw an exception.
	public void setWidth(double width) throws Exception {
		if(width > 0) {
			this.width = width;
		} else {
			throw new Exception("Invalid width");
		}
	}

	public void setLength(double length) throws Exception {
		if(length > 0) {
			this.length = length;
		} else {
			throw new Exception("Invalid length");
		}
	}

	// Getter method(s).
	// Returns the width.
	public double getWidth() {
		return width;
	}

	// Returns the length.
	public double getLength() {
		return length;
	}

	// calculatePerimeter override.
	// Overrides the calculatePerimeter method from the shape
	// interface class to calculate the perimeter of a parallelogram.
	@Override
	public double calculatePerimeter() {
		return (2 * width) + (2 * length);
	}

	// toString override.
	// Prints out the given parallelograms width and length and its calculated perimeter.
	@Override
	public String toString() {
		return getClass().getSimpleName() + " {w=" + getWidth() + ", h=" + getLength() + "} perimeter = " + (String.format("%4g",calculatePerimeter()));
	}
}
