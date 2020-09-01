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

// The Shape class acts as a functional interface for all the
// other shapes in the inheritance hierarchy.
@FunctionalInterface
public interface Shape {

	// Creates an abstract method for calculating the basic
	// perimeter of a shape which returns a double.
	double calculatePerimeter();

}