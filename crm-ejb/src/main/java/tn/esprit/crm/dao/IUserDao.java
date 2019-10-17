package tn.esprit.crm.dao;

import javax.ejb.Local;

import tn.esprit.crm.entities.User;

@Local
public interface IUserDao extends IGenericDao<User> {

}
