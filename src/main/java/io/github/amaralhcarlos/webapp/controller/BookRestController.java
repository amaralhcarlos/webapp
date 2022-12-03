package io.github.amaralhcarlos.webapp.controller;

import io.github.amaralhcarlos.webapp.model.Book;
import io.github.amaralhcarlos.webapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookRestController {

    @Autowired
    private BookService bookService;

    @GetMapping("/rest/books")
    public List<Book> getBooks() {

        return bookService.getAllBooks();

    }

}
