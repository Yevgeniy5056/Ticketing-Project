package com.cydeo.dto;

import com.cydeo.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO {

    private String projectName;
    private String projectCode;
    private UserDTO assignManager;
    private LocalDateTime projectStartDate;
    private LocalDateTime projectEndDate;
    private String projectDetail;
    private Status projectStatus;
}
