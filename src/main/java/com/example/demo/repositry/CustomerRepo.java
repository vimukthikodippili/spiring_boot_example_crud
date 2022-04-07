package com.example.demo.repositry;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,String> {
    Page<Customer>
    findAll( Pageable pageable);
    long count();
    Page<Customer>
    getAllBy( Pageable pageable);
    long countAllBy();
    Page<Customer> findByCustomerNameEquals(String name, Pageable pageable);
    long countByCustomerNameEquals(String name);










}
