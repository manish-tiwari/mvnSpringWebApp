package manish.springframework.mvnSpringWebApp.repositories;

import manish.springframework.mvnSpringWebApp.model.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Manish Tiwari on 2/13/2019.
 */
public interface BookRepository extends CrudRepository<Book,Long> {
}
