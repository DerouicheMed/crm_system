package tn.esprit.crm.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;

import lombok.Data;

@MappedSuperclass
@Data
public class BaseEntity implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Long version;
    
   
    private LocalDateTime createdAt;
    
    
    private LocalDateTime updatedAt;
    
    /**
     * Sets createdAt before insert
     */
    
	@PrePersist
    public void setCreationDate() {
        this.createdAt = LocalDateTime.now();
    }
	
    /**
     * Sets updatedAt before update
     */
    
    @PreUpdate
    public void setChangeDate() {
        this.updatedAt = LocalDateTime.now();
    }
    
    

}
