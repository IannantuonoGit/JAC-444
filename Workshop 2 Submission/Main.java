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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	// getMaxArrSize method
	private static int getMaxArrSize() {

		// Variable declarations.
		int maxArrSize = 0;

		// Runs through the passed file entirely, keeping track the amount of lines located within
		// if the passed file cannot be located it will throw an exception.
		try (BufferedReader br = new BufferedReader(new FileReader("shapes.txt"))) {
			while((br.readLine()) != null) {
				maxArrSize++;
			}

		} catch (IOException err) {
			System.out.println(err.getMessage());
		}
		// Returns the total amount of lines which will be used to initialize the shapesArr.
		return maxArrSize;

	}

	// createShapes method
	private static int createShapes(Shape[] shapesArr) {

		// Variable declarations.
		int arrSize = 0;
		String currentLine;

		// Reads the file line by line, splitting each of them using the "," as a delimiter and stores the results in the tokens array
		// if the passed file cannot be located it will throw an exception.
		try (BufferedReader br = new BufferedReader(new FileReader("shapes.txt"))) {

			while ((currentLine = br.readLine()) != null) {
				try {
					// Array that holds the split up tokens
					String[] tokens = currentLine.split(",");

					// Runs each line through a switch case that will determine what shape should be created and if there are enough
					// passed variables to be used, if no case is selected it throws an exception.
					switch(tokens[0]) {
					case "Circle":
						if(tokens.length == 2) {
							shapesArr[arrSize] = new Circle(Double.parseDouble(tokens[1]));
							arrSize++;
						}
						break;
					case "Square":
						if(tokens.length == 2) {
							shapesArr[arrSize] = new Square(Double.parseDouble(tokens[1]));
							arrSize++;
						}
						break;
					case "Rectangle":
						if(tokens.length == 3) {
							shapesArr[arrSize] = new Rectangle(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
							arrSize++;
						}
						break;
					case "Parallelogram":
						if(tokens.length == 3) {
							shapesArr[arrSize] = new Parallelogram(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
							arrSize++;
						}
						break;
					case "Triangle":
						if(tokens.length == 4) {
							shapesArr[arrSize] = new Triangle(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
							arrSize++;
						}
						break;
					}
				} catch (Exception err) {
					System.out.println(err.getMessage());
				}
			}
		} catch (IOException err) {
			System.out.println(err.getMessage());
		}
		// Returns the arrSize variable which holds the number of valid shapes created.
		return arrSize;
	}

	// printShapesArr method.
	private static void printShapesArr(Shape shapesArr[], int arrSize) {

		// Prints out the content stored inside of the shapesArr for the length of arrSize
		// as well as the total amount of shapes that were created.
		System.out.println();
		System.out.println(arrSize + " shapes were created:");
		for (int i = 0; i < arrSize; i++) {
			System.out.println(shapesArr[i]);
			System.out.println();
		}
	}

	public static void main(String[] args) {

		// Task 1: Read the file Shapes.txt, create the shapes and store them in
		// your data structure. Then print the number of shapes you created,
		// and finally, print all the shapes and their calculated perimeters polymorphically.
		System.out.println("------->JAC 444 Assignment 2 & 3<-------");
		System.out.println("------->>........Task 1.........<-------");

		// Initializes the shape array to the total size of the inputed file.
		Shape[] shapesArr = new Shape[getMaxArrSize()];

		// Prints out all created shapes stored inside of the shapsArr.
		printShapesArr(shapesArr, createShapes(shapesArr));
	}
}