package com.example.demo.service.impl;

import com.example.demo.dto.ItemDTO;
import com.example.demo.dto.paginated.PaginatedCustomerDTO;
import com.example.demo.dto.paginated.PaginatedItemDTO;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Item;
import com.example.demo.exeption.EntryDuplicateException;
import com.example.demo.exeption.EntryNotFoundException;
import com.example.demo.repositry.ItemRepo;
import com.example.demo.service.ItemService;
import com.example.demo.util.mapper.CustomerMapper;
import com.example.demo.util.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.bind.ValidationException;
@Service
@Transactional
public class ItemServiceImpl  implements ItemService {
    @Autowired
    private ItemRepo itemRepo;
    @Autowired
    private ItemMapper itemMapper;

    @Override
    public String addItem(ItemDTO dto)  {
        if (!itemRepo.existsById(dto.getItemCode())){
            return itemRepo.save(itemMapper.toItem(dto)).getItemCode().substring(4);
        }
        else {
            throw new EntryDuplicateException("Customer id is already exists");
        }
    }

    @Override
    public String deleteItem(String id) {
        Item item = itemRepo.findById(id).orElseThrow(() ->
                new EntryNotFoundException("Customer is not exists")
        );
        item.setItemCode("deleted");
        return itemRepo.save(item).getItemCode().substring(4);


    }

    @Override
    public PaginatedItemDTO searchAllItem(int page, int pageSize) {
        return new PaginatedItemDTO(
                itemMapper.pageToItemDTO(itemRepo.findAll(PageRequest.of(page,pageSize))),itemRepo.count());
    }

    @Override
    public PaginatedItemDTO getAllItem(int page, int pageSize) {
        return new PaginatedItemDTO(
                itemMapper.pageToItemDTO(
                        itemRepo.getAllBy(PageRequest.of(page,pageSize))),
                itemRepo.countAllBy());
    }

    @Override
    public String updateItem(ItemDTO dto) {
        if (itemRepo.existsById(dto.getItemCode())){
            return itemRepo.save(itemMapper.toItem(dto)).getItemCode().substring(4);
        }else {
            throw new EntryNotFoundException("Customer is not exist");
        }

    }
}
