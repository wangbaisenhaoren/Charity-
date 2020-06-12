package com.team11.charityserver.service;

import com.team11.charityserver.mapper.ProjectMapper;
import com.team11.charityserver.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    ProjectMapper projectMapper;

    public Integer addProject(Project project) {
        return projectMapper.insertSelective(project);
    }

    public Integer updateProject(Project project) {
        return projectMapper.updateProject(project);
    }

    public List<Project> getAllProjects() {
        return projectMapper.getAllProjects();
    }

    public List<Project> getProjectsByCharityId(Integer charityId) {
        return projectMapper.getProjectsByCharityId(charityId);
    }
}
