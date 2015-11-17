package de.bauerkirch.nf.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.bauerkirch.nf.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {

	 List<User> findByName(String Name);
	
}
