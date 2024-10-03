package com.project.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.app.entity.Project;
import com.project.app.service.ProjectService;

@Controller
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@GetMapping("/")
	public String home() {
		System.out.println("Home ");
		return "home";
	}

	@GetMapping("/getProjects")
	public String Projects(Model model) {
		List<Project> projects = projectService.getProjects();

		model.addAttribute("projects", projects);
		return "projects";
	}

	@GetMapping("/addProject")
	public String addProject(Model model) {
		System.out.println("addProject................");
		model.addAttribute(new Project());
		return "add_project";
	}

	@PostMapping("/saveProject")
	public String saveProject(@ModelAttribute("project") Project project) {
		System.out.println("saveProject................");
		projectService.saveProject(project);
		return "redirect:/getProjects";
	}


	@PostMapping("/update Project")
	public String updateProject(@ModelAttribute("project") Project project) {
		System.out.println("updateProject................");
		projectService.updateProject(project);
		return "redirect:/getProjects";
	}

	@GetMapping("/editProject/{id}")
	public String editProject(@PathVariable("id") Long id, Model model) {
		Project project = projectService.getProjectById(id);
		
		model.addAttribute("project", project);
		return "update_project"; // a view for editing the project
	}

	@GetMapping("/deleteProject/{id}")
	public String deleteProject(@PathVariable("id") Long id) {
		projectService.deleteProject(id);
		return "redirect:/getProjects"; // after deleting, redirect to the list of projects
	}

}
