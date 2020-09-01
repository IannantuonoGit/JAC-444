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

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class VisualStudentDeserialize extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

	// Initializes a new empty arrayList to hold the student contents from the file.
	ArrayList<Student> students = new ArrayList<>();

	// Class field declarations.
	private JTextField fileInput;
	private JTextArea studentDisplay;
	private JPanel errMessage;
	private File fileIn; 

	// VisualStudentSerialize constructor
	// In charge of setting up the main panel used in the JFrame, which includes a establishing a JTextfield, 
	// JButton, JLabel, and JTextArea as well as setting the name of the GUI window.
	VisualStudentDeserialize(String title) {

		// Passes the title to the superclass's constructor setting the name
		// of the GUI window.
		super(title);

		// Creates a JPanel that holds the JTextField, JTextArea and JButton. 
		JPanel mainPanel = new JPanel();

		// Creates a JLabel for the JTextField displaying "File Name".
		JLabel fileName = new JLabel("File name:");

		// Adds it to the mainPanel.
		mainPanel.add(fileName);

		// Creates a JTextField for the user to enter the name of a file they
		// wish to read from.
		fileInput = new JTextField(20);

		// Adds it to the mainPanel.
		mainPanel.add(fileInput);

		// Creates a JButton which will start the deserialization process once pressed
		// by the user.
		JButton strButton = new JButton("Start");
		strButton.setBackground(Color.green);
		strButton.addActionListener(this);

		// Adds it to the mainPanel.
		mainPanel.add(strButton);

		// Creates a JTextArea which will hold the contents read from the users file.
		// It also has the functionality to include a scroll bar if the contents of the file
		// are to much for the JTextAre to hold.
		studentDisplay = new JTextArea(20, 40);

		// setEditable is set to false to ensure that the user cannot manipulate the information read from the file.
		studentDisplay.setEditable(false);

		// Adds it to the mainPanel.
		mainPanel.add(new JScrollPane(studentDisplay, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
		mainPanel.setBackground(Color.lightGray);

		// Adds the mainPanel to the mainFrame.
		this.add(mainPanel);
	}

	// ActionPerformed method
	// When the start button is pressed by the user this method is called allowing for the
	// serialized file to be deserialized, read, and its content displayed in the GUI window.
	@Override
	public void actionPerformed(ActionEvent event) {
		// Will set the text field to an empty state so information duplication not occur.
		studentDisplay.setText(null);

		try {
			// Checks to see if the passed filename is valid, if not a FileNotFoundException
			// will be thrown to the the user.
			if(!fileInput.getText().isEmpty()) {
				fileIn = new File(fileInput.getText());
			} else {
				throw new FileNotFoundException("Please Provide A File Name...\n");
			}

			// Opens a new file input stream that takes the file passed by the user.
			FileInputStream fis = new FileInputStream(fileIn);

			// Opens a new object input stream that takes in the file input stream.
			ObjectInputStream ois = new ObjectInputStream(fis);

			// Reads the serialized arrayList located within the file and casts it to an arrayList of type student
			// and then stores it into the students arrayList.
			students = (ArrayList<Student>) ois.readObject();

			// Closes the object and file input streams. 
			ois.close();
			fis.close();

			// Loops through the students arrayList and displays each student
			// within the JTextArea of the GUI window.
			for(int i = 0; i < students.size(); i++) {
				studentDisplay.append(students.get(i).toString());
			}

		} catch(Throwable err) {
			// Will display a window containing the error message of the caught exception.
			JOptionPane.showMessageDialog(errMessage, err.getMessage(), "Workshop 5 : Deserialize Student(s)Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	// Main method
	// Handles the creation of the JFrame which includes setting its closingOperations 
	// the final size of the GUI window and its resize ability.
	public static void main(String[] args) {
		VisualStudentDeserialize mainFrame = new VisualStudentDeserialize("Workshop 5 : Deserialize Student(s)");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(460, 400);

		// setResizeable is set to false to ensure that users cannot manipulate the window size.
		mainFrame.setResizable(false);

		mainFrame.setVisible(true);
	}
}