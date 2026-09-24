package br.com.tiger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import br.com.tiger.model.Person;

public interface PersonRepositor extends JpaRepository<Person, Long> {
 
}   