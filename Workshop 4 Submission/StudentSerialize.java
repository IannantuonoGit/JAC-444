/***************************************************************/
/* Name: Giuliano Iannantuono                                  */
/* Completed On: 2020/06/19                                    */
/*                                                             */
/* Version: FINAL                                              */
/*                                                             */
/* I confirm that the content of this file was created by me   */
/* with exception of the parts provided to me by my professor  */                         
/***************************************************************/

package serialization;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.File;

public class StudentSerialize {

	// createStudent method
	// Takes in an empty studentList, it will then create a new empty student object
	// and will begin to prompt the user to fill in the information. It will pass the inputs to the
	// setters inside of the student class. Once all fields are completed it will push the student into the arrayList
	// and then prompt the user if they would like to enter another student. 
	private static ArrayList<Student> createStudent(ArrayList<Student> studentList) {

		// Variable declarations.
		boolean addCourse = true;
		boolean addStudent = true;
		boolean elementAdded = false;

		while(addStudent){
			try {
				// This BufferedRader will be used to allow the user to input data through the console. 
				BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

				// Calls for a new empty student object to be created.
				Student std = new Student(); 

				while(!elementAdded) {
					// If no exception is thrown the elementAdded variable is set to true
					// and will allow the user to continue adding data.
					try {
						// Prompts the user to enter the students ID which will be passed to the
						// setter located in the student class for validation and assignment.
						System.out.print("Enter Student ID: ");
						int stdId = Integer.parseInt(in.readLine());
						std.setStdId(stdId);
						elementAdded = true;
					} catch (IllegalArgumentException err) {
						System.out.println(err.getMessage());
					}
				}

				elementAdded = false;

				while(!elementAdded) {
					// If no exception is thrown the elementAdded variable is set to true
					// and will allow the user to continue adding data.
					try {
						// Prompts the user to enter the students first name which will be passed to the
						// setter located in the student class for validation and assignment.
						System.out.print("Enter Student First Name: ");
						String firstName = in.readLine();
						std.setFirstName(firstName);
						elementAdded = true;
					} catch (IllegalArgumentException err) {
						System.out.println(err.getMessage());
					}
				}

				elementAdded = false;

				while(!elementAdded) {
					// If no exception is thrown the elementAdded variable is set to true
					// and will allow the user to continue adding data.
					try {
						// Prompts the user to enter the students last name which will be passed to the
						// setter located in the student class for validation and assignment.
						System.out.print("Enter Student Last Name: ");
						String lastName = in.readLine();
						std.setLastName(lastName);
						elementAdded = true;
					} catch (IllegalArgumentException err) {
						System.out.println(err.getMessage());
					}
				}

				elementAdded = false;

				System.out.println();
				System.out.print("Enter Student Courses <Enter 0 to finish>: ");
				System.out.println();
				while(!elementAdded) {
					// If no exception is thrown the elementAdded variable is set to true
					// and will allow the user to continue adding data.
					try {
						// Prompts the user to enter the students courses which will be passed to the
						// setter located in the student class for validation and assignment.
						do {
							addCourse = true;
							System.out.print("Enter Course: ");

							String course = in.readLine();

							// If the user enters a "0" then it will break out of the do while loop 
							// which allows the user to select if they want to enter another student.
							if(course.equals("0")) {
								addCourse = false;
							} else {
								std.setCourses(course);
								elementAdded = true;
							}

						} while(addCourse);
						
					} catch (IllegalArgumentException err) {
						System.out.println(err.getMessage());
					}
				}

				elementAdded = false;

				System.out.println();
				System.out.print("Enter Another Student <Enter to continue OR 0 to finish>: ");
				String slection = in.readLine();
				System.out.println();

				// If the user enters a "0" then it will break out of the while loop
				// finishing off the crateStudent method and returns the filled arrayList.
				// If the user simply presses enter then it will restart the process of adding 
				// new student.
				if(slection.equals("0")) {
					addStudent = false;
				}

				studentList.add(std);

			} catch(Throwable err) {
				System.out.println(err.getMessage());
			}
		}

		// return the studentList.
		return studentList;
	}

	// writeStudent method
	// Takes in the studentList arrayList, creates a file and writes each student object
	// stored in arrayList to that file, it will then print out the name of the file.
	private static void writeStudent(ArrayList<Student> studentList) {
		try {
			// Creates a new empty file called studentList.out.
			File fileOut = new File("studentList.out");
			
			// Opens a new file output stream to the newly created studentList.out file.
			FileOutputStream fos = new FileOutputStream("studentList.out");
			
			// Opens a new object output stream to the newly created file output stream.
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			// Sends the whole studentList arrayList to the object output stream.
			oos.writeObject(studentList);
			oos.flush();
			
			// Closes the file output stream.
			fos.close();

			// Success message that inform the user that the file was written too.
			System.out.println("Student list saved into file " + fileOut.getName());
		}catch(Throwable err) {
			System.out.println(err.getMessage());
		}
	}

	public static void main(String[] args) {
		System.out.println("------->JAC 444 Assignment 4<-------");
		System.out.println("-------> Serialize <-------");

		// Initializes a new empty arrayList to hold the created students.
		ArrayList<Student> studentList = new  ArrayList<>();

		createStudent(studentList);
		writeStudent(studentList);

	}
}
