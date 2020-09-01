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

// The ShapesArea class acts as a functional interface for the
// shapes in the inheritance hierarchy.
@FunctionalInterface
public interface ShapeProperty {
	
	// Creates an abstract method for calculating the basic
	// area of a shape which returns a double.
	double calculateProperty();
}
