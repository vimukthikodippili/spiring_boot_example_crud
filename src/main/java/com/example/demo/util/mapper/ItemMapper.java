package com.example.demo.util.mapper;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.dto.ItemDTO;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Item;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    Item toItem(ItemDTO itemDTO);
    ItemDTO toItemDTO(Item item);
    List<ItemDTO> pageToItemDTO(Page<Item> item);
    List<Item > toItemAll(List<ItemDTO> itemDTOS);


}
