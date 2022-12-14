package io.github.amaralhcarlos.webapp.bootstrap;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import io.github.amaralhcarlos.webapp.model.Author;
import io.github.amaralhcarlos.webapp.model.Book;
import io.github.amaralhcarlos.webapp.model.Publisher;
import io.github.amaralhcarlos.webapp.repository.AuthorRepository;
import io.github.amaralhcarlos.webapp.repository.BookRepository;
import io.github.amaralhcarlos.webapp.repository.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {

    @Autowired private AuthorRepository authorRepository;

    @Autowired private BookRepository bookRepository;

    @Autowired private PublisherRepository publisherRepository;

    @Override
    public void run(String... args) throws Exception {

        Author author1 = Author.builder().firstName("Paul").lastName("Deitel").build();
        Author author2 = Author.builder().firstName("Harvey").lastName("Deitel").build();

        Set<Author> authors = new HashSet<>();

        Book book1 = Book.builder().title("Java: How to Program").isbn("9780134743356").build();

        authors.add(authorRepository.save(author1));
        authors.add(authorRepository.save(author2));

        Publisher publisher = publisherRepository.save(Publisher.builder().name("Pearson").city("Campinas").state("SP").build());

        book1.setAuthors(authors);
        book1.setPublisher(publisher);
        Book finalBook = bookRepository.save(book1);

        publisher.getBooks().add(finalBook);

        publisherRepository.save(publisher);

        System.out.println("Authors in database: " + authorRepository.count());

        List<Book> books = bookRepository.findAll();
        books.forEach(book -> System.out.println(book));
    }

}
