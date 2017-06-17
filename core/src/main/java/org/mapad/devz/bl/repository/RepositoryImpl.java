package org.mapad.devz.bl.repository;

import java.util.List;

public abstract class RepositoryImpl<T> {
	protected abstract Class<T> getGenericType();
	
	public abstract List<T> all() throws Throwable;

	public abstract void update(T object) throws Throwable;
	
	public abstract void create(T object) throws Throwable;

	public abstract T read(Object id) throws Throwable;

	public abstract void delete(Object id) throws Throwable;
}
