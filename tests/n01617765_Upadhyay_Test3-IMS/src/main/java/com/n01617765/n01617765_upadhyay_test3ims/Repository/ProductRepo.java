package com.n01617765.n01617765_upadhyay_test3ims.Repository;

import com.n01617765.n01617765_upadhyay_test3ims.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

}
