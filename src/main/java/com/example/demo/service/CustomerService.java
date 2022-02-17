package com.example.demo.service;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.dto.paginated.PaginatedCustomerDTO;

import javax.xml.bind.ValidationException;
import java.util.ArrayList;

public interface CustomerService {
    public String addCustomer(CustomerDTO dto) throws ValidationException;

  public String deleteCustomer(String id);

    public PaginatedCustomerDTO searchAllCustomer(
            int page, int pageSize);

    public PaginatedCustomerDTO getAllCustomer( int page, int pageSize);

    public String updateCustomer(CustomerDTO dto);

}
