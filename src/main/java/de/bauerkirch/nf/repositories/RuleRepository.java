package de.bauerkirch.nf.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.bauerkirch.nf.entities.Rule;

public interface RuleRepository extends CrudRepository<Rule, Long> {
	
	List<Rule> findByFulfilled(boolean fulfilled);
	
}
