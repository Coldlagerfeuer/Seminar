package de.bauerkirch.nf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import de.bauerkirch.nf.entities.User;
import de.bauerkirch.nf.repositories.UserRepository;

@SpringBootApplication
public class Application {
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	
//	@Bean
//	public CommandLineRunner demoUsers(final UserRepository repository) {
//		return (args) -> {
//
//			// fetch all customers
//			log.info("Customers found with findAll():");
//			log.info("-------------------------------");
//			for (User user : repository.findAll()) {
//				log.info(user.toString());
//			}
//            log.info("");
//
//			// fetch an individual customer by ID
//            User user = repository.findOne(1L);
//			log.info("Customer found with findOne(1L):");
//			log.info("--------------------------------");
//			log.info(user.toString());
//            log.info("");
//
//			// fetch customers by last name
//			log.info("Customer found with findByName('Jack'):");
//			log.info("--------------------------------------------");
//			for (User bauer : repository.findByName("Jack")) {
//				log.info(bauer.toString());
//			}
//            log.info("");
//		};
//	}
	
}
