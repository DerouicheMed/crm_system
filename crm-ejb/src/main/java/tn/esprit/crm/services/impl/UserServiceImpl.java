package tn.esprit.crm.services.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import tn.esprit.crm.dao.IUserDao;
import tn.esprit.crm.entities.User;
import tn.esprit.crm.security.AuthenticationService;
import tn.esprit.crm.services.IUserService;

@Stateless
public class UserServiceImpl implements IUserService {
	
	@EJB
	private IUserDao userDao;
	
	@EJB
	private AuthenticationService authenticationService;

	@Override
	public User testAuthenticatedUser() {
		return authenticationService.getAuthenticated();
		
	}

	@Override
	public User save(User user) {
		return userDao.save(user);
	}

	@Override
	public User update(User user) {
		return userDao.update(user);
	}

	@Override
	public List<User> selectAll() {
		return userDao.selectAll();
	}

	@Override
	public List<User> selectBy(String param, String value) {
		return userDao.selectBy(param, value);
	}

	@Override
	public List<User> selectAll(String sortField, String sort) {
		return userDao.selectAll(sortField, sort);
	}

	@Override
	public User getById(Long id) {
		return userDao.getById(id);
	}

	@Override
	public void remove(Long id) {
		userDao.remove(id);
		
	}

	@Override
	public User findOne(String paramName, Object paramValue) {
		return userDao.findOne(paramName, paramValue);
	}

	@Override
	public User findOne(String[] paramNames, Object[] paramValues) {
		return userDao.findOne(paramNames, paramValues);
	}
	
	

}
