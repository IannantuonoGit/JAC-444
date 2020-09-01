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

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CarRegistryServer {

	// Creates the registration server that waits for requests from a client
	// and that will then return the new registered plate to the client.
	public CarRegistryServer() {
		try {
			// Creates a carInterface object assigned to a new CarImplementation.
			CarRegistryInterface interfaceObj = new CarRegistryImplementation();
			
			// Creates a registry obj initalized to a newly created registry instance 
			// on the specified port.
			Registry registry = LocateRegistry.createRegistry(4040);
			
			// Calls the rebind method of the registry object and replaces the binding for the specified 
			// name in the registry with the supplied remote reference.
			registry.rebind("CarPlateRegistry", interfaceObj);
			
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}
	}

	public static void main(String[] args) {
		// Creates a new instance of carServer.
		new CarRegistryServer();
		System.out.println("Car Plate Registry Service Is Running...");
	}
}