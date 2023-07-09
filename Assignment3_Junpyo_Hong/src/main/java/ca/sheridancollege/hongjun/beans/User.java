package ca.sheridancollege.hongjun.beans;

import java.io.Serializable;

/**
 * The User class holds all the properties needed to make a user object
 */

import lombok.*;
@Data
@NoArgsConstructor	
@AllArgsConstructor

public class User implements Serializable {

	private Long userId;
	@NonNull
	private String email;
	@NonNull
	private String encryptedPassword;
	@NonNull
	private Boolean enabled;
	
}
