package org.mapad.devz.bl;

import java.util.HashMap;
import java.util.Map;

import org.bson.Document;
import org.mapad.devz.bl.repository.Identifiable;
import org.mapad.devz.bl.repository.MongoRepositoryImpl;
import org.mapad.devz.bl.repository.RepositoryImpl;

import com.mongodb.DBCollection;
import com.mongodb.client.MongoCollection;

public class RepositoryImplHanlder<T extends Identifiable> extends Configurable {
	private static Map<String, PersistenceHandler> _handlers;
	private Class<T> _type;
	
	static {
		_handlers = new HashMap<String, PersistenceHandler>();
		_handlers.put("mongodb", new MongoHandler());
	}
	
	private Class<T> getGenericType() {
		return this._type;
	}
	
	public RepositoryImpl<T> getRepository() {
		String persistence = this.getConf().getString("server.persistence");
		RepositoryImpl<T> result;
		
		switch (persistence) {
		case "mongodb":
			String collectionName = this.getConf().getString("db.collections." + this.getGenericType().getSimpleName());
			
			MongoCollection<Document> collection = ((MongoHandler)_handlers.get(persistence)).getDB().getCollection(collectionName);
			
			result = new MongoRepositoryImpl<T>(collection, this.getGenericType());
			
			break;

		default:
			result = null;
			
			break;
		}
		
		return result;
	}
	
	public RepositoryImplHanlder(Class<T> type) {
		this._type = type;
	}
}
