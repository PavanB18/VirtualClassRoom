package com.kslove.VirtualClassRoom.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kslove.VirtualClassRoom.entity.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {
	public List<Course> findByStatus(boolean status); // find list of courses by status.

	public List<Course> findAllByName(String name); // find list of courses by name
}
