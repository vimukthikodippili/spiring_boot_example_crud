package com.example.demo.api;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.dto.paginated.PaginatedCustomerDTO;
import com.example.demo.dto.paginated.PaginatedItemDTO;
import com.example.demo.service.CustomerService;
import com.example.demo.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/customers")

public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity saveCustomer(@RequestBody CustomerDTO dto) throws ValidationException {
        System.out.println("hello"+dto);

        String id = customerService.addCustomer(dto);

        return new ResponseEntity(
                new StandardResponse(201, id + " success added", null),
                HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateCustomer(@RequestBody CustomerDTO dto) {
        String id = customerService.updateCustomer(dto);
        return new ResponseEntity(
                new StandardResponse(204, "done", id), HttpStatus.OK
        );

    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteCustomer(@PathVariable String id) {
        System.out.println("hello");
        StandardResponse response = null;
        String customerID = null;
        customerID = customerService.deleteCustomer(id);
        response = new StandardResponse(
                200, "success", customerID
        );
        return new ResponseEntity(response, HttpStatus.OK);
    }
//    @GetMapping(params ={ "customerID,customerName"})
//    public ResponseEntity searchCustomer(@RequestParam (value = "customerID")String id,@RequestParam(value = "customerName")String name ){
//        PaginatedCustomerDTO paginatedCustomerDTO = null;
//        paginatedCustomerDTO =
//                customerService.searchAllCustomer(id,name);
//
//
//
//        return new ResponseEntity(new StandardResponse(200,"success", paginatedCustomerDTO),HttpStatus.OK);
//    }


    @GetMapping(params = {"name", "pageNo", "size"})
    public ResponseEntity<StandardResponse> searchByCustomerName(
            @RequestParam String name,
            @RequestParam int pageNo,
            @RequestParam int size) {
        System.out.println(name);
        System.out.println(pageNo);
        System.out.println(size);

        PaginatedCustomerDTO paginatedCustomerDTO=null;
        customerService.searchByCustomerName(name, pageNo, size);
        return new ResponseEntity(new StandardResponse(200,"success",paginatedCustomerDTO),HttpStatus.OK);
    }

    @GetMapping(params = {"pageNo", "size"})
    public ResponseEntity<StandardResponse> getAllCustomer(@RequestParam int pageNo, @RequestParam int size) {
        PaginatedCustomerDTO allCustomer = customerService.getAllCustomer(pageNo, size);
        return new ResponseEntity<>(
                new StandardResponse(200, "success", allCustomer),
                HttpStatus.OK);
    }


//@DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
//public ResponseEntity deleteCustomer(@RequestParam String id) {
//    customerService.deleteCustomer(id);
//    return new ResponseEntity(new StandardResponse(), HttpStatus.OK);
//}


//
//@DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
//public ResponseEntity deleteCustomer(@RequestParam String id) {
//    customerService.deleteCustomer(id);
//    return new ResponseEntity(new StandardResponse( ), HttpStatus.OK);
//}
//

}
