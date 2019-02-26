package com.synechron.employeetracker.etracker.service.impl;

import com.synechron.employeetracker.etracker.dao.DesignationRepository;
import com.synechron.employeetracker.etracker.dao.EmployeeRepository;
import com.synechron.employeetracker.etracker.dao.ProjectRepository;
import com.synechron.employeetracker.etracker.dao.entity.Designation;
import com.synechron.employeetracker.etracker.dao.entity.Employee;
import com.synechron.employeetracker.etracker.dao.entity.Project;
import com.synechron.employeetracker.etracker.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DesignationRepository designationRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Mono<Employee> createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Mono<Employee> updateEmployee(Employee employee, String id) {
        return findOneEmployee(id).doOnSuccess(findEmployee -> {
            findEmployee.setFirstName(employee.getFirstName());
            findEmployee.setLastName(employee.getLastName());
            findEmployee.setStatus(employee.getStatus());
            findEmployee.setDesignation(employee.getDesignation());
            findEmployee.setProject(employee.getProject());
            findEmployee.setDateOfJoining(employee.getDateOfJoining());
            employeeRepository.save(findEmployee);
        });
    }

    @Override
    public Mono<Employee> findOneEmployee(String id) {
        return employeeRepository.findByIdAndDeleteIsFalse(id).
                switchIfEmpty(Mono.error(new Exception("No Employee found with Id: " + id)));
    }

    @Override
    public Flux<Employee> findAllEmployees(Integer page, Integer size) {
        return employeeRepository.findAllByDelete(Boolean.FALSE,PageRequest.of(page, size));
    }

    @Override
    public Mono<Boolean> deleteEmployee(String id) {
        return findOneEmployee(id).doOnSuccess(item -> {
            item.setDelete(true);
            employeeRepository.save(item).subscribe();
        }).flatMap(item -> Mono.just(Boolean.TRUE));
    }

    @Override
    public Mono<Designation> createDesignation(Designation designation) {
        return designationRepository.save(designation);
    }

    @Override
    public Mono<Designation> findOneDesignation(String id){
        return designationRepository.findByIdAndDeleteIsFalse(id).
                switchIfEmpty(Mono.error(new Exception("No Designation found with Id: " + id)));
    }

    @Override
    public Flux<Designation> findAllDesignations() {
        return designationRepository.findByDelete(Boolean.FALSE);
    }

    @Override
    public Mono<Boolean> deleteDesignation(String id) {
        return findOneDesignation(id).doOnSuccess(item -> {
            item.setDelete(true);
            designationRepository.save(item).subscribe();
        }).flatMap(item -> Mono.just(Boolean.TRUE));
    }

    @Override
    public Mono<Project> createProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Mono<Project> findOneProject(String id){
        return projectRepository.findByIdAndDeleteIsFalse(id).
                switchIfEmpty(Mono.error(new Exception("No Project found with Id: " + id)));
    }

    @Override
    public Flux<Project> findAllProjects() {
        return projectRepository.findByDelete(Boolean.FALSE);
    }

    @Override
    public Mono<Boolean> deleteProject(String id) {

        return findOneProject(id).doOnSuccess(item -> {
            item.setDelete(true);
            projectRepository.save(item).subscribe();
        }).flatMap(item -> Mono.just(Boolean.TRUE));
    }
}
