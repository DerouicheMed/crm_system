package tn.esprit.crm.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
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
	private String companyName;
	private String companyType;
	private String firstname;
	private String lastname;
	private String cin;
	private LocalDateTime birthDate;
	private String type;
	
	@ManyToOne
	@JoinColumn(name = "fk_role")
	private Role role;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
	private List<Complaint> complaintList=new ArrayList<Complaint>();
	
	
	

}
