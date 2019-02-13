package manish.springframework.mvnSpringWebApp.bootstrap;

import manish.springframework.mvnSpringWebApp.model.Author;
import manish.springframework.mvnSpringWebApp.model.Book;
import manish.springframework.mvnSpringWebApp.repositories.AuthorRepository;
import manish.springframework.mvnSpringWebApp.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Book effectiveJava = new Book("Effective Java", "1234", "ABC");
        Author effectiveJavaAuthor = new Author("Joshua", "Bloch");
        effectiveJavaAuthor.getBooks().add(effectiveJava);
        effectiveJava.getAuthors().add(effectiveJavaAuthor);
        authorRepository.save(effectiveJavaAuthor);
        bookRepository.save(effectiveJava);
    }
}
