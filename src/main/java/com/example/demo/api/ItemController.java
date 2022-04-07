package com.example.demo.api;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.dto.ItemDTO;
import com.example.demo.service.ItemService;
import com.example.demo.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;

@RestController
@CrossOrigin
@RequestMapping("api/v1/items")
public class ItemController {
    @Autowired
    private ItemService itemService;
    @PostMapping
    public ResponseEntity saveItem(@RequestBody ItemDTO dto) {
        System.out.println(dto);
        String id=itemService.addItem(dto);
        System.out.println("hello"+dto);

        return new ResponseEntity(
                new StandardResponse(201, id + " success added", null),
                HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity updateItem(@RequestBody ItemDTO dto) {
        String id = itemService.updateItem(dto);
        return new ResponseEntity(
                new StandardResponse(204, "done", id), HttpStatus.OK
        );

    }

}
