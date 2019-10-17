package tn.esprit.crm.entities;

import java.time.LocalDateTime;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;

@Entity
@DiscriminatorValue("Physical")
@Data
public class UserPhysical extends User {
	
	private String firstname;
	private String lastname;
	private String cin;
	private LocalDateTime birthDate;
	
	

}
