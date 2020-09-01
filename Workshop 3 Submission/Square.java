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

import exceptions.SquareException;

public class Square implements Shape {
	// Variable declaration.
	private double side;

	// Square Constructor
	// Checks to see if the passed side length is greater than 0
	// if it is then it initializes the side length, if not it throws a custom square exception.
	public Square(double side) throws SquareException {
		if(side > 0) {
			this.side = side;
		} else {
			throw new SquareException("Invalid side!");
		}
	}

	// Setter method(s).
	// Checks to see if the passed side length is greater than 0
	// if it is then it initializes the side length, if not it throws a custom square exception.
	public void setSide(double side) throws SquareException {
		if(side > 0) {
			this.side = side;
		} else {
			throw new SquareException("Invalid side");
		}
	}

	// Getter method(s).
	// Returns the side length.
	public double getSide() {
		return side;
	}

	// calculatePerimeter override.
	// Overrides the calculatePerimeter method from the shape
	// interface class to calculate the perimeter of a square.
	@Override
	public double calculatePerimeter() {
		return 4 * side;
	}

	// toString method override.
	// Prints out the given squares side length and its calculated perimeter formatted properly.
	@Override
	public String toString() {

		return getClass().getSimpleName() + " {s=" + getSide() + "} perimeter = " +  (String.format("%4g",calculatePerimeter()));
	}
}
