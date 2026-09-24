package br.com.tiger.services;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tiger.model.Person;
import br.com.tiger.repository.PersonRepositor;
import br.com.tiger.exception.ResourceNotFoundException;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());



    @Autowired
    PersonRepositor personRepository;

    public List<Person> findAll() {
        logger.info("Finding all people!");

       return personRepository.findAll();
    }

    public Person findById(Long id) {
        logger.info("Finding one person!");

        return personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found!"));
    }

    public Person createPerson(Person person) {
        logger.info("Creating one person!");
        return personRepository.save(person);
    }

    public Person updatePerson(Person person) {
        logger.info("Updating one person!");
        Person entity = personRepository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("Person not found!"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return personRepository.save(entity);
    }

    public void deletePerson(Long id) {
        logger.info("Deleting one person!");
        personRepository.deleteById(id);
    }   
}
