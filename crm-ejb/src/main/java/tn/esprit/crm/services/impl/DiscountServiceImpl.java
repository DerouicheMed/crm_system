package tn.esprit.crm.services.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.crm.entities.Discount;

@Stateless
public class DiscountServiceImpl {
	
	@PersistenceContext(unitName="unit") 
	EntityManager em;
	
	
	public Discount Add(Discount d) {
		System.out.println("this works");;
		return new Discount();
	}

}
