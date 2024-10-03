package com.project.app.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.app.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
