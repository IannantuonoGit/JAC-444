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

public class Triangle implements Shape {
	// Variable declarations.
	private double sideOne;
	private double sideTwo;
	private double sideThree;

	// Triangle Constructor.
	// Checks to see if each passed side length is greater than the sum of the other sides
	// if they are then it initializes each side length, if not it throws an exception.
	public Triangle(double sideOne, double sideTwo, double sideThree) throws Exception {
		if(sideOne > 0 && sideTwo > 0 && sideThree > 0 && sideOne < (sideTwo + sideThree) && sideTwo < (sideOne + sideThree) && sideThree < (sideOne + sideTwo)) {
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		} else {
			throw new Exception("Invalid side(s)!");
		}
	}

	// Setter method(s).
	// Checks to see if each passed side length is greater than 0 as well as if each side length is less then the sum of
	// the remaining two sides, if they are then they initialize each side length
	// if not they throw an exception.
	public void setSideOne(double sideOne) throws Exception {
		if(sideOne > 0 && sideOne < (sideTwo + sideThree) && sideTwo < (sideOne + sideThree) && sideThree < (sideOne + sideTwo)) {
			this.sideOne = sideOne;
		} else {
			throw new Exception("Invalid side(s)!");
		}
	}

	public void setSideTwo(double sideTwo) throws Exception {
		if(sideTwo > 0 && sideOne < (sideTwo + sideThree) && sideTwo < (sideOne + sideThree) && sideThree < (sideOne + sideTwo)) {
			this.sideTwo = sideTwo;
		} else {
			throw new Exception("Invalid side(s)!");
		}
	}

	public void setSideThree(double sideThree) throws Exception {
		if(sideThree > 0 && sideOne < (sideTwo + sideThree) && sideTwo < (sideOne + sideThree) && sideThree < (sideOne + sideTwo)) {
			this.sideThree = sideThree;
		} else {
			throw new Exception("Invalid side(s)!");
		}
	}

	// Getter method(s)
	// Returns each given side length.
	public double getSideOne() {
		return sideOne;
	}

	public double getSideTwo() {
		return sideTwo;
	}

	public double getSideThree() {
		return sideThree;
	}

	// calculatePerimeter override.
	// Overrides the calculatePerimeter method from the shape
	// interface class to calculate the perimeter of a triangle.
	@Override
	public double calculatePerimeter() {
		return sideOne + sideTwo + sideThree;
	}

	// toString method override.
	// Prints out the given triangle sides and then its calculated perimeter formatted properly.
	public String toString() {
		return getClass().getSimpleName() + " {s1=" + getSideOne() + ", s2=" + getSideTwo() + ", s3=" + getSideThree() + "} perimeter = " + (String.format("%4g",calculatePerimeter()));
	}
}
