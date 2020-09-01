/***************************************************************/
/* Name: Giuliano Iannantuono                                  */
/* Completed On: 2020-07-20                                    */
/*                                                             */
/* Version: FINAL                                              */
/*                                                             */
/* I confirm that the content of this file was created by me   */
/* with exception of the parts provided to me by my professor  */                         
/***************************************************************/

package functional;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class StudentProcess {
	// Creates an array of type Student populated with fictional student data 
	// consisting of a first name, last name, a grade and a department.
	public static Student[] students = {
			new Student("Jack", "Smith", 50.0, "IT"),
			new Student("Aaron", "Johnson", 76.0, "IT"),
			new Student("Maaria", "White", 35.8, "Business"),
			new Student("John", "White", 47.0, "Media"),
			new Student("Laney", "White", 62.0, "IT"),
			new Student("Jack", "Jones", 32.9, "Business"),
			new Student("Wesley", "Jones", 42.89, "Media")
	};

	public static void main(String[] args) {

		System.out.println("------->JAC 444 Assignment 7<-------");

		// WORKSHOP 7: TASK 1
		// Creates a list out of the students array, then iterates through the list
		// printing all of its elements. 
		System.out.println("-------------->Task 1<--------------\n");
		System.out.println("Complete Student list:");

		List<Student> studentList = Arrays.asList(students);
		studentList.forEach(System.out::println);

		// WORKSHOP 7: TASK 2
		// Displays students with grades in the range of 50.0-100.0 which are sorted 
		// into ascending order by grade.
		System.out.println("\n-------------->Task 2<--------------\n");
		System.out.println("Students who got 50.0-100.0 sorted by grade:");

		Predicate<Student> gradeRange = student -> student.getGrade() >= 50 && student.getGrade() <=100;
		Comparator<Student> grade = Comparator.comparing(Student::getGrade);

		// Opens a stream out of studentList, filters the stream using the predicate gradeRange. 
		// Then sorts the filtered stream using the comparator grade and finally prints out each
		// element within the stream terminating the stream at completion.
		studentList.stream().filter(gradeRange).sorted(grade).forEach(System.out::println);

		// WORKSHOP 7: TASK 3
		// Display the first student in the collection with grade in the range of 50.0-100.0.
		System.out.println("\n-------------->Task 3<--------------\n");
		System.out.println("First Student who got 50.0-100.0:");

		// Opens a stream out of studentList, filters the stream using the predicate gradeRange.
		// Then using the findFirst method which returns an optional describing the first element in the
		// stream it will print out that elements value if it is present using the ifPresent method. 
		// Once complete it terminate the stream.
		studentList.stream().filter(gradeRange).findFirst().ifPresent(System.out::println);

		// WORKSHOP 7: TASK 4
		// Sort the Students (a)by their last names, and then their first names in ascending and
		// (b)by their last names, and then their first names in descending orders and display the students
		// after each of these two processes.
		System.out.println("\n-------------->Task 4<--------------\n");
		System.out.println("Students in ascending order by last name then first:");

		Comparator<Student> lastThenFirst = Comparator.comparing(Student::getLastName).thenComparing(Student::getFirstName);

		// Opens a stream out of studentList, then sorts the stream using the comparator 
		// lastThenFirst then it will print out each element within the newly sorted
		// stream terminating the stream at completion.
		studentList.stream().sorted(lastThenFirst).forEach(System.out::println);

		System.out.println("\nStudents in descending order by last name then first:");

		// Opens a stream out of studentList, then sorts the stream using the comparator 
		// lastThenFirst in a reverse order then it will print out each element within 
		// the newly sorted stream terminating the stream at completion.
		studentList.stream().sorted(lastThenFirst.reversed()).forEach(System.out::println);

		// WORKSHOP 7: TASK 5
		// Display unique Student last names, sorted.
		System.out.println("\n-------------->Task 5<--------------\n");
		System.out.println("Unique Student last names:");

		// Opens a stream out of studentList, then maps the stream based on the students last names
		// sorts it in ascending order then using the distinct method it will go through the stream
		// and preserve the first encounter of a last name ignoring duplicates. Then it will print
		// out each element in the stream terminating the stream at completion.
		studentList.stream().map(Student::getLastName).distinct().sorted().forEach(System.out::println);	
	}
}