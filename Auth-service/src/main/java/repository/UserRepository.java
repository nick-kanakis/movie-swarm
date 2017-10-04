package repository;


import domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

/**
 * Created by Nick Kanakis on 3/6/2017.
 */
public interface UserRepository extends CrudRepository<User, String> {
    User findByUsername(String username);
}
