package de.bauerkirch.nf.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.bauerkirch.nf.entities.Rule;
import de.bauerkirch.nf.repositories.RuleRepository;

@RestController
@RequestMapping(value = "/rules")
public class RuleController {

	private static final Logger log = LoggerFactory.getLogger(RuleController.class);

	@Autowired
	private RuleRepository repository;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public Iterable<Rule> getAllRules() {
		return repository.findAll();
	}

	@RequestMapping(value = "/demo", method = RequestMethod.GET)
	public boolean createDemoRules() {
		repository.save(new Rule("Rule1", "Desc1", new Date()));
		repository.save(new Rule("Rule2", "Desc2", new Date()));
		repository.save(new Rule("Rule3", "Desc3", new Date()));
		return true;
	}

	@RequestMapping(value = "get", method = RequestMethod.GET)
	public Rule getRule(@RequestParam(value="id") long id) {
		return repository.findOne(id);
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Rule modifyRule(@RequestBody Rule rule) {
		log.info(rule.toString());
		repository.save(rule);
		return rule;
	}

	@RequestMapping(value = "/todoCount", method = RequestMethod.GET)
	public int getTodoCount() {
		return repository.findByFulfilled(false).size();
	}

}
