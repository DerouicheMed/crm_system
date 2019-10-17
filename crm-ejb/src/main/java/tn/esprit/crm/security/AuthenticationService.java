package tn.esprit.crm.security;

import javax.ejb.Stateless;

import tn.esprit.crm.entities.User;

@Stateless
public class AuthenticationService {
	
	public User getAuthenticated() {
		User user=new User();
		user.setId((long) 1);
		return user;
	}

}
