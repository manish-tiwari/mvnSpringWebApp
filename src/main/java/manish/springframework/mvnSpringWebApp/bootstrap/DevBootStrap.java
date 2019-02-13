package manish.springframework.mvnSpringWebApp.bootstrap;

import manish.springframework.mvnSpringWebApp.model.Author;
import manish.springframework.mvnSpringWebApp.model.Book;
import manish.springframework.mvnSpringWebApp.model.Publisher;
import manish.springframework.mvnSpringWebApp.repositories.AuthorRepository;
import manish.springframework.mvnSpringWebApp.repositories.BookRepository;
import manish.springframework.mvnSpringWebApp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by Manish Tiwari on 2/13/2019.
 */
@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {


    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Publisher publisher = new Publisher("ABC", "XYZ Street");
        Book effectiveJava = new Book("Effective Java", "1234", publisher);
        Author effectiveJavaAuthor = new Author("Joshua", "Bloch");
        effectiveJavaAuthor.getBooks().add(effectiveJava);
        effectiveJava.getAuthors().add(effectiveJavaAuthor);
        publisherRepository.save(publisher);
        authorRepository.save(effectiveJavaAuthor);
        bookRepository.save(effectiveJava);
    }
}
