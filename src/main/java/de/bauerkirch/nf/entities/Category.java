package de.bauerkirch.nf.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Entity
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "name")
@JsonSubTypes({
                  @JsonSubTypes.Type(value = CategoryPolitik.class, name = "POLITIK"),
                  @JsonSubTypes.Type(value = CategoryMark.class, name = "MARK"),
                  @JsonSubTypes.Type(value = CategoryOther.class, name = "OTHER")
              })
public abstract class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long categoryId;
	
	
	protected String name;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return categoryId;
	}

	public void setId(long categoryId) {
		this.categoryId = categoryId;
	}
	
}
