package de.bauerkirch.nf.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.bauerkirch.nf.entities.Rule;
import de.bauerkirch.nf.repositories.CategoryRepository;
import de.bauerkirch.nf.repositories.RuleRepository;

@RestController
@RequestMapping(value = "/rules")
public class RuleController {

	private static final Logger log = LoggerFactory.getLogger(RuleController.class);

	@Autowired
	private RuleRepository ruleRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public Iterable<Rule> getAllRules() {
		return ruleRepository.findAll();
	}

	@RequestMapping(value = "get", method = RequestMethod.GET)
	public Rule getRule(@RequestParam(value = "id") long id) {
		return ruleRepository.findOne(id);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public Rule modifyRule(@RequestBody Rule rule) {
		ruleRepository.save(rule);
		categoryRepository.save(rule.getCategory());
		return rule;
	}

	@RequestMapping(value = "/todoCount", method = RequestMethod.GET)
	public int getTodoCount() {
		return ruleRepository.findByFulfilled(false).size();
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public Iterable<Rule> search(@RequestParam(value = "name") String name) {
		Iterable<Rule> list = ruleRepository.findByNameContaining(name);
		return list;
	}

}
