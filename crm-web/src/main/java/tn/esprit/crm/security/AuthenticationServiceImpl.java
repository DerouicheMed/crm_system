package tn.esprit.crm.security;

import java.util.Base64;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;

import tn.esprit.crm.entities.User;
import tn.esprit.crm.services.IUserService;

public class AuthenticationServiceImpl implements AuthenticationService {
	
	@Inject
	HttpServletRequest request;
	
	@EJB
	IUserService userService;
	
	
	/**
	 * This method gets the username from the session and triesto identify it
	 */
	@Override
	public User getAuthenticated() {
		
		String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
		String decodedString=new String(Base64.getDecoder().decode(authHeader));
		String[] attributes = decodedString.split(":");
		String username = attributes[0];
		String passwd = attributes[1];
		return this.authenticate(username, passwd);
		
	}
	
	/**
	 * This method gets a username and a password.
	 * It tries  to find a user with the corresponding username
	 * if user exist it checks if the password is correct and the user account
	 * is activated to created a user session
	 */
	@Override
	public User authenticate(String username, String passwd) {
		User user=userService.findOne("username", username);
		if(user != null) {
			if(user.getPassword().equals(passwd) && user.isActivated()==true){
				return user;
			}
			else return null;
		}
		else return null;
	}

}
