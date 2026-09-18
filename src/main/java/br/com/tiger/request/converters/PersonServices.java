package br.com.tiger.request.converters;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;
import java.util.logging.Logger;
import br.com.tiger.model.Person;
// para ser injetado como dependencia onde precisar dele
@Service
public class PersonServices {

    // final = imutável, não pode ser alterado após a inicialização
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());
    
    public Person findById(String id) {
        logger.info("Finding one person!");

        // Mocking a person
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("John");
        person.setLastName("Doe");
        person.setAddress("São Paulo - Brasil");
        person.setGender("Male");
        return person;
    }

}
