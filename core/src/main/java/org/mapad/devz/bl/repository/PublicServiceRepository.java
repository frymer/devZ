package org.mapad.devz.bl.repository;

import java.util.List;

import org.mapad.devz.models.PublicService;

public class PublicServiceRepository extends RepositoryObject implements Repository<PublicService> {
	
	public PublicServiceRepository(RepositoryImpl<PublicService> implementation) {
		super(implementation);
	}
	
	public List<PublicService> all() throws Throwable {
		return _repository.all();
	}

	public void update(PublicService object) throws Throwable {
		_repository.update(object);	
	}

	public void create(PublicService object) throws Throwable {
		_repository.create(object);
	}

	public PublicService read(Object id) throws Throwable {
		return (PublicService) _repository.read(id);
	}

	public void delete(Object id) throws Throwable {
		_repository.delete(id);	
	}
}
