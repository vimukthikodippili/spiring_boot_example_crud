package com.example.demo.api;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.service.CustomerService;
import com.example.demo.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.xml.bind.ValidationException;

@RestController
//@CrossOrigin
@RequestMapping("/api/v1/customers")

public class CustomerController {
@Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity saveCustomer(@RequestBody CustomerDTO dto) throws ValidationException {
        System.out.println("mmm" +dto.getCustomerID()+ "ooo "+dto.getCustomerName());
        String id = customerService.addCustomer(dto);

        return new ResponseEntity(
                new StandardResponse(201, id+" success added", null),
                HttpStatus.CREATED);
    }
}
