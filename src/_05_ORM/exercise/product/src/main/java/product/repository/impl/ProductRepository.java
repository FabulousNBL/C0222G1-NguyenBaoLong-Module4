package product.repository.impl;

import org.springframework.stereotype.Repository;
import product.model.Product;
import product.repository.IProductRepository;

import javax.persistence.EntityTransaction;
import java.util.List;
@Repository
public class ProductRepository implements IProductRepository {

    @Override
    public void create(Product product) {
        EntityTransaction entityTransaction= BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(product);
        entityTransaction.commit();
    }

    @Override
    public List<Product> findAll() {
        List<Product> list= BaseRepository.entityManager.createQuery("select p from Product p where status =0",Product.class).getResultList();
        return list;
    }

    @Override
    public Product findById(int idSearch) {
        Product product= BaseRepository.entityManager.createQuery("select p from Product p where id = ?1", Product.class).setParameter(1,idSearch).getSingleResult();
        return product;
    }

    @Override
    public void update(Product product) {
        EntityTransaction entityTransaction= BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(product);
        entityTransaction.commit();
    }

    @Override
    public void delete(int id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        Product product = findById(id);
        product.setStatus(1);
        BaseRepository.entityManager.merge(product);
        entityTransaction.commit();
    }

    @Override
    public List<Product> search(String nameProduct) {
        List<Product> list = BaseRepository.entityManager.createQuery("select p from Product p where name like ?1 and p.status = 0",Product.class).setParameter(1,"%"+nameProduct+"%").getResultList();
        return list;
    }
}
