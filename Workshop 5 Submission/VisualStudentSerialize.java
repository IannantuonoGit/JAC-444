/***************************************************************/
/* Name: Giuliano Iannantuono                                  */
/* Completed On: 2020-07-03                                    */
/*                                                             */
/* Version: FINAL                                              */
/*                                                             */
/* I confirm that the content of this file was created by me   */
/* with exception of the parts provided to me by my professor  */                         
/***************************************************************/

package serialization;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.List;

public class VisualStudentSerialize extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	// Initializes a new empty arrayList to hold the created students.
	ArrayList<Student> studentList = new  ArrayList<>();

	// Class field declarations.
	private JTextField idText;
	private JTextField firstNameText;
	private JTextField lastNameText;
	private JTextField courseText;
	private static JLabel message;
	private List courseList;
	private static JPanel errMessage;

	// VisualStudentSerialize constructor
	// In charge of setting up the main panel used in the JFrame, which includes a establishing JTextfields, 
	// JButtons, JLabels, and a List as well as setting the name of the GUI window.
	VisualStudentSerialize(String title){

		// Passes the title to the superclass's constructor setting the name
		// of the GUI window.
		super(title);

		// Creates a JPanel that holds the JTextFields, JLabels, JButtons, and a List. 
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(null);

		// Creates a JLabel for the JTextField displaying "Student ID".
		JLabel idLable = new JLabel("Student ID");
		idLable.setBounds(10, 20, 80, 20);
		
		// Adds it to the mainPanel.
		mainPanel.add(idLable);

		// Creates a JTextField for the user to enter the students ID.
		idText= new JTextField(20);
		idText.setBounds(100, 20, 160, 20);
		
		// Adds it to the mainPanel.
		mainPanel.add(idText);

		// Creates a JLabel for the JTextField displaying "First Name".
		JLabel firstNameLable = new JLabel("First Name");
		firstNameLable.setBounds(10, 60, 80, 20);
		
		// Adds it to the mainPanel.
		mainPanel.add(firstNameLable);

		// Creates a JTextField for the user to enter the students first name.
		firstNameText = new JTextField(20);
		firstNameText.setBounds(100, 60, 160, 20);
		
		// Adds it to the mainPanel.
		mainPanel.add(firstNameText);

		// Creates a JLabel for the JTextField displaying "Last Name".
		JLabel lastNameLable = new JLabel("Last Name");
		lastNameLable.setBounds(10, 100, 80, 20);
		
		// Adds it to the mainPanel.
		mainPanel.add(lastNameLable);

		// Creates a JTextField for the user to enter the students last name.
		lastNameText = new JTextField(20);
		lastNameText.setBounds(100, 100, 160, 20);
		
		// Adds it to the mainPanel.
		mainPanel.add(lastNameText);

		// Creates a JLabel for the JTextField displaying "Course Code".
		JLabel courseLable = new JLabel("Course Code");
		courseLable.setBounds(10, 140, 80, 20);
		
		// Adds it to the mainPanel.
		mainPanel.add(courseLable);

		// Creates a JTextField for the user to enter the students courses.
		courseText = new JTextField(20);
		courseText.setBounds(100, 140, 160, 20);
		
		// Adds it to the mainPanel.
		mainPanel.add(courseText);

		// Creates and initializes an empty list to hold the students course.
		courseList = new List();

		// Creates a JButton which allows the user to submit the inputed student information.
		JButton addButton = new JButton("Add");
		addButton.setBounds(275, 140, 90, 20);
		addButton.setBackground(Color.green);

		// This actionListener contains a lambda function which
		// validates if an actual course code was provided by the user
		// and not just an empty string.
		addButton.addActionListener(e->{
			// If the validation passes the data passed by the user is added to the courseList
			// and the text input field is set back to an empty state.
			if(!courseText.getText().isEmpty()) {
				courseList.add(courseText.getText());
				courseText.setText("");
			}
		});
		
		// Adds it to the mainPanel.
		mainPanel.add(addButton);

		// Creates a JLabel and sets the List component to hold the
		// inputed student courses and displays them in the window.
		JLabel displayLable = new JLabel("Course List");
		displayLable.setBounds(10, 170, 80, 20);
		
		// Adds it to the mainPanel.
		mainPanel.add(displayLable);

		courseList.setBounds(10, 190, 355, 110);
		
		// Adds it to the mainPanel.
		mainPanel.add(courseList);

		// Creates a JButton for submitting the users inputed information which will be used
		// for creation of the student.
		JButton subButton = new JButton("Add Student");
		subButton.setBounds(10, 310, 130, 20);
		subButton.setBackground(Color.green);
		subButton.addActionListener(this);
		
		// Adds it to the mainPanel.
		mainPanel.add(subButton);

		// Creates a JButton for removing any courses from within the the displayed course list.
		JButton rmvButton = new JButton("Remove Course");
		rmvButton.setBounds(230, 310, 135, 20);
		rmvButton.setBackground(Color.red);

		// This actionListener contains a lambda function which
		// which will remove a selected entry from the courseList
		// using the selected index returned when a user clicks on a course.
		rmvButton.addActionListener(e->{
			try {
				int index = courseList.getSelectedIndex();
				courseList.remove(index);
			} catch (Throwable err) {
				// Will display a window containing the error message of the caught exception.
				JOptionPane.showMessageDialog(errMessage,"No Selected Course Found", "Workshop 5 : Serialize Student(s) Error", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		// Adds it to the mainPanel.
		mainPanel.add(rmvButton);

		// Creates a JButton for saving the array list of student objects to the created file.
		JButton saveButton = new JButton("Save");
		saveButton.setBounds(10, 340, 90, 20);
		saveButton.setBackground(Color.green);

		// This actionListener contains a lambda function which calls the
		// writeStudent method and passes it the studentList containing the all student objects
		saveButton.addActionListener(e->{
			writeStudent(studentList);
		});
		
		// Adds it to the mainPanel.
		mainPanel.add(saveButton);

		// Creates a JLabel to display the message confirming that the studentList
		// has been written to the specified file.
		message = new JLabel();
		message.setBounds(110, 340, 250, 20);
		
		// Adds it to the mainPanel.
		mainPanel.add(message);

		mainPanel.setBackground(Color.lightGray);

		// Adds the mainPanel to the mainFrame.
		this.add(mainPanel);
	}

	// ActionPerformed method
	// When the submit button is pressed by the user this method is called allowing for a new
	// student object to be created and filled with the users data.
	@Override
	public void actionPerformed(ActionEvent e) {

		// Calls for a new empty student object to be created.
		Student std = new Student(); 

		try {
			// Sends the data passed by the user to the setStdId setter method located 
			// in the student class for validation and assignment.
			int stdId = Integer.parseInt(idText.getText());
			std.setStdId(stdId);

			// Sends the data passed by the user to the setFristName setter method located 
			// in the student class for validation and assignment.
			String firstName = firstNameText.getText();
			std.setFirstName(firstName);

			// Sends the data passed by the user to the setLastName setter method located 
			// in the student class for validation and assignment.
			String lastName = lastNameText.getText();
			std.setLastName(lastName);

			// Sends the contents of the list to an array of strings.
			String courses[] = courseList.getItems();

			// Loops through the new courses array and sends each item to the setCourse setter method
			// located in the student class for validation and assignment.
			for(String oneCourse : courses) {
				std.setCourses(oneCourse);

			}
			
			// Adds the newly created student to the studentList.
			studentList.add(std);

			// Calls the clear method which sets all input fields to a safe empty state.
			clear();
			
		} catch (Throwable err) {
			// Will display a window containing the error message of the caught exception.
			JOptionPane.showMessageDialog(errMessage, err.getMessage(), "Workshop 5 : Serialize Student(s) Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	// writeStudent method
	// Takes in the studentList arrayList, creates a file and writes each student object
	// stored in the arrayList to that file.
	private static void writeStudent(ArrayList<Student> studentList) {
		try {
			// Creates a new empty file called studentList.out.
			File fileOut = new File("studentList.out");

			// Opens a new file output stream to the newly created studentList.out file.
			FileOutputStream fos = new FileOutputStream(fileOut);

			// Opens a new object output stream to the newly created file output stream.
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			// Sends the whole studentList arrayList to the object output stream.
			oos.writeObject(studentList);
			oos.flush();

			// Closes the file output stream.
			fos.close();

			// Sets the message label in the mainPanel to the below message.
			message.setText("Student list saved into file " + fileOut.getName());

		}catch(Throwable err) {
			// Will display a window containing the error message of the caught exception.
			JOptionPane.showMessageDialog(errMessage, err.getMessage(), "Workshop 5 : Serialize Student(s) Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	// Clear method
	// When this method is called upon it will clear all input fields of data
	// and sets them to an empty state allowing for a clean forum to be used for another student.
	public void clear() {
		idText.setText("");
		firstNameText.setText("");
		lastNameText.setText("");
		courseText.setText("");
		courseList.removeAll();
	}

	// Main method
	// Handles the creation of the JFrame which includes setting its closingOperations 
	// the final size of the GUI window and its resize ability.
	public static void main(String[] args) {
		VisualStudentSerialize mainFrame = new VisualStudentSerialize("Workshop 5 : Serialize Student(s)"); 
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(380, 420);
		
		// setResizeable is set to false to ensure that users cannot manipulate the window size.
		mainFrame.setResizable(false);

		mainFrame.setVisible(true);
	}
}