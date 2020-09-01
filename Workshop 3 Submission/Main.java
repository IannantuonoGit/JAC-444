/***************************************************************/
/* Name: Giuliano Iannantuono                                  */
/* Completed On: 2020/06/12                                    */
/*                                                             */
/* Version: FINAL                                              */
/*                                                             */
/* I confirm that the content of this file was created by me   */
/* with exception of the parts provided to me by my professor  */                         
/***************************************************************/

package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import shapes.Circle;
import shapes.Parallelogram;
import shapes.Rectangle;
import shapes.Shape;
import shapes.Square;
import shapes.Triangle;

public class Main {
	// getMaxArrSize method
	private static int getMaxArrSize() {

		// Variable declarations.
		int maxArrSize = 0;

		// Runs through the passed file entirely, keeping track the amount of lines located within
		// if the passed file cannot be located it will throw an exception and exit with status code 1.
		try (BufferedReader br = new BufferedReader(new FileReader("shapes.txt"))) {
			while((br.readLine()) != null) {
				maxArrSize++;
			}

		} catch (IOException err) {
			System.out.println("<----------FILE NOT FOUND---------->");
			System.out.println(err.getMessage());
			System.exit(1);
		}
		// Returns the total amount of lines which will be used to initialize the shapesArr.
		return maxArrSize;

	}
	
	// Initializes the shape array to the total size of the inputed file.
		private static Shape[] shapesArr = new Shape[getMaxArrSize()];

	// createShapes method
	private static int createShapes() {

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
	private static void printShapesArr(int arrSize) {

		// Prints out the content stored inside of the shapesArr for the length of arrSize
		// as well as the total amount of shapes that were created.
		System.out.println();
		System.out.println(arrSize + " shapes were created:");
		for (int i = 0; i < arrSize; i++) {
			System.out.println(shapesArr[i]);
			System.out.println();
		}
	}


	// getSmallesTrianglePerimeter method 
	// Takes in the arrSize variable looping through the shapeArrays elements
	// if an element that contains the triangle keyword is found it will compare the calculated perimeter against the 
	// smallest triangle variable until the smallest perimeter is found.
	private static double getSmallestTrianglePerimeter(int arrSize){
		// Variable declarations.
		double smallestTriangle = 0; 
		boolean foundSmallest = false;
		int index = 0;

		// Will iterate through the shapesArr until the first instance of a triangle is found
		while(!foundSmallest || index < arrSize) {
			if(shapesArr[index].getClass().getSimpleName().contentEquals("Triangle")) {
				// It will then set the smallestTriangle variable to that elements calculated perimeter
				// and the foundSmallest boolean to true.
				smallestTriangle = shapesArr[index].calculatePerimeter();
				foundSmallest = true;
			} 
			index++;
		}
		
		// Will iterate through the shapesArr until it hits the arrSize
		for(int i = 0; i < arrSize; i++) {
			if(shapesArr[i].getClass().getSimpleName().contentEquals("Triangle")) {
				// Compares the calculated perimeter to the smallestTriangle variable.
				if(shapesArr[i].calculatePerimeter() < smallestTriangle) {
					smallestTriangle = shapesArr[i].calculatePerimeter();
				}
			}
		}
		return smallestTriangle;
	}

	// getLargestCirclePerimeter method 
	// Takes in the arrSize variable looping through the shapeArr's elements
	// if an element that contains the circle keyword is found it will compare the calculated perimeter against the 
	// largest circle variable until the largest perimeter is found.
	private static double getLargestCirclePerimeter(int arrSize) {
		// Variable declarations.
		double largestCircle = 0;

		for(int i = 0; i < arrSize; i++) {
			if(shapesArr[i].getClass().getSimpleName().contentEquals("Circle")) {
				// Compares the calculated perimeter to the largestCircle variable.
				if(shapesArr[i].calculatePerimeter() > largestCircle) {
					largestCircle = shapesArr[i].calculatePerimeter();
				}
			}
		}
		return largestCircle;
	}

	// removeShapes method
	// Takes in the arrSize as well as the smallestPerimeter and largestPerimeter
	// it will then loop though the shapeArr looking for the circle and triangle keywords
	// if one is found then it will compare the calculated perimeter against one of the two passed perimeters
	// if they are equal it will null the element essentially removing it from the array.
	private static void removeShapes(int arrSize, double smallPerimeter, double largePerimeter) {
		for(int i = 0; i < arrSize; i++) {
			if (shapesArr[i].getClass().getSimpleName().contentEquals("Triangle")) {
				// Checks to see if the calculated perimeter of element at index i is 
				// equal to the smallest perimeter found in the array.
				if (shapesArr[i].calculatePerimeter() == smallPerimeter) {
					shapesArr[i] = null;
				}
			} else if (shapesArr[i].getClass().getSimpleName().contentEquals("Circle")) {
				// Checks to see if the calculated perimeter of element at index i is 
				// equal to the largest perimeter found in the array.
				if (shapesArr[i].calculatePerimeter() == largePerimeter) {
					shapesArr[i] = null;
				}
			}
		}
	}

	// printNewShapesArr method
	// Takes in the arrSize and prints out the elements located within
	// however it ignores any element that is nullified.
	private static void printNewShapesArr(int arrSize) {

		// Prints out the content stored inside of the shapesArr for the length of arrSize
		for (int i = 0; i < arrSize; i++) {
			if(shapesArr[i] != null) {
				System.out.println(shapesArr[i]);
				System.out.println();
			}
		}
	}

	// getTotalParallelogramPerimeter method
	// Takes in the arrSize, it loops through the array and then calculates every Parallelogram perimeter
	// adding it to the total stored in the  totalParallelogramPerimeter variable.
	private static double getTotalParallelogramPerimeter(int arrSize) {
		// Variable declaration.
		double totalParallelogramPerimeter = 0;

		for(int i = 0; i < arrSize; i++) {
			if(shapesArr[i] != null) {
				// Checks to see if the array element contains the parallelogram keyword.
				if(shapesArr[i].getClass().getSimpleName().contentEquals("Parallelogram")) {
					totalParallelogramPerimeter += shapesArr[i].calculatePerimeter();
				}
			}
		}

		return totalParallelogramPerimeter;
	}

	// getTotalTrianglePerimeter method
	// Takes in the arrSize, it loops through the array and then calculates every triangle perimeter
	// adding it to the total stored in the getTotalTrianglePerimeter variable.
	private static double getTotalTrianglePerimeter(int arrSize) {
		// Variable declaration.
		double totalTrianglePerimeter = 0;

		for(int i = 0; i < arrSize; i++) {
			if(shapesArr[i] != null) {
				// Checks to see if the array element contains the triangle keyword.
				if(shapesArr[i].getClass().getSimpleName().contentEquals("Triangle")) {
					totalTrianglePerimeter += shapesArr[i].calculatePerimeter();
				}
			}
		}

		return totalTrianglePerimeter;
	}

	// printTotals method
	// Takes in the parallelogram and triangle's total perimeter's and prints them to the screen.
	private static void printTotals(double totalParallelogramPerimeter, double totalTrianglePerimeter) {
		System.out.println("Total perimeter of Parallelogram is: " + totalParallelogramPerimeter);
		System.out.println("Total perimeter of Triangle is: " + totalTrianglePerimeter);
	}

	public static void main(String[] args) {

		// Task 1: Read the file Shapes.txt, create the shapes and store them in
		// your data structure. Then print the number of shapes you created,
		// and finally, print all the shapes and their calculated perimeter's polymorphically.
		System.out.println("------->JAC 444 Assignment 2 & 3<-------");
		System.out.println("------->>........Task 1.........<-------");

		// Set the function call of createShapes() to the arrSize variable.
		int arrSize = createShapes();

		// Prints out all created shapes stored inside of the shapsArr.
		printShapesArr(arrSize);

		// Task 2: Delete the triangle with the minimum perimeter (there could be more than one
		// minimum) and the circle with the maximum perimeter (there could be more than one maximum)
		// from the shapes. Print the all the remaining shapes and their perimeter's polymorphically. For the
		// sample input file, sample output could be:
		System.out.println("------->>........Task 2.........<-------");

		double smallestPerimeter = getSmallestTrianglePerimeter(arrSize);
		double largestPerimeter = getLargestCirclePerimeter(arrSize);

		removeShapes(arrSize, smallestPerimeter, largestPerimeter);

		printNewShapesArr(arrSize);

		// Task 3: Calculate and print the total perimeter of all parallelograms
		// and the total perimeter of all triangles (Following the changes in task 2).
		System.out.println("------->>........Task 3.........<-------");

		printTotals(getTotalParallelogramPerimeter(arrSize), getTotalTrianglePerimeter(arrSize));

	}
}