package de.bauerkirch.nf;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import de.bauerkirch.nf.entities.CategoryMark;
import de.bauerkirch.nf.entities.CategoryOther;
import de.bauerkirch.nf.entities.CategoryPolitik;
import de.bauerkirch.nf.entities.Rule;
import de.bauerkirch.nf.repositories.RuleRepository;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner demoRules(final RuleRepository ruleRepository) {
		return (args) -> {
			if (ruleRepository.findByNameLike("asdasd").isEmpty()) {
				log.info("No rules found, create dummy rules");	
				//@formatter:off
				ruleRepository.save(new Rule("Festlegen einer Qualitätspolitik",
						"Qualitätspolitik	Die Qualitätspolitik gibt die (qualitätsbezogene) Unternehmensausrichtung vor, bildet den "
						+ "Handlungsrahmen für sämtliche Punkte eines QM-Systemes, sollte die Grundsätze des Qualitätsmanagement beachten. "
						+ "Muss als Dokument vorliegen.",
						new Date(), new CategoryPolitik()));
				ruleRepository.save(new Rule("Festlegen von Qualitätszielen", "Konkrete Zwischenziele zum Erreichen der Qualitätspolitik<br/>"
						+ "Unterteilung in:<br/>"
						+ "- marktgerichtet<br/>"
						+ "- produktivitätssteigernd<br/>"
						+ "- Schaffung von Qualitätsbewusstsein<br/>"
						+ "Muss dokumentiert sein.", 
						new Date(), new CategoryMark()));
				ruleRepository.save(new Rule("Festlegen des Anwendungsbereiches", "Es muss festgelegt werden, für welche Bereiche das QMS aufgebaut"
						+ " wird und begründet werden, warum manche Bereiche ausgelassen werden.", 
						new Date(), new CategoryOther()));
				//@formatter:on
			}
		};
	}

}
