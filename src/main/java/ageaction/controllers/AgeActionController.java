package ageaction.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import ageaction.model.Author;
import ageaction.model.Label;
import ageaction.model.Story;
import ageaction.services.AgeActionService;

@Controller
public class AgeActionController {
	
	private static final Logger LOG = Logger.getLogger(AgeActionController.class);
	
	@Autowired
	private AgeActionService service;

	
	// Stories //
	
	@CrossOrigin
	@GetMapping("/stories")
	public @ResponseBody List<Story> getAll() {
		List<Story> s = service.getAll();
		LOG.info("Count of Stories is : " + s.size());
		return s;
	}
	

	@PutMapping("/story/{id}")
	public @ResponseBody Story saveStory(@RequestBody Story newStory, @PathVariable long id) {
		
		// look up
		 return service.findStoryById(id)
			      .map(story -> {
			    	  story.setStoryContent(newStory.getStoryContent());
			    	  story.setSummary(newStory.getSummary());
			    	  story.setTitle(newStory.getTitle());
			    	  story.setPublish(newStory.getPublish());
			    	  return service.saveStory(story);
			      })
			      .orElseGet(() -> {
			    	  newStory.setStoryID(id);
			        return service.saveStory(newStory);
			      });
	
	}
	
	@DeleteMapping("/story/{id}")
	public void deleteStory(@PathVariable Long id) {
	    service.deleteById(id);
	}
	
	@PostMapping("/stories/")
	public @ResponseBody Story createStory(@RequestBody Story story) {
		
		return service.saveStory(story);
		
	}
	
	@CrossOrigin
	@GetMapping("/story")
	public @ResponseBody List<Story> getStoryById(@RequestParam() List<String> labels) {
		
		List<Story> stories = new ArrayList<Story>();
		
		List<Label> labelList = service.findLabelByName(labels);
		
		if(labelList != null && labelList.size() > 0) {
			
			stories = service.getStoryByLabel(labelList);
		}
		
		// Return distinct list, otherwise duplicate stories are returned based on multiple label matches
		return stories.stream().distinct().collect(Collectors.toList());
	}
	
	// Labels //
	
	@GetMapping("/labels")
	public @ResponseBody List<Label> getAllLabels() {
		List<Label> l = service.getAllLabels();
		return l;
	}
	
	@DeleteMapping("/label/{id}")
	public void deleteLabel(@PathVariable Long id) {
	    service.deleteLabelById(id);
	}
	
	@PostMapping("/labels/")
	public @ResponseBody Label createLabel(@RequestBody Label label) {
		
		return service.saveLabel(label);
		
	}
	
	@PutMapping("/label/{id}")
	public@ResponseBody Label saveLabel(@RequestBody Label newLabel, @PathVariable long id) {
		
	// look up
			 return service.findLabelById(id)
				      .map(label -> {
				    	  label.setLabelName(newLabel.getLabelName());
				    	  return service.saveLabel(label);
				      })
				      .orElseGet(() -> {
				    	  newLabel.setLabelID(id);
				        return service.saveLabel(newLabel);
				      });
		
	}
	
	// Authors
	
	@GetMapping("/authors")
	public @ResponseBody List<Author> getAllAuthors() {
		List<Author> a = service.getAllAuthors();
		return a;
	}
	
	@DeleteMapping("/author/{id}")
	public void deleteAuthor(@PathVariable Long id) {
	    service.deleteAuthorById(id);
	}
	
	@PostMapping("/authors/")
	public @ResponseBody Author createAuthor(@RequestBody Author author) {
		
		return service.saveAuthor(author);
	}
	
	
	
}
