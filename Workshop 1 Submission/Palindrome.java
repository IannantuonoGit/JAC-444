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

public class Palindrome {

	private static boolean checkIfPalindrome(char str[]) {
		// Variable declaration and initialization.
		int strLength = str.length;
		int midOfString = strLength / 2;
		int index;

		// Allocates new memory to the stack array to half the size of the passed string.
		Stack newStackArr = new Stack(strLength / 2);

		// Loops through the passed string pushing each character into the stack array 
		// until it hits the middle character.  
		for (index = 0; index < midOfString; index++) {
			newStackArr.push(str[index]);
		}

		// Checks if the remainder of the string length is not equal to 0,
		// if that is true then it increments the index to the next character
		// to ignore the the middle character.
		if (strLength % 2 !=0) {
			index++;
		}

		// This loops through the string and pops each character form the stack array 
		// and assigns it to the element variable.
		while (index < strLength) {
			char element = newStackArr.pop();
			// Evaluates if the popped element is not the same as the passed strings character,
			// if it is true then false is returned signaling that it is not a palindrome.
			if(element != str[index]) {
				return false;	
			}
			index++;
		}
		
		// Default return true.
		return true;
	}

	public static void main(String[] args) {
		// Error checking: This code ensures that a string is provided within the command line arguments,
		// if a string is not provided the system exits with status code 1. 
		if (args.length < 1) {
			System.err.println("You must provide a string");
			System.exit(1);
		}

		// Takes the provided command line string and converts it into a character array,
		// also casts each character to uppercase to ensure each character is evaluated correctly. 
		// To account for multi-word palindromes it removes any white spaces within the passed string.
		char[] inputStr = args[0].toUpperCase().replaceAll(" ", "").toCharArray();

		// If the "checkIfPalindrome" function returns true then the entered string is a palindrome,
		// if it returns false then it is not a palindrome.
		if (checkIfPalindrome(inputStr)) {	
			System.out.print("The entered string " + "\"" + args[0] + "\" IS" + " a palindrome!" + "\n");	
		} else {
			System.out.print("The entered string " + "\"" + args[0] + "\" is" + " NOT a palindrome!" + "\n");
		}	
	}
}