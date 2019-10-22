package tn.esprit.crm.dto.mapper;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class CustomModelMapperImpl<E,O> implements CustomModelMapper<E, O> {
	
private Class<E> type;
	
	public Class<E> getType() {
		return type;
	}

	public CustomModelMapperImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class<E>) pt.getActualTypeArguments()[0];
	}

	@Override
	public E mapToDto(O object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public O mapFromDto(E object) {
		// TODO Auto-generated method stub
		return null;
	}

}
