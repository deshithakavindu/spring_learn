package com.jdbc.spring.jdbc;

import com.jdbc.spring.jdbc.Models.Alien;
import com.jdbc.spring.jdbc.repo.AlienRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(Application.class, args);
        AlienRepo repo = context.getBean(AlienRepo.class);

        Alien alien1 = context.getBean(Alien.class);
        alien1.setId(11);
        alien1.setName("Navin");
        alien1.setTech("Java");

        repo.save(alien1);

// add another
        Alien alien2 = context.getBean(Alien.class);
        alien2.setId(12);
        alien2.setName("Kavindu");
        alien2.setTech("Python");

        repo.save(alien2);

// now print all
        repo.findall();

	}


}
