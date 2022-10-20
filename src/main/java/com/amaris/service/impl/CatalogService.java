package com.amaris.service.impl;

import com.amaris.dto.request.CatalogDto;
import com.amaris.entity.AccountEntity;
import com.amaris.entity.CatalogEntity;
import com.amaris.exception.exceptions.NotAllowException;
import com.amaris.repository.CatalogRepository;
import com.amaris.service.CatalogInterface;
import com.amaris.service.mapper.CatalogMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.webjars.NotFoundException;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class CatalogService implements CatalogInterface {

    private final CatalogRepository catalogRepository;
    private final CatalogMapper catalogMapper;

    public CatalogService(CatalogRepository catalogRepository, CatalogMapper catalogMapper) {
        this.catalogRepository = catalogRepository;
        this.catalogMapper = catalogMapper;
    }

    @Override
    public CatalogDto createCatalog(CatalogDto catalogDto) {
        validCreateCatalog(catalogDto.getId());
        catalogDto.setCreatedDate(LocalDateTime.now());
        CatalogEntity catalog = catalogMapper.toEntity(catalogDto);
        CatalogEntity catalogEntity = catalogRepository.save(catalog);
        return catalogMapper.toDto(catalogEntity);
    }

    public void validCreateCatalog(String catalogId){
      catalogRepository.findById(catalogId).ifPresent(catalogEntity -> {
          throw new NotAllowException("is existed");
      });
    }

    @Override
    public Page<CatalogDto> getAll(Long catalogId, String catalogName, String description) {
        return null;
    }

    @Override
    public List<CatalogDto> getAll() {
        List<CatalogEntity> catalogEntities = catalogRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        return catalogMapper.toDtoList(catalogEntities);
    }

    @Override
    public CatalogDto updateCatalog(CatalogDto catalogDto) {
        catalogDto.setUpdatedDate(LocalDateTime.now());
        CatalogEntity catalog = catalogMapper.toEntity(catalogDto);

        CatalogEntity catalogEntity = catalogRepository.save(catalog);

        return catalogMapper.toDto(catalogEntity);
    }
}
