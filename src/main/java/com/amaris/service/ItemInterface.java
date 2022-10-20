package com.amaris.service;


import com.amaris.dto.request.ItemDto;
import com.amaris.entity.ItemEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemInterface {
    ItemDto createItem(ItemDto itemDto);
    Page<ItemEntity> getAll(String itemId, String itemName, String description, Pageable page);
    List<ItemEntity> getAll();
    ItemDto updateItem(ItemDto itemDto);
}
