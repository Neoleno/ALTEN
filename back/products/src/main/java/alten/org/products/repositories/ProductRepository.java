package alten.org.products.repositories;

import alten.org.products.entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ProductRepository extends MongoRepository<Product, String> {
    Product findById(int id);
    void deleteById(int id);
}
