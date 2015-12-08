package de.bauerkirch.nf.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.bauerkirch.nf.entities.Rule;

public interface RuleRepository extends CrudRepository<Rule, Long> {
	
	List<Rule> findByFulfilled(boolean fulfilled);
	
	List<Rule> findByNameLike(String name);
	
	List<Rule> findByNameContaining(String name);
	
	List<Rule> findByNameStartingWith(String name);
	
	
}
