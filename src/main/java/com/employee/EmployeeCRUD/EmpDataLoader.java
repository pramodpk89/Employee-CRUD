package com.employee.EmployeeCRUD;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmpDataLoader {
    private static final Logger log = LoggerFactory.getLogger(EmpDataLoader.class);

    @Bean
    CommandLineRunner loadData(EmpRepository repository){
        return args -> {
            log.info("Loading employee "+repository.save(new Employee(001,"John","Doe","IT","Mumbai")));
            log.info("Loading employee "+repository.save(new Employee(002,"Sachin","T","IT","Mumbai")));
            log.info("Loading employee "+repository.save(new Employee(003,"Virender","S","Finance","Delhi")));
        };
    }
}
