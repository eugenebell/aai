package ageaction.services;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ageaction.model.Author;
import ageaction.model.Label;
import ageaction.model.Story;
import ageaction.dao.AuthorRepository;
import ageaction.dao.LabelRepository;
import ageaction.dao.StoryRepository;

@Service
public class AgeActionService {

	@Autowired
	private StoryRepository storyRepo;
	
	@Autowired
	private LabelRepository labelRepo;

	@Autowired
	private AuthorRepository authorRepo;

	
	// Stories //
	
	public List<Story> getAll() {
		
		return storyRepo.findAll();
	}
	
	public Optional<Story> findStoryById(long id) {
		
		return storyRepo.findById(id);
	}
	
	public Story getStoryById(Long id) {
		return storyRepo.findById(id).get();
	}

	public void deleteById(Long id) {
		
		storyRepo.deleteById(id);
		
	}

	public Story saveStory(Story story) {
		
		return storyRepo.save(story);		
	}
	
	//story by label

	public List<Story> getStoryByLabel(List<Label> labels) {
		return storyRepo.findByLabelsIn(new HashSet<Label>(labels));
	}


	// Labels //
	
	public List<Label> getAllLabels() {
		
		return labelRepo.findAll();
	}

	public void deleteLabelById(Long id) {
		
		labelRepo.deleteById(id);
		
	}

	public Label saveLabel(Label label) {
		
		return labelRepo.save(label);
	}
	

	public Optional<Label> findLabelById(long id) {
		
		return labelRepo.findById(id);
	}

	// Authors //
	
	public List<Author> getAllAuthors() {
		
		return authorRepo.findAll();
	}

	public Author saveAuthor(Author author) {
		
		return authorRepo.save(author);
	}

	public void deleteAuthorById(Long id) {
		
		authorRepo.deleteById(id);
		
	}

	public List<Label> findLabelByName(List<String> labels) {
		
		return labelRepo.findAllByLabelNameIn(labels);
	}


	
	
}
