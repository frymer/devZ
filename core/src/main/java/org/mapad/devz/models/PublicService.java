package org.mapad.devz.models;

import java.util.List;
import java.util.Map;

import org.mapad.devz.bl.repository.Identifiable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import io.swagger.models.Swagger;

@JsonIgnoreProperties("_id")
public class PublicService implements Identifiable {
	@JsonIgnore
	private Object _id;
	@JsonProperty("publicBranch")
	private String _publicBranch;
	@JsonProperty("publicSystem")
	private String _publicSystem;
	@JsonProperty("hashTags")
	private List<String> _hashTags;
	@JsonProperty("versions")
	private Map<String, Swagger> _versions;
	
	public String getPublicBranch() {
		return _publicBranch;
	}
	public void setPublicBranch(String publicBranch) {
		this._publicBranch = publicBranch;
	}
	public String getPublicSystem() {
		return _publicSystem;
	}
	public void setPublicSystem(String publicSystem) {
		this._publicSystem = publicSystem;
	}
	public List<String> getHashTags() {
		return _hashTags;
	}
	public void setHashTags(List<String> hashTags) {
		this._hashTags = hashTags;
	}
	
	public Map<String, Swagger> getVersions() {
		return _versions;
	}
	
	public void setVersions(Map<String, Swagger> versions) {
		this._versions = versions;
	}
	
	@Override
	@JsonIgnore
	public Object getId() {
		return this._id;
	}
	
	@Override
	@JsonIgnore
	public void setId(Object id) {
		this._id = id;
	}
}
