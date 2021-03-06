package com.example.demo.service;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.dto.ItemDTO;
import com.example.demo.dto.paginated.PaginatedCustomerDTO;
import com.example.demo.dto.paginated.PaginatedItemDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.bind.ValidationException;

public interface ItemService {
    public String addItem(ItemDTO dto) ;

    public String deleteItem(String id);

    public PaginatedItemDTO searchAllItem(
            int page, int pageSize);

    public PaginatedItemDTO getAllItem( int page, int pageSize);

    public String updateItem(ItemDTO dto);
}
