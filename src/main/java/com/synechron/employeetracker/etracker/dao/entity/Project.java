package com.synechron.employeetracker.etracker.dao.entity;

import com.synechron.employeetracker.etracker.dao.entity.common.BaseEntity;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "projects")
public class Project extends BaseEntity {

    private String projectName;
}
