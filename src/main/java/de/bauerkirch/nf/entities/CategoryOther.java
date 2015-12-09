package de.bauerkirch.nf.entities;

import javax.persistence.Entity;

@Entity
public class CategoryOther extends Category {

	public CategoryOther() {
		this.name = "OTHER";
	}
	
}
