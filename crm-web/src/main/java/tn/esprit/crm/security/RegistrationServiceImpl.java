package tn.esprit.crm.security;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import tn.esprit.crm.entities.User;
import tn.esprit.crm.services.IRoleService;
import tn.esprit.crm.services.IUserService;

public class RegistrationServiceImpl implements RegistrationService {
	
	@Inject
	HttpServletRequest request;
	
	@EJB
	IUserService userService;
	
	@EJB
	IRoleService roleService;

	@Override
	public User register(User user) {
		if(userService.findOne("username", user.getUsername()) ==null) {
			user.setRole(roleService.findOne("roleName", "ROLE_PROSPECT"));
			user= userService.save(user);
			return user;
		}
		else return null;
	}

}
