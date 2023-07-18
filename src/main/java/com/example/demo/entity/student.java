package com.example.demo.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="tbl_student")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class student {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private long id;
	
	private String name;
	//private String address;
	private String year;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Address address;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<subject> subjects;

	@ManyToMany(cascade=CascadeType.ALL)
	private Set<hobby> hobbies=new HashSet<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<subject> subjects) {
		this.subjects = subjects;
	}

	public Set<hobby> getHobbies() {
		return hobbies;
	}

	public void setHobbies(Set<hobby> hobbies) {
		this.hobbies = hobbies;
	}
	
	
	
	
}
