package product.service;

import product.model.Product;

import java.util.List;

public interface IProductService {
    void create(Product product);
    List<Product> findAll();
    Product findById(int id);
    void update( Product product);
    void delete (int id);
    List<Product> search(String nameProduct);
}
