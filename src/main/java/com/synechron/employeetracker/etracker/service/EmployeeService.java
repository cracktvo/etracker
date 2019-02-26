package com.synechron.employeetracker.etracker.service;

import com.synechron.employeetracker.etracker.dao.entity.Designation;
import com.synechron.employeetracker.etracker.dao.entity.Employee;
import com.synechron.employeetracker.etracker.dao.entity.Project;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeService {

    Mono<Employee> createEmployee(Employee employee);

    Mono<Employee> updateEmployee(Employee employee, String id);

    Mono<Employee> findOneEmployee(String id);

    Flux<Employee> findAllEmployees(Integer page, Integer size);

    Mono<Boolean> deleteEmployee(String id);

    Mono<Designation> createDesignation(Designation designation);

    Mono<Designation> findOneDesignation(String id);

    Flux<Designation> findAllDesignations();

    Mono<Boolean> deleteDesignation(String id);

    Mono<Project> createProject(Project project);

    Mono<Project> findOneProject(String id);

    Flux<Project> findAllProjects();

    Mono<Boolean> deleteProject(String id);
}
