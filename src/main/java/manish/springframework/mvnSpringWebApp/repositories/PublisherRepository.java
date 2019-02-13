package manish.springframework.mvnSpringWebApp.repositories;

import manish.springframework.mvnSpringWebApp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Manish Tiwari on 2/13/2019.
 */
public interface PublisherRepository  extends CrudRepository<Publisher,Long> {
}
