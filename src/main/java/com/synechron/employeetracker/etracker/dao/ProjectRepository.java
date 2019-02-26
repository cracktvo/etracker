package com.synechron.employeetracker.etracker.dao;

import com.synechron.employeetracker.etracker.dao.entity.Project;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProjectRepository extends ReactiveCrudRepository<Project, String> {

    Flux<Project> findByDelete(Boolean delete);

    Mono<Project> findByIdAndDeleteIsFalse(String id);
}
