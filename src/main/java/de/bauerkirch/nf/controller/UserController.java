package de.bauerkirch.nf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.bauerkirch.nf.entities.User;
import de.bauerkirch.nf.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserRepository repository;
	
	@RequestMapping("/signup")
	public User createUser(@RequestParam(value = "name") String name, @RequestParam(value = "password") String password) {
		return new User(name, password);
	}
	
	@RequestMapping(value="", method = RequestMethod.GET) 
	public Iterable<User> getAllUsers() {
		return repository.findAll();
	}
	
	@RequestMapping(value="/{id}",  method = RequestMethod.GET)
	public User getById(@RequestParam(value = "id") long id) {
		return  repository.findOne(id);
	}

}
