package ageaction.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ageaction.model.Label;

public interface LabelRepository extends CrudRepository<Label, Long> {

	List<Label> findAll();

	List<Label>  findAllByLabelNameIn(List<String> names);
	
}
