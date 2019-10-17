package tn.esprit.crm.services.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.crm.dao.IDiscountDao;
import tn.esprit.crm.entities.Discount;
import tn.esprit.crm.services.IDiscountService;

@Stateless
public class DiscountServiceImpl implements IDiscountService {	
	
	@EJB
	private IDiscountDao discountDao;


	@Override
	public Discount add(Discount discount) {
		discount.setDescription("this is a discount");
		discountDao.save(discount);
		return null;
	}

}
