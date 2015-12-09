package de.bauerkirch.nf.repositories;

import org.springframework.data.repository.CrudRepository;

import de.bauerkirch.nf.entities.Category;


public interface CategoryRepository extends CrudRepository<Category, Long> {

}
