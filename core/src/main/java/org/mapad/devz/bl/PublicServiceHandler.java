package org.mapad.devz.bl;

import org.mapad.devz.bl.repository.MongoRepositoryImpl;
import org.mapad.devz.bl.repository.RepositoryImpl;
import org.mapad.devz.models.PublicService;

import com.mongodb.DB;
import com.mongodb.DBCollection;

public class PublicServiceHandler {
	private RepositoryImpl<PublicService> _repositoryImpl;
	
	public PublicServiceHandler(RepositoryImpl<PublicService> repository) {
		this._repositoryImpl = repository;
	}
}
