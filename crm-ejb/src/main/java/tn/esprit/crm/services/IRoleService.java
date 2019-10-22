package tn.esprit.crm.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.crm.entities.Role;

@Local
public interface IRoleService {
	
	public Role save(Role role);
	
	public Role update(Role role);
	
	public List<Role> selectAll();
	
	public List<Role> selectBy(String param, String value);
	
	public List<Role> selectAll(String sortField, String sort);
	
	public Role getById(Long id);
	
	public void remove(Long id);
	
	public Role findOne(String paramName, Object paramValue);
	
	public Role findOne(String[] paramNames, Object[] paramValues);

}
