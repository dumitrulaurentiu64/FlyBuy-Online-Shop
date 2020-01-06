package pssc.flybuy.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import pssc.flybuy.entities.Product;

@Component
public interface ProductRepository extends MongoRepository<Product, String> {
}
