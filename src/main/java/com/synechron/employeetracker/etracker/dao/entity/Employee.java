package com.synechron.employeetracker.etracker.dao.entity;

import com.synechron.employeetracker.etracker.dao.entity.common.BaseEntity;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "employees")
public class Employee extends BaseEntity {

    private String firstName;

    private String lastName;

    private String status;

    private String designation;

    private String project;

    private Date dateOfJoining;
}
