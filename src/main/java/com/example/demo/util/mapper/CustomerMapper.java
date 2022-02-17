package com.example.demo.util.mapper;
import com.example.demo.dto.CustomerDTO;
import com.example.demo.entity.Customer;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customer toCustomer(CustomerDTO customerDTO);
    CustomerDTO toCustomerDTO(Customer customer);
    List<CustomerDTO> pageToCustomerDTO(Page<Customer> customer);
    List<Customer > toCustomerAll(List<CustomerDTO> customerDTOS);


}
