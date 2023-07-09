package ca.sheridancollege.hongjun.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ca.sheridancollege.hongjun.database.DatabaseAccess;

/**
 * UserDetailsServiceImpl grabs the user details in the database searching
 * by username and it converts this info to create a User object.
 * @author Jp
 *
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private DatabaseAccess da;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		ca.sheridancollege.hongjun.beans.User user = da.findUserAccount(username);

		if (user == null) {
			System.out.println("User not found:" + username);
			throw new UsernameNotFoundException("User " + username 
					+ "	was not found in the database");
		}
		List<String> roleNames = da.getRolesById(user.getUserId());
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		if(roleNames != null) {
			for (String role : roleNames) {
				grantList.add(new SimpleGrantedAuthority(role));
			}
		}
		UserDetails userDetails = (UserDetails) new User(user.getEmail(), 
				user.getEncryptedPassword(),  grantList);
		return userDetails;
	}
	


}
