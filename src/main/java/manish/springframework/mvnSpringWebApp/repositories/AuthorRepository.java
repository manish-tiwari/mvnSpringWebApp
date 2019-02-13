package manish.springframework.mvnSpringWebApp.repositories;

import manish.springframework.mvnSpringWebApp.model.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Manish Tiwari on 2/13/2019.
 */
public interface AuthorRepository extends CrudRepository<Author,Long> {

}
