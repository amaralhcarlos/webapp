package io.github.amaralhcarlos.webapp.service;

import io.github.amaralhcarlos.webapp.model.Book;
import io.github.amaralhcarlos.webapp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {

        return bookRepository.findAll();

    }
}
