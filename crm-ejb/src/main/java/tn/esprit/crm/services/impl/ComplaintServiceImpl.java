package tn.esprit.crm.services.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import tn.esprit.crm.dao.IComplaintDao;
import tn.esprit.crm.entities.Complaint;
import tn.esprit.crm.services.IComplaintService;

@Stateless
public class ComplaintServiceImpl implements IComplaintService {
	
	@EJB
	private IComplaintDao complaintDao;

	@Override
	public Complaint save(Complaint complaint) {
		return complaintDao.save(complaint);
	}

	@Override
	public Complaint update(Complaint complaint) {
		Complaint persistedComplaint=complaintDao.findOne("id", complaint.getId());
		persistedComplaint.setText(complaint.getText());
		persistedComplaint.setState(complaint.getState());
		persistedComplaint.setType(complaint.getType());
		return complaintDao.update(persistedComplaint);
	}

	@Override
	public List<Complaint> selectAll() {
		return complaintDao.selectAll();
	}

	@Override
	public List<Complaint> selectBy(String param, String value) {
		return complaintDao.selectBy(param, value);
	}

	@Override
	public List<Complaint> selectAll(String sortField, String sort) {
		return complaintDao.selectAll(sortField, sort);
	}

	@Override
	public Complaint getById(Long id) {
		return complaintDao.getById(id);
	}

	@Override
	public void remove(Long id) {
		complaintDao.remove(id);
		
	}

	@Override
	public Complaint findOne(String paramName, Object paramValue) {
		return complaintDao.findOne(paramName, paramValue);
	}

	@Override
	public Complaint findOne(String[] paramNames, Object[] paramValues) {
		return complaintDao.findOne(paramNames, paramValues);	
	}

}
