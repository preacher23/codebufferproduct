package com.dailycodebuffer.productservice.repo;

import com.dailycodebuffer.productservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Productrepo extends JpaRepository<Product,Long> {
}
