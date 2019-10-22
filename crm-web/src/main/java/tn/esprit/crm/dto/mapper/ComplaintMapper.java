package tn.esprit.crm.dto.mapper;


import org.modelmapper.ModelMapper;

import tn.esprit.crm.dto.ComplaintDto;
import tn.esprit.crm.entities.Complaint;

public class ComplaintMapper implements CustomModelMapper<ComplaintDto,Complaint> {
	
	
	/**
	 * this method will map the model object to a dto
	 */
	@Override
	public ComplaintDto mapToDto(Complaint object) {
		ComplaintDto complaintDto=new ComplaintDto();
		ModelMapper modelMapper=new ModelMapper();
		complaintDto=modelMapper.map(object, ComplaintDto.class);
		return complaintDto;
	}
	
	/**
	 * this method will map the dto to a model object
	 */
	@Override
	public Complaint mapFromDto(ComplaintDto object) {
		Complaint complaint=new Complaint();
		ModelMapper mp=new ModelMapper();
		complaint=mp.map(object, Complaint.class);
		return complaint;
	}

	

}
