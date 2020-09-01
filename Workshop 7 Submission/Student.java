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

public class Student {

	// Class field declarations.
	private String firstName;
	private String lastName;
	private double grade;
	private String department;

	// Student constructor.
	public Student(String firstName, String lastName, double grade, String department) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.grade = grade;
		this.department = department;
	}

	// Setter(s)
	// Sets the students first name.
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	// Sets the students last name.
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	// Sets the students grade.
	public void setGrade(double grade) {
		this.grade = grade; 
	}

	// Sets the students department.
	public void setDepartment(String department) {
		this.department = department;
	}

	// Getter(s)
	// Returns the students first name.
	public String getFirstName() {
		return this.firstName;
	}

	// Returns the students last name.
	public String getLastName() {
		return this.lastName;
	}

	// Returns the students grade.
	public double getGrade() {
		return this.grade;
	}

	// Returns the students department.
	public String getDepartment() {
		return this.department;
	}

	// getName Method
	// returns the students full name.
	public String getName() {
		return this.firstName + "\t" + this.lastName;
	}

	// toString Override
	// Will print out the students full name, their grade formatted to two decimal places
	// then followed by their department all separated by a tab. 
	@Override
	public String toString() {
		return getName() + "\t" +  String.format("%.2f", getGrade()) + "\t" + getDepartment();
	}

	// equals Override
	// Checks whether the current object and the object passed have same data and if they are of the
	// same class type if so then true is returned, false is returned otherwise. 
	@Override
	public boolean equals(Object obj) {
		// Checks to see if the current object is equal to the object passed
		// if so returns true essentially skipping further validation. 
		if (this == obj) {
			return true;
		}
		// Checks to see if the object passed is equal to null
		// if so it returns false indicating that the two objects are not equal.
		if (obj == null) {
			return false;
		}
		// Checks to see if the class of the object passed is not the same the current class
		// if it is not the same it returns false indicating they are not equal.
		if (getClass() != obj.getClass()) {
			return false;
		}
		// Creates a object of type student and assigns the casted object passed to the method
		// allowing it to check the relative fields within.
		Student other = (Student) obj;

		// First checks to see if the department of the current object is null, if it is it will
		// then check to see if the department located within the object passed is not null, if it is then it
		// returns false. If the current objects department is not null then it will check to see if the two objects
		// department fields are equal, if they they are it moves on for further validation if not returns false.
		if (department == null) {
			if (other.department != null) {
				return false;
			}	
		} else if (!department.equals(other.department)) {
			return false;
		}

		// First checks to see if the firstName of the current object is null, if it is it will
		// then check to see if the firstName located within the object passed is not null, if it is then it
		// returns false. If the current objects firstName is not null then it will check to see if the two objects
		// firstName fields are equal, if they they are it moves on for further validation if not returns false.
		if (firstName == null) {
			if (other.firstName != null) {
				return false;
			}
		} else if (!firstName.equals(other.firstName)) {
			return false;
		}

		// First checks to see if the lastName of the current object is null, if it is it will
		// then check to see if the lastName located within the object passed is not null, if it is then it
		// returns false. If the current objects lastName is not null then it will check to see if the two objects
		// lastName fields are equal, if they they are validation is complete and true is returned if not returns false.
		if (lastName == null) {
			if (other.lastName != null) {
				return false;
			}	
		} else if (!lastName.equals(other.lastName)) {
			return false;
		}

		return true;
	}
}