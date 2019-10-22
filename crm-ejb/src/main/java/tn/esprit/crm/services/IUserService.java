package tn.esprit.crm.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.crm.entities.User;

@Local
public interface IUserService {
	
    public User save(User user);
	
	public User updateBasicInformation(User user);
	
	public List<User> selectAll();
	
	public List<User> selectBy(String param, String value);
	
	public List<User> selectAll(String sortField, String sort);
	
	public User getById(Long id);
	
	public void remove(Long id);
	
	public User findOne(String paramName, Object paramValue);
	
	public User findOne(String[] paramNames, Object[] paramValues);

}
