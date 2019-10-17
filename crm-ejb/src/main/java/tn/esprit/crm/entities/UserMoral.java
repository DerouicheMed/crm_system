package tn.esprit.crm.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;

@Entity
@DiscriminatorValue("Moral")
@Data
public class UserMoral extends User {
	
	private String companyName;
	private String companyType;

}
