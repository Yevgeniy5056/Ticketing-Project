package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.enums.Status;
import com.cydeo.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl extends AbstractMapService<ProjectDTO, String> implements ProjectService {

    @Override
    public ProjectDTO save(ProjectDTO project) {
        if (project.getProjectStatus() == null) {
            project.setProjectStatus(Status.OPEN);
        }
        return super.save(project.getProjectCode(), project);
    }

    @Override
    public ProjectDTO findById(String projectCode) {
        return super.findById(projectCode);
    }

    @Override
    public List<ProjectDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(String projectCode) {
        super.deleteById(projectCode);
    }

    @Override
    public void update(ProjectDTO project) {
        if (project.getProjectStatus() == null) {
            project.setProjectStatus(findById(project.getProjectCode()).getProjectStatus());
        }
        super.update(project.getProjectCode(), project);
    }

    @Override
    public void completeProject(ProjectDTO project) {
        project.setProjectStatus(Status.COMPLETE);
    }

    @Override
    public List<ProjectDTO> getCountedListOfProjectDTO(UserDTO manager) {
        return findAll().stream()
                .filter(project -> project.getAssignManager().equals(manager))
                .map(project -> {

                    project.setCompleteTaskCounts(5);
                    project.setUnfinishedTaskCounts(3);

                    return project;
                })
                .collect(Collectors.toList());
    }
}
