package com.n01617765.n01617765_upadhyay_test3ims;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product addProduct(Product product) {
        return productRepo.save(product);
    }


    public Product updateProduct(int id, Product product) {
        Optional<Product> existingProduct = productRepo.findById(id);
        if (existingProduct.isPresent()) {
            Product p = existingProduct.get();
            p.setName(product.getName());
            p.setDescription(product.getDescription());
            p.setPrice(product.getPrice());
            p.setStock(product.getStock());
            return productRepo.save(p);
        }
        return null;
    }


    public void deleteProduct(int id) {
        productRepo.deleteById(id);
    }

//
//    public Product updateStock(int id, int stock) {
//        Optional<Product> existingProduct = productRepo.findById(id);
//        if (existingProduct.isPresent()) {
//            Product p = existingProduct.get();
//            p.setStock(stock);
//            return productRepo.save(p);
//        }
//        return null;
//    }
}
