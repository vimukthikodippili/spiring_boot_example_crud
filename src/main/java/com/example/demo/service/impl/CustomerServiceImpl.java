package com.example.demo.service.impl;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.dto.paginated.PaginatedCustomerDTO;
import com.example.demo.entity.Customer;
import com.example.demo.exeption.EntryDuplicateException;
import com.example.demo.exeption.EntryNotFoundException;
import com.example.demo.repositry.CustomerRepo;
import com.example.demo.service.CustomerService;
import com.example.demo.util.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.bind.ValidationException;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
     private CustomerRepo customerRepo;
    @Autowired
    private CustomerMapper customerMapper;
    @Override
    public String addCustomer(CustomerDTO customerDTO) throws ValidationException {

            if (!customerRepo.existsById(customerDTO.getCustomerID())){
                return customerRepo.save(customerMapper.toCustomer(customerDTO)).getCustomerID().substring(4);
            }else {
                throw new EntryDuplicateException("Customer id is already exists");
            }

    }

    @Override
    public String deleteCustomer(String id) {
        Customer customer = customerRepo.findById(id).orElseThrow(() ->
                new EntryNotFoundException("Customer is not exists")
        );
        customerRepo.deleteById(id);
       return id;


    }

    @Override
    public PaginatedCustomerDTO searchAllCustomer(int page, int pageSize) {
        Pageable request = PageRequest.of(page, pageSize);
        Page<Customer> all = customerRepo.findAll(request);
        long count = customerRepo.count();
        List<CustomerDTO> customerDTOS = customerMapper.pageToCustomerDTO(all);
        PaginatedCustomerDTO paginatedCustomerDTO = new PaginatedCustomerDTO(customerDTOS, count);
        return paginatedCustomerDTO;
    }

    @Override
    public PaginatedCustomerDTO getAllCustomer(int page, int pageSize) {
        return new PaginatedCustomerDTO(
                customerMapper.pageToCustomerDTO(
                        customerRepo.getAllBy(PageRequest.of(page,pageSize))),
                customerRepo.countAllBy());
    }


//    @Override
//    public PaginatedCustomerDTO searchAllCustomer(int page, int pageSize) {
//
//        return new PaginatedCustomerDTO(customerRepo.findAll(page,pageSize)),customerRepo.count();
//
//    }

//
//    @Override
//    public CustomerDTO searchCustomer(String id) {
////        Optional<Customer> customer = customerRepo.findById(id);
//        return new PaginatedCustomerDTO(customerMapper.pageToCustomerDTO(customerRepo.findAll(id)),customerRepo.count());
//    }

//    @Override
//    public CustomerDTO searchCustomer(String id) {
//        Optional<Customer> customer = customerRepo.findById(id);
//        return null;
//    }


    @Override
    public String updateCustomer(CustomerDTO dto) {
        if (customerRepo.existsById(dto.getCustomerID())){
            return customerRepo.save(customerMapper.toCustomer(dto)).getCustomerID().substring(4);
        }else {
            throw new EntryNotFoundException("Customer is not exist");
        }

    }

    @Override
    public PaginatedCustomerDTO searchByCustomerName(String name, int number, int size) {
        return null;
    }
}
