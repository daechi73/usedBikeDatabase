package ca.sheridancollege.hongjun.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * The Manufacturer class holds all the properties needed to make a manufacturer object
 * @author Jp
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Manufacturer {
	
	private int manufacturerID;
	private String manufacturer;

}
