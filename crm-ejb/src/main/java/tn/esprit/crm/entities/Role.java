package tn.esprit.crm.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Data;



@Entity
@Data
public class Role extends BaseEntity {
	
	private String roleName;
	
	@OneToMany(orphanRemoval=false,mappedBy = "role")
	private List<User> userList = new ArrayList<>();

}
