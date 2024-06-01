package com.massive_jogger.Demo.data;

import com.massive_jogger.Demo.models.Person;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PersonDataLoader implements ApplicationRunner {
    private PersonRepository personRepository;

    public PersonDataLoader(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if(personRepository.count()==0){
            List<Person> admin=List.of(new Person(null,"Admin","Admin","Controller","ADMIN","ALl", LocalDate.of(2003,06,05),"Admin","Bitm@123","Bitm@123",'M'));
            System.out.println("added Admin");
            System.out.println(personRepository.count());
            personRepository.saveAll(admin);
        }
    }
}
