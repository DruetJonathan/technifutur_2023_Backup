package technifutur.be.technifutur.services;

import technifutur.be.technifutur.exception.EntityNotFoundException;
import technifutur.be.technifutur.models.entities.Product;
import technifutur.be.technifutur.repositories.ProductRepository;
import technifutur.be.technifutur.repositories.ProductRepositoryImpl;

import java.util.List;

public class ProductServicesImpl {
    private final ProductRepository productRepository;


    public ProductServicesImpl() {
        this.productRepository = new ProductRepositoryImpl();
    }
    public Product getOne(Integer id) {
        return productRepository.getOne(id);
    }

    public List<Product> getMany() {
        return productRepository.getMany();
    }

    public void delete(Integer id){
        productRepository.delete(id);
    }

    public boolean update(Integer id, Product product){
        if(!productRepository.update(id,product))
            throw new EntityNotFoundException();
        return true;
    }
    public void add(Product product){
        productRepository.add(product);
    }
}
