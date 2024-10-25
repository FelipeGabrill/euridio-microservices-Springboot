package com.erudio.services;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erudio.exceptions.ResourceNotFoundException;
import com.erudio.model.Person;
import com.erudio.repositories.PersonRepository;

@Service
public class PersonServices {

	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	private PersonRepository repository;
	
	public Person findById(Long id) {
		logger.info("Finding one person!");
		Person person = new Person();
		person.setFirstName("Luca");
		person.setLastName("Costa");
		person.setAddress("Brasil");
		person.setGender("Male");
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
	}
	
	public List<Person> findAll() {
		List<Person> persons = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		return repository.findAll();
	}

	private Person mockPerson(int i) {
		Person person = new Person();
		person.setFirstName("Person name: " + i);
		person.setLastName("Last name: " + i);
		person.setAddress("Some address in Brasil" + i);
		person.setGender("Male");
		return person;
	}
	
	public Person create(Person person) {
		logger.info("Creating one person!");
		return repository.save(person);
	}
	
	public Person update(Person person) {
		logger.info("Updating one person!");
		var entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getFirstName());
		entity.setAddress(person.getFirstName());
		entity.setGender(person.getFirstName());
		
		return repository.save(person);
	}
	
	public void delete(Long id) {
		logger.info("Deleting one person!");
		
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		repository.delete(entity);
		
	}
	
	
}
