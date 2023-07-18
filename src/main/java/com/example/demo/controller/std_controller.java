package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.student;
import com.example.demo.repository.std_repository;

@RestController
public class std_controller
	{
	
	@Autowired
	private std_repository repo;
	
	//add student
	@PostMapping("/save")
	public student addStudent(@RequestBody student st) {
		return repo.save(st);
	}
	
	//add multiple student
	@PostMapping("/saveAll")
	public List<student> addMultipleStudents(@RequestBody List<student> st)
		{
			return repo.saveAll(st);
		}
	
	//find all student
	@GetMapping("/findAllstd")
	public List<student> findAll()
	{
		return repo.findAll();
	}
	
	//find student using id
	@GetMapping("/findbystdid/{id}")
	public student findbyId(@PathVariable long id)
	{
		return repo.findById(id).orElseThrow(()->new RuntimeException("Cannot find student"));
	}
	
	//update student
	@PutMapping("/update")
	public student updateStudent(@RequestBody student st)
	{
		student oldst=repo.findById(st.getId()).orElseThrow(()-> new RuntimeException("Cannot find student to update"));
		oldst.setAddress(st.getAddress());
		oldst.setName(st.getName());
		oldst.setYear(st.getYear());
		
		return repo.save(oldst);
	}
	
	//delete student
	@DeleteMapping("/delete/{id}")
	public String deleteusingId(@PathVariable long id)
	{
		repo.deleteById(id);
		return "successfully deleted!";
	}
}
