package com.project.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.app.entity.Project;
import com.project.app.respository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService{

	@Autowired
	private ProjectRepository projectRepository;
	
	public List<Project> getProjects(){
		return projectRepository.findAll();
		
	}

	@Transactional(rollbackForClassName = {"java.lang.Excpetion"})
	public Project saveProject(Project project) {

		// TODO Auto-generated method stub
		projectRepository.save(project);
		return null;
	}
	
	@Transactional(rollbackForClassName = {"java.lang.Excpetion"})
	public Project updateProject(Project project) {

		// TODO Auto-generated method stub
		projectRepository.save(project);
		return null;
	}


	@Override
	public Project getProjectById(Long id) {
		// TODO Auto-generated method stub
		return projectRepository.findById(id).get();
	}


	public void deleteProject(Long id) {
		// TODO Auto-generated method stub
		projectRepository.deleteById(id);
		
	}
}
