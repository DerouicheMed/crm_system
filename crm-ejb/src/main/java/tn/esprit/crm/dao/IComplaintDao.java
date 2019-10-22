package tn.esprit.crm.dao;

import javax.ejb.Local;

import tn.esprit.crm.entities.Complaint;

@Local
public interface IComplaintDao extends IGenericDao<Complaint> {

}
