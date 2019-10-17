package tn.esprit.crm.resources;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import tn.esprit.crm.entities.Discount;
import tn.esprit.crm.services.IDiscountService;
import tn.esprit.crm.services.IUserService;
import tn.esprit.crm.services.impl.DiscountServiceImpl;

@Path("/exemple")
public class BasicResourceExemple {
	
	@EJB
	IDiscountService discountService;
	
	@EJB
	IUserService userService;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getTestMessage() {
		discountService.add(new Discount());
		return "";
	}
	
	@GET
	@Path("/get-user")
	@Produces(MediaType.TEXT_PLAIN)
	public String getUser() {
		return userService.testAuthenticatedUser().toString();
	}
	

}
