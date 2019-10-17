package tn.esprit.crm.services;

import javax.ejb.Local;

import tn.esprit.crm.entities.Discount;

@Local
public interface IDiscountService {
	
	public Discount add (Discount discount);

}
