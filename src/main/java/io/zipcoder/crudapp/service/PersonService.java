package io.zipcoder.crudapp.service;

import io.zipcoder.crudapp.models.Person;
import io.zipcoder.crudapp.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository repo;

    public PersonService(PersonRepository repo) {
        this.repo = repo;
    }

    public Iterable<Person> index() {
        return repo.findAll();
    }

    public Person find(Long id) {
        return repo.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Person create(Person person) {
        return repo.save(person);
    }

    public Person update(Long id, Person newData) {
        Person pToUpdate = repo.findById(id).orElseThrow(EntityNotFoundException::new);
        pToUpdate.setFirstName(newData.getFirstName());
        pToUpdate.setLastName(newData.getLastName());
        return repo.save(pToUpdate);
    }

    public boolean delete(Long id) {
        repo.deleteById(id);
        return true;
    }
}
