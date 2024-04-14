package com.cydeo.converter;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProjectDTOConverter implements Converter<String, ProjectDTO> {

    private final ProjectService projectService;

    @Override
    public ProjectDTO convert(String source) {
        return projectService.findById(source);
    }
}
