package pssc.flybuy.repositories;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import pssc.flybuy.entities.Product;
import pssc.flybuy.entities.User;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    List<User> findByAgeLessThan(Integer maxAge);

    @Query(value = "{address.city:?0")
    List<User> findByCity(String city);
}
