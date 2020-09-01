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

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class StudentDeserialize{

	// readStudents method
	// Will take in an empty arrayList, read the serialized arrayList located in the studentList.out file
	// deserialize the whole arrayList and stores its contents into the students arrayList.
	// It will then print out each student located in the arrayList in the format specified in the Student class.
	private static void readStudents(ArrayList<Student> students) {
		try {
			// Opens a new file input stream that takes the studentList.out file.
			FileInputStream fis = new FileInputStream("studentList.out");
			// Opens a new object input stream that takes in the file input stream.
			ObjectInputStream ois = new ObjectInputStream(fis);

			// Reads the object located within the studentList.out casts it to arrayList of type student
			// and stores it into the students arrayList.
			students = (ArrayList<Student>) ois.readObject();

			// Closes the object and file input streams. 
			ois.close();
			fis.close();

			// Goes through the new students arrayList and prints out each student located within
			for (Student oneStudent : students) {
				System.out.println(oneStudent);
			}

		} catch(Throwable err) {
			System.out.println(err.getMessage());
		}
	}

	public static void main(String[] args) {
		System.out.println("------->JAC 444 Assignment 4<-------");
		System.out.println("-------> Deserialize <-------");
		System.out.println();

		// Initializes a new empty arrayList to hold the created students.
		ArrayList<Student> students = new ArrayList<>();

		readStudents(students);
	}
}