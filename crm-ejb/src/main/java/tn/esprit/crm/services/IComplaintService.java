package tn.esprit.crm.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.crm.entities.Complaint;

@Local
public interface IComplaintService {
	
public Complaint save(Complaint complaint);
	
	public Complaint update(Complaint complaint);
	
	public List<Complaint> selectAll();
	
	public List<Complaint> selectBy(String param, String value);
	
	public List<Complaint> selectAll(String sortField, String sort);
	
	public Complaint getById(Long id);
	
	public void remove(Long id);
	
	public Complaint findOne(String paramName, Object paramValue);
	
	public Complaint findOne(String[] paramNames, Object[] paramValues);

}
