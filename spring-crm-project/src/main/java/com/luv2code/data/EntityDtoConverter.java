package com.luv2code.data;

public interface EntityDtoConverter<E, D> {
	public E toEntity(D customer);
	public E toEntityWithoutId(D customer);
	public D toDto(E entity);
	public E copyFields(E entity, D customer);
}
