package com.synechron.employeetracker.etracker.dao.entity.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
public abstract class BaseEntity implements Serializable {

    @Id
    private String id;

    @CreatedDate
    private Date createdDate;

    private Boolean delete = Boolean.FALSE;
}
