package com.synechron.employeetracker.etracker.dao;

import com.synechron.employeetracker.etracker.dao.entity.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeRepository  extends ReactiveCrudRepository<Employee,String>{

    Flux<Employee> findAllByDelete(boolean delete,Pageable page);

    Mono<Employee> findByIdAndDeleteIsFalse(String id);
}
