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

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CarRegistryImplementation extends UnicastRemoteObject implements CarRegistryInterface {

	// CarImplementation constructor.
	public CarRegistryImplementation() throws RemoteException {
		super();
	}
	
	// registerCar method.
	// This method when called will take in a car object, then it will call the
	// set plate method on the car object and pass it a hashCode of the entrie object as a 
	// string wihch will act as the plate number for that car, once this is complete it returns
	// the updated car object.
	@Override
	public Car registerCar(Car car) throws RemoteException {
		car.setPlate(car.hashCode() + "");
		return car;
	}
}