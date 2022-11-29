package io.github.amaralhcarlos.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.amaralhcarlos.webapp.model.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

}
