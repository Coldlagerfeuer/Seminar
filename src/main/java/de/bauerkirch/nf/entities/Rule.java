package de.bauerkirch.nf.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rule {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String name;

	private String description;

	private Date date;

	private boolean fulfilled;

	protected Rule() {
	};

	public Rule(String name, String description, Date date) {
		super();
		this.name = name;
		this.description = description;
		this.date = date;
	}

	@Override
	public String toString() {
		return "Rule [id=" + id + ", name=" + name + ", description=" + description + ", date=" + date + ", fulfilled=" + fulfilled + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public Date getDate() {
		return date;
	}

	public boolean isFulfilled() {
		return fulfilled;
	}

	public void setFulfilled(boolean fulfilled) {
		this.fulfilled = fulfilled;
	}

}
