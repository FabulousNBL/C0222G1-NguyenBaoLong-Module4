package product.repository;

import product.model.Product;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
public interface IProductRepository {

    void create(Product product);

    List<Product> findAll();

    Product findById(int id);

    void update( Product product);

    void delete (int id);

    List<Product> search(String nameProduct);
}
