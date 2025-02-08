package com.hulum.calendar.controller;

import com.hulum.calendar.model.Content;
import com.hulum.calendar.repository.ContentCollectionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/api/content")
public class ContentController {
	private final ContentCollectionRepository repository;

	public ContentController(ContentCollectionRepository repository) {
		this.repository = repository;
	}

	@GetMapping("")
	public List<Content> findAll() {
		return repository.findAll();
	}
	@ResponseStatus(HttpStatus.FOUND)
	@GetMapping("/{id}")
	public Content findById(@PathVariable Integer id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT, "Content not foud."));
	}


	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public void create (@RequestBody Content content) {
		repository.save(content);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PatchMapping("/{id}")
	public void update (@RequestBody Content content, @PathVariable Integer id) {
		if(repository.findById(id).isPresent())	repository.save(content);
		else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not foud.");
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete (@PathVariable Integer id) throws ResponseStatusException {
		repository.delete(id);
	}



}
