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

import java.io.Serializable;

public class Car implements Serializable {

	// Class field declarations.
	private String model;
	private String colour;
	private int mileage;
	private String plate;

	// Car constructor.
	public Car(String model, String colour, int mileage) {
		this.model = model;
		this.colour = colour;
		this.mileage = mileage;
		this.plate = "Not Registerd";
	}

	// Getter(s).
	// Returns the cars model.
	public String getModel() {
			return model;
	}

	// Returns the cars colour.
	public String getColour() {
		return colour;
	}

	// Returns the cars mileage.
	public int getMileage() {
		return mileage;
	}

	// Returns the cars generated plate number.
	public String getPlate() {
		return plate;
	}

	// Setter(s).
	// Sets the cars model.
	public void setModel(String model) {
		this.model = model;
	}

	// Sets the cars colour.
	public void setColour(String colour) {
		this.colour = colour;
	}

	// Sets the cars mileage.
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	// Sets the cars generated plate number.
	public void setPlate(String plate) {
		this.plate = plate;
	}

	// toString Override.
	// Prints out the cars model, colour, mileage and the generated plate number formatted in the way specified below.
	@Override
	public String toString() {
		return String.format("Model: %s \nColour: %s \nMileage: %d \nPlate: %s", getModel(), getColour(), getMileage(), getPlate());
	}
}