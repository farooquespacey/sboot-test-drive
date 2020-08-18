package com.spacey.springboot.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String> {
	// See the magic? findBy<Property>[<ChildProperty>...] lets Spring Data JPA to
	// automatically create an underlying ORM definition by its method format.
	public List<Course> findByTopicId(String topicId);
	
	// public List<Course> findByName(String foo);
}
