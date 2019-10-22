package tn.esprit.crm.dao.impl;

import javax.ejb.Stateless;

import tn.esprit.crm.dao.IUserDao;
import tn.esprit.crm.entities.User;

@Stateless
public class UserDaoImpl extends GenericDaoImpl<User> implements IUserDao {

}
