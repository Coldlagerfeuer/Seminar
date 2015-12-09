package de.bauerkirch.nf.entities;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class CategoryMark extends Category {

	public String markText;
	
	public Date expiration;
	
	public CategoryMark() {
		this.name = "MARK";
	}
	
}
