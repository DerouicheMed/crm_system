package tn.esprit.crm.resources;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import tn.esprit.crm.dto.UserDto;
import tn.esprit.crm.dto.mapper.UserMapper;
import tn.esprit.crm.entities.User;
import tn.esprit.crm.security.AuthenticationService;
import tn.esprit.crm.security.RegistrationService;
import tn.esprit.crm.services.IUserService;


@Path("/user")
public class UserResource {
	
		
	@Inject
	private UserMapper userMapper;
	
	@Inject
	private AuthenticationService authService;
	
	@Inject
	private RegistrationService registerationService;
	
	@EJB
	private IUserService userService;
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	@RolesAllowed("ROLE_CLIENT")
	public List<UserDto> selectAll(){
		List<User> userList= userService.selectAll();
		List<UserDto> userDtoList=new ArrayList<UserDto>();
		userList.forEach(user->{
			userDtoList.add(userMapper.mapToDto(user));			
		});
		return userDtoList;
	}
	
	
	@GET
	@Path("/findone/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@RolesAllowed("ROLE_PROSPECT")
	public UserDto selectById(@PathParam("id") long id){		
		User user=userService.findOne("id", id);
		if(user != null)
		return userMapper.mapToDto(user);
		else return null;
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UserDto save(UserDto userDto) {
		User user=userMapper.mapFromDto(userDto);
		return userMapper.mapToDto(userService.save(user));
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UserDto update(UserDto userDto) {
		User user=userMapper.mapFromDto(userDto);
		return userMapper.mapToDto(userService.updateBasicInformation(user));
	}
	
	@DELETE
	@Path("/{id}")
	@RolesAllowed("ROLE_SUPER_ADMIN")
	public void delete( @PathParam("id")long id) {
		userService.remove(id);
	}
	
	@POST
	@Path("/authenticate")
	@Produces(MediaType.APPLICATION_JSON)
	@PermitAll
	public UserDto authenticateUser(@QueryParam("username") String username, 
            @QueryParam("passwd") String passwd) {
		User authenticatedUser = authService.authenticate(username, passwd);
		if(authenticatedUser != null) return userMapper.mapToDto(authenticatedUser);
		else return null;
		
	}
	
	@POST
	@Path("/register")
	@Produces(MediaType.APPLICATION_JSON)
	@PermitAll
	public UserDto register(UserDto userDto) {
		User user =registerationService.register(userMapper.mapFromDto(userDto));
		if(user != null) return userMapper.mapToDto(user);
		else return null;
		
	}
	
	@GET
	@Path("/get-authenticated")
	@Produces(MediaType.APPLICATION_JSON)
	public UserDto getAuthenticatedUser() {
		User authenticatedUser = authService.getAuthenticated();
		if(authenticatedUser != null) return userMapper.mapToDto(authenticatedUser);
		else return null;
		
	}
	

}
