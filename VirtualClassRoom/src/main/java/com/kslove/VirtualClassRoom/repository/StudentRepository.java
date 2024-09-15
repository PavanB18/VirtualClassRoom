package com.kslove.VirtualClassRoom.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kslove.VirtualClassRoom.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
	public List<Student> findAllByName(String name);// find list of students by name.

}
