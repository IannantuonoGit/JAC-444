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

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CarRegistryInterface extends Remote {
	// refisterCar interface method.
	Car registerCar(Car car) throws RemoteException;
}
