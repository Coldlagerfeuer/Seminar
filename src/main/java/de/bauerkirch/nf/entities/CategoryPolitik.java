package de.bauerkirch.nf.entities;

import javax.persistence.Entity;

@Entity
public class CategoryPolitik extends Category {

	public String politik;
	
	public CategoryPolitik() {
		this.name = "POLITIK";
	}
	
}
