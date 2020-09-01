/***************************************************************/
/* Name: Giuliano Iannantuono                                  */
/* Completed On: 2020-08-10                                    */
/*                                                             */
/* Version: FINAL                                              */
/*                                                             */
/* I confirm that the content of this file was created by me   */
/* with exception of the parts provided to me by my professor  */                         
/***************************************************************/

package rmi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;

public class CarRegistryClient {

	public static void main(String[] args) {

		System.out.println("------->JAC 444 Assignment 10<-------\n");

		// Creates an empty arrayList of type car.
		ArrayList<Car> carList = new ArrayList<>();

		// Creates cars with diffrent sets of mock data to be sent to the plate registry service.
		carList.add(new Car("Mazda 3", "White", 250));
		carList.add(new Car("Fiat 500", "Red", 2000));
		carList.add(new Car("Ford Focus", "Blue", 50000));
		carList.add(new Car("Tesla Model X", "Silver", 0));
		carList.add(new Car("Ferrari 812 GTS", "Yellow", 0));

		// Loops through the entire carList passing each entry to the plate registry service.
		for(int i = 0; i < carList.size(); i++) {
			try {
				
				// Prints the car object before the plate registration.
				System.out.println(carList.get(i).toString());

				// Creates an object of type CarInterface and itinializes it to a reference
				// to the CarPlateRegistry service down casted to type CarInterface.  
				CarRegistryInterface registrar = (CarRegistryInterface) Naming.lookup("rmi://localhost:4040/CarPlateRegistry");
				
				// Sets the current element in the carList to that of the car that is returned by the registerCar
				// method of the registrar which is passed the current element in the array.
				carList.set(i, registrar.registerCar(carList.get(i)));

				// Prints out the newly generated plate number.
				System.out.printf("\nNew Plate Number %s\n\n", carList.get(i).getPlate());

				// Prints out the car object after with the registered plate.
				System.out.println(carList.get(i).toString());
				
				System.out.println("-------------------------");

			} catch(MalformedURLException e) {
				System.out.println("MalformedURLException");
				System.out.println(e);
			} catch(RemoteException e) {
				System.out.println("RemoteException");
				System.out.println(e);
			} catch(NotBoundException e) {
				System.out.println("NotBoundException");
				System.out.println(e);
			} catch(ArithmeticException e) {
				System.out.println("ArithmeticException");
				System.out.println(e);
			}
		}
	}
}
