package product.service;

import product.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService implements IProductService {
    private static Map<Integer, Product> map;

    static {
        map = new HashMap<>();
        map.put(1, new Product(1, "Coca", 13000, "Juice", "Long"));
        map.put(2, new Product(2, "Sprite", 13000, "Juice", "Hương"));
        map.put(3, new Product(3, "333", 13000, "Juice", "Linh"));
        map.put(4, new Product(4, "Mirinda", 13000, "Juice", "Trường"));
        map.put(5, new Product(5, "Pepsi", 13000, "Juice", "Hảo"));
        map.put(6, new Product(6, "Fanta", 13000, "Juice", "Lan"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public void save(Product product) {
        map.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return map.get(id);
    }

    @Override
    public void update(int id, Product product) {
        map.put(id, product);
    }

    @Override
    public void remove(int id) {
        map.remove(id);
    }

    @Override
    public List<Product> search(String nameProduct) {
        List<Product> products = new ArrayList<>();
        for (Map.Entry<Integer, Product> entry : map.entrySet()) {
            if (entry.getValue().getName().toLowerCase().contains(nameProduct.toLowerCase())) {
                products.add(entry.getValue());
            }
        }
        return products;
    }
}
