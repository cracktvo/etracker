package com.synechron.employeetracker.etracker.dao;

import com.synechron.employeetracker.etracker.dao.entity.Designation;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DesignationRepository extends ReactiveCrudRepository<Designation,String> {

    Flux<Designation> findByDelete(Boolean delete);

    Mono<Designation> findByIdAndDeleteIsFalse(String id);
}
