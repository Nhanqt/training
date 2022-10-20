package com.amaris.service.impl;

import com.amaris.dto.request.ItemDto;
import com.amaris.entity.ItemEntity;
import com.amaris.repository.ItemRepository;
import com.amaris.service.ItemInterface;
import com.amaris.service.mapper.ItemMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService implements ItemInterface {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    public ItemService(ItemRepository itemRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    @Override
    public ItemDto createItem(ItemDto itemDto) {
        ItemEntity item = itemMapper.toEntity(itemDto);

        ItemEntity itemEntity = itemRepository.save(item);

        return itemMapper.toDto(itemEntity);
    }

    @Override
    public Page<ItemEntity> getAll(String itemId, String itemName, String description, Pageable page) {

        return itemRepository.findAll(page);
    }

    @Override
    public List<ItemEntity> getAll() {
        return itemRepository.findAll();
    }

    @Override
    public ItemDto updateItem(ItemDto itemDto) {
        ItemEntity item = itemMapper.toEntity(itemDto);

        ItemEntity itemEntity = itemRepository.save(item);

        return itemMapper.toDto(itemEntity);
    }
}
