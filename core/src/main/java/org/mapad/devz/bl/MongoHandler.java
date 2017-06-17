package org.mapad.devz.bl;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

public class MongoHandler extends Configurable implements PersistenceHandler {
	private MongoClient _client;
	private MongoDatabase _db;
	
	private MongoClient getClient() {
		if (this._client == null) {
			List<ServerAddress> servers = new ArrayList<ServerAddress>();
			@SuppressWarnings("unchecked")
			List<String> hosts = (List<String>) this.getConf().getAnyRefList("db.hosts");
			@SuppressWarnings("unchecked")
			List<Integer> ports = (List<Integer>) this.getConf().getAnyRefList("db.ports");
			
			for (int i = 0; i < hosts.size(); i++) {
				ServerAddress sa = new ServerAddress(hosts.get(i), ports.get(i));
				servers.add(sa);
			}
			
			this._client = new  MongoClient(servers);
		}
		
		return this._client;
	}
	
	public MongoDatabase getDB() {
		if (this._db == null) {
			_db = this.getClient().getDatabase(this.getConf().getString("db.name"));
		}
		
		return _db;
	}
}
