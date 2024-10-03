package com.project.app.service;

import java.util.List;

import com.project.app.entity.Project;

public interface ProjectService {
	
	 List<Project> getProjects();
	 
	 Project saveProject(Project project);

	Project getProjectById(Long id);

	void deleteProject(Long id);

	Project updateProject(Project project);

}
