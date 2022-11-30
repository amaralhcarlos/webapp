package io.github.amaralhcarlos.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import io.github.amaralhcarlos.webapp.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
