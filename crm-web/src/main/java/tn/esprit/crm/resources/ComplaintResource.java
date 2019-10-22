package tn.esprit.crm.resources;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import tn.esprit.crm.dto.ComplaintDto;
import tn.esprit.crm.dto.mapper.ComplaintMapper;
import tn.esprit.crm.entities.Complaint;
import tn.esprit.crm.security.AuthenticationService;
import tn.esprit.crm.services.IComplaintService;

@Path("/complaint")
public class ComplaintResource {
	
	@Inject
	AuthenticationService authenticationService;
	
	@Inject
	ComplaintMapper complaintMapper;
	
	@EJB
	private IComplaintService complaintService;
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	@PermitAll
	public List<ComplaintDto> selectAll(){
		List<Complaint> complaintList= complaintService.selectAll();
		List<ComplaintDto> complaintDtoList=new ArrayList<ComplaintDto>();
		complaintList.forEach(complaint->{
			complaintDtoList.add(complaintMapper.mapToDto(complaint));			
		});
		return complaintDtoList;
	}
	
	@GET
	@Path("/by-user")
	@Produces(MediaType.APPLICATION_JSON)
	@PermitAll
	public List<ComplaintDto> selectByUser(){		
		List<Complaint> complaintList= complaintService.selectBy("username",
				authenticationService.getAuthenticated().getUsername());
		List<ComplaintDto> complaintDtoList=new ArrayList<ComplaintDto>();
		complaintList.forEach(complaint->{
			complaintDtoList.add(complaintMapper.mapToDto(complaint));			
		});
		return complaintDtoList;
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@PermitAll
	public ComplaintDto selectById(@PathParam("id") long id){		
		Complaint complaint=complaintService.findOne("id", id);
		if(complaint != null)
		return complaintMapper.mapToDto(complaint);
		else return null;
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@PermitAll
	public ComplaintDto save(ComplaintDto complaintDto) {
		Complaint complaint=complaintMapper.mapFromDto(complaintDto);
		complaint.setUser(authenticationService.getAuthenticated());
		return complaintMapper.mapToDto(complaintService.save(complaint));
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@PermitAll
	public ComplaintDto update(ComplaintDto complaintDto) {
		Complaint complaint=complaintMapper.mapFromDto(complaintDto);
		return complaintMapper.mapToDto(complaintService.update(complaint));
	}
	
	@DELETE
	@Path("/{id}")
	@PermitAll
	public void delete( @PathParam("id")long id) {
		complaintService.remove(id);
	}

}
