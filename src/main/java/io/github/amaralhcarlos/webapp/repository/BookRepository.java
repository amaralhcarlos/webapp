package io.github.amaralhcarlos.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import io.github.amaralhcarlos.webapp.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
