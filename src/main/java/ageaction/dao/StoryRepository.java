package ageaction.dao;

import java.util.HashSet;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ageaction.model.Label;
import ageaction.model.Story;

public interface StoryRepository extends CrudRepository<Story, Long> {
	
	List<Story> findAll();
	

	List<Story> findByLabelsIn(HashSet<Label> labels);
	

	//List<Story> findStoryByLabelsLabelName(String name);

}

