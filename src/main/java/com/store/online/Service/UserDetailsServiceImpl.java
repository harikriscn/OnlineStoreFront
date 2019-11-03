/**
 * 
 */
package com.store.online.Service;

import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.store.online.POJO.User;

/**
 * @author Harikrishnan
 *
 */
public class UserDetailsServiceImpl implements UserDetailsService{

@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
	User user = findUserbyUername(username);
	UserBuilder builder = null;
    if (user != null) {
      builder = org.springframework.security.core.userdetails.User.withUsername(username);
      builder.password(new BCryptPasswordEncoder().encode(user.getPassword()));
      builder.roles(user.getRoles());
    } else {
      throw new UsernameNotFoundException("User not found.");
    }

    return builder.build();
  }

  private User findUserbyUername(String username) {
    if(username.equalsIgnoreCase("admin")) {
      return new User(username, "admin123", "ADMIN");
    }
    return null;
  }
}
