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

import tn.esprit.crm.dto.RoleDto;
import tn.esprit.crm.dto.mapper.RoleMapper;
import tn.esprit.crm.entities.Role;
import tn.esprit.crm.services.IRoleService;

@Path("/role")
public class RoleResource {
	
	@Inject
	RoleMapper roleMapper;
	
	@EJB
	IRoleService roleService;
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	@PermitAll
	public List<RoleDto> selectAll(){
		List<Role> roleList= roleService.selectAll();
		List<RoleDto> roleDtoList=new ArrayList<RoleDto>();
		roleList.forEach(role->{
			roleDtoList.add(roleMapper.mapToDto(role));			
		});
		return roleDtoList;
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public RoleDto selectById(@PathParam("id") long id){		
		Role role=roleService.findOne("id", id);
		if(role != null)
		return roleMapper.mapToDto(role);
		else return null;
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@PermitAll
	public RoleDto save(RoleDto roleDto) {
		return roleMapper.mapToDto(roleService.save(roleMapper.mapFromDto(roleDto)));
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@PermitAll
	public RoleDto update(RoleDto roleDto) {
		return roleMapper.mapToDto(roleService.update(roleMapper.mapFromDto(roleDto)));
	}
	
	@DELETE
	@Path("/{id}")
	@PermitAll
	public void delete( @PathParam("id")long id) {
		roleService.remove(id);
	}

}
