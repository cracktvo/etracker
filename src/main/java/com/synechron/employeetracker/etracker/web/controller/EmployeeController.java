package com.synechron.employeetracker.etracker.web.controller;

import com.synechron.employeetracker.etracker.dao.entity.Designation;
import com.synechron.employeetracker.etracker.dao.entity.Employee;
import com.synechron.employeetracker.etracker.dao.entity.Project;
import com.synechron.employeetracker.etracker.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee/{page}/{size}")
    public Flux<Employee> findAllEmployees(@PathVariable Integer page, @PathVariable Integer size) {
        log.debug("findAll Employee");
        return employeeService.findAllEmployees(page, size);
    }

    @PostMapping("/employee")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Employee> createEmployee(@RequestBody Employee blog) {
        log.debug("create Employee with blog : {}", blog);
        return employeeService.createEmployee(blog);
    }

    @DeleteMapping("/employee/{id}")
    public Mono<Boolean> deleteEmployee(@PathVariable String id) {
        log.debug("delete Employee with id : {}", id);
        return employeeService.deleteEmployee(id);
    }

    @PutMapping("/employee/{id}")
    public Mono<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable String id) {
        log.debug("update Employee with id : {} and blog : {}", id, employee);
        return employeeService.updateEmployee(employee, id);
    }

    @GetMapping("/designation")
    public Flux<Designation> findAllDesignations() {
        log.debug("findAll Employee");
        return employeeService.findAllDesignations();
    }

    @PostMapping("/designation")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Designation> createDesignation(@RequestBody Designation designation) {
        log.debug("create Designation with blog : {}", designation);
        return employeeService.createDesignation(designation);
    }

    @DeleteMapping("/designation/{id}")
    public Mono<Boolean> deleteDesignation(@PathVariable String id) {
        log.debug("delete Designation with id : {}", id);
        return employeeService.deleteDesignation(id);
    }

    @GetMapping("/project")
    public Flux<Project> findAllProjects() {
        log.debug("findAll Project");
        return employeeService.findAllProjects();
    }

    @PostMapping("/project")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Project> createDesignation(@RequestBody Project project) {
        log.debug("create Project with blog : {}", project);
        return employeeService.createProject(project);
    }

    @DeleteMapping("/project/{id}")
    public Mono<Boolean> deleteProject(@PathVariable String id) {
        log.debug("delete Project with id : {}", id);
        return employeeService.deleteProject(id);
    }

}
