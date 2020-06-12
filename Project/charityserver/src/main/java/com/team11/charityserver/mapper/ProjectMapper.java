package com.team11.charityserver.mapper;


import com.team11.charityserver.model.Project;

import java.util.List;

public interface ProjectMapper {
    int insertSelective(Project project);

    int updateProject(Project project);

    List<Project> getAllProjects();

    List<Project> getProjectsByCharityId(Integer charityId);
}
