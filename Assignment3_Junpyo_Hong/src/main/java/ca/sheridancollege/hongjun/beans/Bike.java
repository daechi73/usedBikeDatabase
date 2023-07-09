package ca.sheridancollege.hongjun.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Bike class holds all the properties needed to make the Bike object.
 * @author Jp
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bike {

	private int bikeID;
	private int manufacturerID;
	private String bikeModel;
	private int year;
	private String colour;
	private double price;
	
	
}
