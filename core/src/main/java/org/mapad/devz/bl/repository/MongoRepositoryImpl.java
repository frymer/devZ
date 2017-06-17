package org.mapad.devz.bl.repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoCollection;

public class MongoRepositoryImpl<T extends Identifiable> extends RepositoryImpl<T> {
	private MongoCollection<Document> _collection;
	private ObjectMapper _mapper;
	private Class<T> _type;
	
	@Override
	protected Class<T> getGenericType() {
		return _type;
	}
	
	public MongoRepositoryImpl(MongoCollection<Document> collection, Class<T> type) {
		this._collection = collection;
		this._mapper = new ObjectMapper();
		this._type = type;
	}

	private T pasrseDocumentToT(Document doc) throws JsonParseException, JsonMappingException, IOException {
		Object id = doc.get("_id");
		doc.remove("_id");
		T result = _mapper.readValue(doc.toJson(), getGenericType());
		result.setId(id);
		return result;
	}
	
	@Override
	public List<T> all() throws JsonParseException, JsonMappingException, IOException {
		List<T> results = new ArrayList<T>();
		Iterator<Document> itemsIterator = _collection.find().iterator();

		while (itemsIterator.hasNext()) {
			T object = this.pasrseDocumentToT(itemsIterator.next());

			results.add(object);
		}

		return results;
	}

	@Override
	public void update(T object) throws JsonProcessingException {
		Document documentToUpdate = Document.parse(_mapper.writeValueAsString(object));
		Document searchQuery = new Document().append("_id", object.getId());
		_collection.updateOne(searchQuery, documentToUpdate);
	}

	@Override
	public void create(T object) throws JsonProcessingException {
		Document documentToInsert = Document.parse(_mapper.writeValueAsString(object));

		_collection.insertOne(documentToInsert);
	}

	@Override
	public T read(Object id) throws JsonParseException, JsonMappingException, IOException {
		Document filter = new Document().append("_id", id);
		return (T) _mapper.readValue(_collection.find(filter).first().toString(), getGenericType());
	}

	@Override
	public void delete(Object id) {
		Document searchQuery = new Document().append("_id", id);
		_collection.deleteOne(searchQuery);
	}
}
