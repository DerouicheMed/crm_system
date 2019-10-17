package tn.esprit.crm.entities;

import java.time.LocalDateTime;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn
@Data
public class User extends BaseEntity {
	
	private String username;
	private String password;
	private String email;
	private String phoneNumPrimary;
	private String phoneNumAlternative;
	private String address;
	private LocalDateTime lastLoggedAt;
	private boolean activated;
	
	@ManyToOne
	@JoinColumn(name = "fk_role")
	private Role role;
	
	
	

}
