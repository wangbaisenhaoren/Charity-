package com.team11.charityserver.controller;

import com.team11.charityserver.model.Project;
import com.team11.charityserver.model.RespBean;
import com.team11.charityserver.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @PostMapping("/project")
    public RespBean addProject(@RequestBody Project project) {
        if (projectService.addProject(project) == 1) {
            return RespBean.ok("Add project successfully!");
        }
        return RespBean.error("Cannot add project!");
    }

    @PutMapping("/project")
    public void updateProject(@RequestBody Project project) {
        projectService.updateProject(project);
    }

    @GetMapping("/projects")
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/charity-projects")
    public List<Project> getProjectsByCharityId(@RequestParam(required = false) Integer charityId) {
        return projectService.getProjectsByCharityId(charityId);
    }
}
