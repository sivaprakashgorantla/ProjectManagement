package com.project.app.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "employee_task", joinColumns = @JoinColumn(name = "employee_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "task_id", referencedColumnName = "id"))
	private List<Task> task = new ArrayList<>();

	public Employee() {
		super();
	}

	public Employee(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}

}
