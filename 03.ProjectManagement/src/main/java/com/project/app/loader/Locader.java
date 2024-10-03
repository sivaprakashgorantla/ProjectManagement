package com.project.app.loader;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.project.app.entity.Project;
import com.project.app.respository.ProjectRepository;

@Component
public class Locader implements CommandLineRunner {

	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Locader.....................................");
		List<Project> projects = Arrays.asList(new Project("Mobile Management"), new Project("Leave Management"),
				new Project("Payroll Management"), new Project("Hospetal Management"),
				new Project("Library Management"), new Project("Fee Management"));
		projectRepository.saveAll(projects);

	}

}
