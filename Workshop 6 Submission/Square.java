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

public class Square implements Shape {
	// Variable declaration.
	private double side;

	// Workshop 6 implementation.
	// Creates an squareArea object of type ShapeProperty which will
	// access the calculateProperty Method.
	private ShapeProperty squareArea;

	// Square Constructor
	// Checks to see if the passed side length is greater than 0
	// if it is then it initializes the side length, if not it throws an exception.
	public Square(double side) throws Exception{
		if(side > 0) {
			this.side = side;
			// Workshop 6 implementation.
			// Calculates the area of a square and then
			// returns a double containing the shapes area.
			this.squareArea = () -> side * side;
		} else {
			throw new Exception("Invalid side!");
		}
	}

	// Setter method(s).
	// Checks to see if the passed side length is greater than 0
	// if it is then it initializes the side length, if not it throws an exception.
	public void setSide(double side) throws Exception {
		if(side > 0) {
			this.side = side;
		} else {
			throw new Exception("Invalid side");
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
	// Prints out the given squares side length, its calculated perimeter and area.
	@Override
	public String toString() {

		return getClass().getSimpleName() + " {s=" + getSide() + "} perimeter = " +  (String.format("%4g",calculatePerimeter())
				+ " area = " + String.format("%4g", squareArea.calculateProperty()));
	}
}
