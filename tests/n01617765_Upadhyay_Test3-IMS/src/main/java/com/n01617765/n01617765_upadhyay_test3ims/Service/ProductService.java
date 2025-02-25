package com.n01617765.n01617765_upadhyay_test3ims.Service;

import com.n01617765.n01617765_upadhyay_test3ims.Model.Product;
import com.n01617765.n01617765_upadhyay_test3ims.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    // Fetch all products
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    // Add a new product
    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    // Update an existing product
    public Product updateProduct(long id, Product product) {
        return productRepo.findById(id)
                .map(existingProduct -> updateProductDetails(existingProduct, product))
                .orElseThrow(() -> new RuntimeException("Product with ID " + id + " not found!"));
    }

    // Helper method to update product details
    private Product updateProductDetails(Product existingProduct, Product updatedProduct) {
        existingProduct.setName(updatedProduct.getName());
        existingProduct.setDescription(updatedProduct.getDescription());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setStock(updatedProduct.getStock());
        return productRepo.save(existingProduct);
    }

    // Delete a product by ID
    public void deleteProduct(Long id) {
        if (!productRepo.existsById(id)) {
            throw new RuntimeException("Product with ID " + id + " not found!");
        }
        productRepo.deleteById(id);
    }

    // Optional: Update stock separately
    public Product updateStock(Long id, int stock) {
        return productRepo.findById(id)
                .map(product -> {
                    product.setStock(stock);
                    return productRepo.save(product);
                })
                .orElseThrow(() -> new RuntimeException("Product with ID " + id + " not found!"));
    }


}
