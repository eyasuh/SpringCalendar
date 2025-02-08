package com.hulum.calendar.repository;

import com.hulum.calendar.model.Content;
import com.hulum.calendar.model.Status;
import com.hulum.calendar.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {
	private final List<Content> contents = new ArrayList<>();
	public ContentCollectionRepository() {}

	public List<Content> findAll() {
		return contents.stream().toList();
	}

	public Optional<Content> findById(Integer id) {
		return contents.stream().filter(c -> c.id().equals(id)).findFirst();
	}



	public void save(Content content) {
		contents.removeIf(c -> c.id().equals(content.id()));
		contents.add(content);
	}

	public void delete(Integer id) {
		contents.removeIf(c -> c.id().equals(id));
	}

	@PostConstruct
	public void init() {
		Content content = new Content(
				1,
				"First title",
				"first post",
				Status.IDEA,
				Type.ARTICLE,
				LocalDateTime.now(),
				null,
				"");
		contents.add(content);
	}


}
