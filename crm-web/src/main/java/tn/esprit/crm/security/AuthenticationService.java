package tn.esprit.crm.security;

import tn.esprit.crm.entities.User;

public interface AuthenticationService {
	
	public User getAuthenticated();
	
	public User authenticate(String username, String passwd);

}
