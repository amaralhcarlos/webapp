package io.github.amaralhcarlos.webapp.bootstrap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import io.github.amaralhcarlos.webapp.model.Author;
import io.github.amaralhcarlos.webapp.model.Book;
import io.github.amaralhcarlos.webapp.repository.AuthorRepository;
import io.github.amaralhcarlos.webapp.repository.BookRepository;

@Component
public class BootStrapData implements CommandLineRunner {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {

        Author author1 = Author.builder().firstName("Paul").lastName("Deitel").build();
        Author author2 = Author.builder().firstName("Harvey").lastName("Deitel").build();

        Set<Author> authors = new HashSet<Author>();

        Book book1 = Book.builder().title("Java: How to Program").isbn("9780134743356").build();

        authors.add(authorRepository.save(author1));
        authors.add(authorRepository.save(author2));

        book1.setAuthors(authors);
        bookRepository.save(book1);

        System.out.println("Authors in database: " + authorRepository.count());

        List<Book> books = bookRepository.findAll();
        books.stream().forEach(book -> System.out.println(book));
    }

}
