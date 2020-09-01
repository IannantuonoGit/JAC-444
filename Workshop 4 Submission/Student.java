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

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable{

	// Class field declarations.
	private int stdId;
	private String firstName;
	private String lastName;
	private ArrayList<String> courses; 

	// Student default constructor
	// When called a student will be created with default values.
	public Student() {
		this.stdId = 0;
		this.firstName = "";
		this.lastName = "";
		this.courses = new ArrayList<>();
	}

	// Setter(s)
	// Checks to see if the passed stdId is larger than 0, if it passes validation it sets the stdId.
	// If is not larger than 0 then an IllegalArgumentException is thrown.
	public void setStdId(int stdId) throws IllegalArgumentException {
		if(stdId > 0) {
			this.stdId = stdId;
		} else {
			throw new IllegalArgumentException("Invalid Student Id...\n");
		}	
	}

	// Checks to see if the passed firstName is empty, if it passes validation it sets the firstName.
	// If it is empty then an IllegalArgumentException is thrown.
	public void setFirstName(String firstName) throws IllegalArgumentException  {
		if(!firstName.isEmpty()) {
			this.firstName = firstName;
		} else {
			throw new IllegalArgumentException("Please Provide The Students First Name...\n");
		}
	}

	// Checks to see if the passed lastName is empty, if it passes validation it sets the lastName.
	// If it is empty then an IllegalArgumentException is thrown.
	public void setLastName(String lastName) throws IllegalArgumentException {
		if(!lastName.isEmpty()) {
			this.lastName = lastName;
		} else {
			throw new IllegalArgumentException("Please Provide The Students Last Name...\n");
		}
	}

	// Checks to see if the passed course are empty, if they pass validation it add the courses to the arrayList.
	// If they are empty then an IllegalArgumentException is thrown.
	public void setCourses(String courses) throws IllegalArgumentException  {
		if(!courses.isEmpty()) {
			this.courses.add(courses);
		} else {
			throw new IllegalArgumentException("Please Provide A Valid Course Code...\n");
		}
	}

	// Getter(s)
	// Returns the students ID.
	public int getStdId() {
		return stdId;
	}

	// Returns the students first name.
	public String getFirstName() {
		return firstName;
	}

	// Returns the students last name.
	public String getLastName() {
		return lastName;
	}

	// Returns the courses stored inside the arrayList.
	public ArrayList<String> getCourses(){
		return courses;
	}

	// toString override.
	// Will print out the contents of a student object formatted in the way specified below.
	@Override
	public String toString() {
		return String.format("Student ID: %d\nFull Name: %s %s\nCourse List: %s\n", getStdId(), getFirstName(), getLastName(), getCourses());
	}

}
