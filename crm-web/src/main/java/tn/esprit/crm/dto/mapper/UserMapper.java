package tn.esprit.crm.dto.mapper;

import org.modelmapper.ModelMapper;

import tn.esprit.crm.dto.UserDto;
import tn.esprit.crm.entities.User;

public class UserMapper implements CustomModelMapper<UserDto, User> {

	/**
	 * this method will map the model object to a dto
	 */
	@Override
	public UserDto mapToDto(User object) {
		UserDto userDto=new UserDto();
		ModelMapper modelMapper=new ModelMapper();
		userDto=modelMapper.map(object, UserDto.class);
		return userDto;
	}
	
	/**
	 * this method will map the dto to a model object
	 */
	@Override
	public User mapFromDto(UserDto object) {
		User user=new User();
		ModelMapper mp=new ModelMapper();
		user=mp.map(object, User.class);
		return user;
	}

}
