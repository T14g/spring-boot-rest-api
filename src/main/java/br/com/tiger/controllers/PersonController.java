package br.com.tiger.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.tiger.request.converters.PersonServices;
import br.com.tiger.model.Person;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired // para injetar a dependencia do PersonServices
    private PersonServices service;

    @RequestMapping(value = { "", "/" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll() {
        return service.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById(@PathVariable("id") String id) {
        return service.findById(id);
    }

    @RequestMapping(value = { "",
            "/" }, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person createPerson(@RequestBody Person person) {
        return service.createPerson(person);
    }

    @RequestMapping(value = { "",
            "/" }, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person updatePerson(@RequestBody Person person) {
        return service.updatePerson(person);
    }

    @RequestMapping(value = { "/{id}" }, method = RequestMethod.DELETE)
    public void deletePerson(@PathVariable("id") String id) {
        service.deletePerson(id);
    }
}
