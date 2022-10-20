package com.amaris.service.mapper;

import com.amaris.dto.request.CatalogDto;
import com.amaris.dto.request.ItemDto;
import com.amaris.entity.AccountEntity;
import com.amaris.entity.CatalogEntity;
import com.amaris.entity.ItemEntity;
import org.mapstruct.Mapper;

import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    default ItemEntity toEntity(ItemDto itemDto) {
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setId(itemDto.getId());
        itemEntity.setItemName(itemDto.getItemName());
        itemEntity.setDescription(itemDto.getDescription());
        itemEntity.setNumberof(itemDto.getNumberof());
        CatalogEntity catalog = new CatalogEntity();
        catalog.setId(itemDto.getCatalogId());
        AccountEntity account = new AccountEntity();
        account.setId(itemDto.getAccountId());
        itemEntity.setCatalog(catalog);
        itemEntity.setAccount(account);
        return  itemEntity;
    }
    ItemDto toDto(ItemEntity itemEntity);
    List<ItemDto> toDtoList(List<ItemEntity> itemEntities);

}
