package tn.esprit.crm.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Complaint extends BaseEntity{
	
	private String text;
	private String state;
	private String type;
	
	@ManyToOne
	@JoinColumn(name = "fk_user")
	public User user;

}
