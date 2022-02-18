package com.example.demo.service;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.dto.paginated.PaginatedCustomerDTO;

import javax.xml.bind.ValidationException;

public interface CustomerService {
    public String addCustomer(CustomerDTO dto) throws ValidationException;

  public String deleteCustomer(String id);

    public PaginatedCustomerDTO searchAllCustomer(
            int page, int pageSize);

    public PaginatedCustomerDTO getAllCustomer( int page, int pageSize);

    public String updateCustomer(CustomerDTO dto);

    PaginatedCustomerDTO searchByCustomerName(String name, int number, int size);
}
