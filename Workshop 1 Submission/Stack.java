/***************************************************************/
/* Name: Giuliano Iannantuono                                  */
/* Completed On: 2020/05/29                                    */
/*                                                             */
/* Version: Final                                              */
/*                                                             */
/* I confirm that the content of this file was created by me   */
/* with exception of the parts provided to me by my professor  */                         
/***************************************************************/

package week1.code;

public class Stack {
	// Variable Declaration.
	private char[] stackArr;
	private int topOfStack;

	// Stack Constructor
	// Sets the stackArr size to that of the incoming length
	// (Half of the total length of the inputed string).
	public Stack (int length) {
		topOfStack = -1;
		stackArr = new char[length];
	}

	// Push method
	// First checks to see if the stackArr is completely full, if not
	// takes in the separate characters from the inputed string and
	// pushes them into the stackArr.
	public void push(char element) {
		if(!isStackFull()) {
			stackArr[++topOfStack] = element;
		} else {
			System.out.println("The stack is full");
		}
	}

	// Pop method
	// First checks to see if the stackArr is completely empty, if not
	// returns the top element from the stackArr and then removes it
	// from the stackArr.
	public char pop() {
		char poppedChar = 0;
		if(!isStackEmpty()) {
			poppedChar = stackArr[topOfStack--];
		} else {
			System.out.println("The stack is empty");
		}
		return poppedChar;
	}

	// isStackFull method
	// Returns true if the stackArr is completely full
	// false otherwise
	private boolean isStackFull() {
		return topOfStack == stackArr.length - 1;
	}

	// isStackEmpty method
	// Returns true if the stackArr is completely empty
	// false otherwise
	private boolean isStackEmpty() {
		return topOfStack == -1;
	}
}