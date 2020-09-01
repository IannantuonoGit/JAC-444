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

import java.lang.Math;

import exceptions.CircleException;

public class Circle implements Shape {
	// Variable declarations.
	private double radius;

	// Circle constructor.
	// Checks to see if the passed radius is greater than 0
	// if it is then it initializes the radius, if not it throws a custom circle exception.
	public Circle(double radius) throws CircleException {
		if(radius > 0) {
			this.radius = radius;
		} else {
			throw new CircleException("Invalid radius!");
		}
	}

	// Setter method(s).
	// Checks to see if the passed radius is greater than 0
	// if it is then initializes the radius if not throws a custom circle exception.
	public void setRadius(double radius) throws CircleException {
		if(radius > 0) {
			this.radius = radius;
		} else {
			throw new CircleException("Invalid radius!");
		}
	}

	// Getter method(s).
	// Returns the radius.
	public double getRadius() {
		return radius;
	}

	// calculatePerimeter override.
	// Overrides the calculatePerimeter method from the shape
	// interface class to calculate the perimeter of a circle.
	@Override
	public double calculatePerimeter() {
		return 2 * Math.PI * radius;
	}

	// toString override.
	// Prints out the given circles radius and its calculated perimeter.
	@Override
	public String toString() {
		return getClass().getSimpleName() + " {r=" + getRadius() + "} perimeter = " + (String.format("%4g",calculatePerimeter()));
	}
}
