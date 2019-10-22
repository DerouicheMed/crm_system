package tn.esprit.crm.dto.mapper;

public interface CustomModelMapper<E,O> {
	
	public E mapToDto( O object);
	public O mapFromDto( E object);
	

}
