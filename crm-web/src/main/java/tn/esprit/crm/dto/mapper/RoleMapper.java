package tn.esprit.crm.dto.mapper;

import org.modelmapper.ModelMapper;

import tn.esprit.crm.dto.RoleDto;
import tn.esprit.crm.entities.Role;

public class RoleMapper implements CustomModelMapper<RoleDto, Role> {

	/**
	 * this method will map the model object to a dto
	 */
	@Override
	public RoleDto mapToDto(Role object) {
		RoleDto roleDto=new RoleDto();
		ModelMapper modelMapper=new ModelMapper();
		roleDto=modelMapper.map(object, RoleDto.class);
		return roleDto;
	}
	
	/**
	 * this method will map the dto to a model object
	 */
	@Override
	public Role mapFromDto(RoleDto object) {
		Role role=new Role();
		ModelMapper mp=new ModelMapper();
		role=mp.map(object, Role.class);
		return role;
	}

}
