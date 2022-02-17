package com.example.demo.repositry;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo extends JpaRepository<Item, String > {
    Page<Item>
    findAll( Pageable pageable);
    long count();
    Page<Item>
    getAllBy( Pageable pageable);
    long countAllBy();
}
