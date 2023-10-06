package com.example.medicineapp.service.Impl;

import com.example.medicineapp.dto.request.CategoryRequestDto;
import com.example.medicineapp.dto.request.ProductRequestDto;
import com.example.medicineapp.dto.request.search.CategorySearchDto;
import com.example.medicineapp.dto.response.CategoryResponseDto;
import com.example.medicineapp.entity.CategoryEntity;
import com.example.medicineapp.entity.ProductEntity;
import com.example.medicineapp.exception.MedicineRuntimeException;
import com.example.medicineapp.repository.CategoryRepository;
import com.example.medicineapp.service.CategorySevice;
import com.example.medicineapp.service.mapper.CategoryResponseMapper;
import com.example.medicineapp.utilities.PageUtil;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategorySevice {

    private final CategoryResponseMapper categoryMapper;
    private final EntityManager manager;
    private final CategoryRepository categoryRepo;

    @Override
    public CategoryResponseDto createBy(@NonNull CategoryRequestDto categoryRequestDto) {
        CategoryEntity entity = new CategoryEntity();
        this.setValue(entity, categoryRequestDto);
        return categoryMapper.entityToRespone(entity);
    }

    private void setValue(CategoryEntity entity, CategoryRequestDto dto){

        entity.setTitle(dto.getTitle());
        entity.setContent(dto.getContent());
        entity.setSlug(dto.getSlug());
        entity.setMetaTitle(dto.getMetaTitle());

        List<ProductEntity> productList = new ArrayList<>();
        for(ProductRequestDto productDto : dto.getProductList()){
            ProductEntity productEntity = new ProductEntity();
            setValueProduct(productEntity, productDto);
        }
        entity.setProductList(productList);

    }

    public void setValueProduct(ProductEntity entity, ProductRequestDto dto){
        entity.setTitle(dto.getTitle());
        entity.setMetaTile(dto.getMetaTile());
        entity.setSlug(dto.getSlug());
        entity.setSummary(dto.getSummary());
        entity.setType(dto.getType());
        entity.setSku(dto.getSku());
        entity.setPrice(dto.getPrice());
        entity.setDiscount(dto.getDiscount());
        entity.setQuanity(dto.getQuanity());
        entity.setShop(dto.isShop());
        entity.setPublishAt(dto.getPublishAt());
        entity.setStartAt(dto.getStartAt());
        entity.setEndAt(dto.getEndAt());
        entity.setContent(dto.getContent());
    }

    @Override
    public Page<CategoryResponseDto> searchBy(CategorySearchDto searchDto) {
        StringBuilder sql = new StringBuilder(" SELECT entity FROM CategoryEntity entity WHERE (1=1) ");
        StringBuilder sqlCount = new StringBuilder(" SELECT COUNT(entity) FROM CategoryEntity WHERE (1=1) ");
        this.genWhereClause(sql, sqlCount, searchDto);
        sql.append(" ORDER BY entity.title ");

        Query query = manager.createQuery(sql.toString(), CategoryEntity.class);
        Query queryCount = manager.createQuery(sqlCount.toString());
        this.setParameter(query, queryCount, searchDto);

        List<CategoryEntity> categoryEntities = PageUtil.getContent(searchDto, query);

        List<CategoryResponseDto> categoryResponseDtos = categoryEntities.stream().map(categoryMapper::entityToRespone).collect(Collectors.toList());
        return PageUtil.getPage(categoryResponseDtos, searchDto, query);
    }

    private void genWhereClause(StringBuilder sql, StringBuilder sqlCount, CategorySearchDto searchDto){
        if(!StringUtils.isEmpty(searchDto.getKeyword())){
            sql.append(" AND ( LOWER(entity.title) = :keyword ")
                    .append(" LOWER(entity.metaTitle = :keyword ")
                    .append(" LOWER(entity.slug) = :keyword ")
                    .append(" LOWER(entity.content) = :keyword ")
                    .append(" ) ");

            sqlCount.append(" AND ( LOWER(entity.title) = :keyword ")
                    .append(" LOWER(entity.metaTitle = :keyword ")
                    .append(" LOWER(entity.slug) = :keyword ")
                    .append(" LOWER(entity.content) = :keyword ")
                    .append(" ) ");
        }
        if(!StringUtils.isEmpty(searchDto.getTitle())){
            sql.append(" AND LOWER(entity.title) = :title ");
            sqlCount.append(" AND LOWER(entity.title) = :title ");
        }
        if (!StringUtils.isEmpty(searchDto.getMetaTitle())) {
            sql.append(" AND LOWER(entity.metaTitle) = :metaTitle ");
            sqlCount.append(" AND LOWER(entity.metaTitle) = :metaTitle ");
        }
        if (!StringUtils.isEmpty(searchDto.getSlug())) {
            sql.append(" AND LOWER(entity.slug) = :slug ");
            sqlCount.append(" AND LOWER(entity.slug) = :slug ");
        }
        if (!StringUtils.isEmpty(searchDto.getContent())) {
            sql.append(" AND LOWER(entity.content) = :content ");
            sqlCount.append(" AND LOWER(entity.content) = :content ");
        }

    }

    private void setParameter(Query query, Query queryCount, CategorySearchDto searchDto){
        if (!StringUtils.isEmpty(searchDto.getKeyword())) {
           query.setParameter("keyword", searchDto.getKeyword());
           queryCount.setParameter("keyword", searchDto.getKeyword());
        }
        if (!StringUtils.isEmpty(searchDto.getTitle())) {
            query.setParameter("title", searchDto.getTitle());
            queryCount.setParameter("title", searchDto.getTitle());
        }
        if (!StringUtils.isEmpty(searchDto.getMetaTitle())) {
            query.setParameter("metaTitle", searchDto.getMetaTitle());
            queryCount.setParameter("metaTitle", searchDto.getMetaTitle());
        }
        if (!StringUtils.isEmpty(searchDto.getSlug())) {
            query.setParameter("slug", searchDto.getSlug());
            queryCount.setParameter("slug", searchDto.getSlug());
        }
        if (!StringUtils.isEmpty(searchDto.getContent())) {
            query.setParameter("content", searchDto.getContent());
            queryCount.setParameter("content", searchDto.getContent());
        }
    }
    @Override
    public CategoryResponseDto updateBy(@NonNull UUID id, @NonNull CategoryRequestDto categoryRequestDto) {

        CategoryEntity entity = new CategoryEntity();
        this.setValueSaveOrUpdate(id, categoryRequestDto, entity);
        return categoryMapper.entityToRespone(entity);
    }

    private void setValueSaveOrUpdate(UUID id, CategoryRequestDto dto, CategoryEntity entity){
        if(Objects.nonNull(id)){
            entity = categoryRepo.getById(id);
        }
        entity.setTitle(dto.getTitle());
        entity.setContent(dto.getContent());
        entity.setSlug(dto.getSlug());
        entity.setMetaTitle(dto.getMetaTitle());

        List<ProductEntity> productList = new ArrayList<>();
        for (ProductRequestDto productDto : dto.getProductList()) {
            ProductEntity productEntity = new ProductEntity();
            setValueProduct(productEntity, productDto);
        }
        entity.setProductList(productList);
    }

    @Override
    public Boolean deleteBy(@NonNull UUID id) {
        if(Objects.nonNull(id) && checkExistInCategory(id)){
            categoryRepo.deleteById(id);
            return true;
        }
        return false;
    }

    private boolean checkExistInCategory(UUID id) {
        if(Objects.nonNull(id)){
            return categoryRepo.existsById(id);
        }
        throw new MedicineRuntimeException(10000, "entity.not found ");
    }

    @Override
    public Boolean deleteAll(List<UUID> idList) {
        return null;
    }
}
