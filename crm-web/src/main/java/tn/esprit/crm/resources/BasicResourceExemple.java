package tn.esprit.crm.resources;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import tn.esprit.crm.entities.Discount;
import tn.esprit.crm.services.impl.DiscountServiceImpl;

@Path("/exemple")
public class BasicResourceExemple {
	
	@EJB
	DiscountServiceImpl discountService;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getTestMessage() {
		discountService.Add(new Discount());
		return "";
	}

}
