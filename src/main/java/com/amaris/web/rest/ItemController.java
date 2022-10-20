package com.amaris.web.rest;


import com.amaris.dto.request.ItemDto;
import com.amaris.entity.ItemEntity;
import com.amaris.service.impl.ItemService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/item")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping()
    public ResponseEntity<ItemDto> create(@RequestBody @Valid ItemDto itemDto) {
        itemService.createItem(itemDto);
        return ResponseEntity.ok(itemDto);
    }

    @PutMapping
    public ResponseEntity<ItemDto> update(@RequestBody @Valid ItemDto itemDto){
        itemService.updateItem(itemDto);
        return ResponseEntity.ok(itemDto);
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<ItemEntity> itemDtoList= itemService.getAll();
        return ResponseEntity.ok(itemDtoList);
    }

    @GetMapping("/paging")
    public ResponseEntity<?> getAll(@RequestParam(required = false, defaultValue = "0") int page,
                                    @RequestParam(required = false, defaultValue = "") int size,
                                    @RequestParam(required = false, defaultValue = "") String id,
                                    @RequestParam(required = false, defaultValue = "") String itemName,
                                    @RequestParam(required = false, defaultValue = "") String description
                                    ){
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<ItemEntity> itemEntities = itemService.getAll(id,itemName,description,pageRequest);
        return ResponseEntity.ok(itemEntities);
    }

}
