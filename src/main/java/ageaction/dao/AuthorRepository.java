package ageaction.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ageaction.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

	List<Author> findAll();
	

}
