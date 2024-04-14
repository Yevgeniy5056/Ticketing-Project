package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.TaskDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.enums.Status;
import com.cydeo.service.ProjectService;
import com.cydeo.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProjectServiceImpl extends AbstractMapService<ProjectDTO, String> implements ProjectService {

    private final TaskService taskService;

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
                .peek(project -> {

                    List<TaskDTO> taskList = taskService.findTasksByManager(manager);

                    int completedTaskCounts = (int) taskList.stream()
                            .filter(task -> task.getProject().equals(project) && task.getTaskStatus() == Status.COMPLETE)
                            .count();

                    int unfinishedTaskCounts = (int) taskList.stream()
                            .filter(task -> task.getProject().equals(project) && task.getTaskStatus() != Status.COMPLETE)
                            .count();

                    project.setCompleteTaskCounts(completedTaskCounts);
                    project.setUnfinishedTaskCounts(unfinishedTaskCounts);

                })
                .collect(Collectors.toList());
    }
}
