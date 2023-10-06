package com.example.medicineapp.service.Impl;

import com.example.medicineapp.dto.request.CartItemRequestDto;
import com.example.medicineapp.dto.request.CartRequestDto;
import com.example.medicineapp.dto.request.search.CartSearchDto;
import com.example.medicineapp.dto.response.CartResponseDto;
import com.example.medicineapp.entity.CartEntity;
import com.example.medicineapp.entity.CartItemEntity;
import com.example.medicineapp.entity.CustomerEntity;
import com.example.medicineapp.exception.MedicineRuntimeException;
import com.example.medicineapp.repository.CartRepository;
import com.example.medicineapp.repository.CustomerRepository;
import com.example.medicineapp.service.CartService;
import com.example.medicineapp.service.mapper.CartResponseMapper;
import com.example.medicineapp.utilities.PageUtil;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartResponseMapper cartMapper;
    private final CustomerRepository customerRepo;

    private final CartRepository cartRepo;
    private final EntityManager manager;

    @Override
    public CartResponseDto createBy(@NonNull CartRequestDto dto) {
        CartEntity entity = new CartEntity();
        this.setValue(entity, dto);
        return cartMapper.entityToResponseDto(entity);
    }

    private void setValue(CartEntity entity, CartRequestDto dto){
        entity.setContent(dto.getContent());
        entity.setStatus(dto.getStatus());
        if (Objects.nonNull(dto)) {
            boolean isExistCustomer = customerRepo.existsById(dto.getCustomer().getId());
            if (Objects.nonNull(dto.getCustomer()) && isExistCustomer) {
                CustomerEntity customer = customerRepo.getById(dto.getCustomer().getId());
                entity.setCustomerEntity(customer);
            }
        }
        entity.setCartItems(setListCartItem(dto));
        entity.setQuantity(dto.getQuantity());

    }

    private List<CartItemEntity> setListCartItem (CartRequestDto dto){
        List<CartItemEntity> cartItemEntities = new ArrayList<>();
        for (CartItemRequestDto cartItem : dto.getCartItems()){
            CartItemEntity cartItemEntity = new CartItemEntity();
            cartItemEntity.setCart(cartItemEntity.getCart());
            cartItemEntity.setContent(cartItem.getContent());
            cartItemEntity.setSku(cartItem.getSku());
            cartItemEntity.setPrice(cartItem.getPrice());
            cartItemEntity.setDiscount(cartItem.getDiscount());
            cartItemEntity.setIsActive(cartItem.getIsActive());
            cartItemEntities.add(cartItemEntity);
        }
        return cartItemEntities;
    }

    @Override
    public Page<CartResponseDto> searchBy(CartSearchDto searchDto) {

        StringBuilder sql = new StringBuilder(" SELECT entity FROM CartEntity entity WHERE (1=1) " );
        StringBuilder sqlCount = new StringBuilder(" SELECT COUNT(entity) FROM CartEntity WHERE (1=1) ");
        this.setWhereClause(sql, sqlCount, searchDto);
        sql.append(" ORDER BY entity.createDate ");
        Query query = manager.createQuery(sql.toString());
        Query qCount = manager.createQuery(sqlCount.toString());
        this.setParameter(query, qCount, searchDto);

        List<CartEntity> cartEntities = PageUtil.getContent(searchDto, query);
        List<CartResponseDto> cartResponseDtos = cartEntities.stream().map(cartMapper::entityToResponseDto).collect(Collectors.toList());

        return PageUtil.getPage(cartResponseDtos, searchDto ,query);
    }

    private void setWhereClause(StringBuilder sql, StringBuilder sqlCount, CartSearchDto searchDto){

        if(Objects.nonNull(searchDto.getKeyword())){

            sql.append("AND ( entity.status LIKE :keyword " +
                    "           OR entity.content LIKE :keyword " +
                    "           OR entity.quantity = :keyword " +
                    "           OR entity.customer.name LIKE :keyword " +
                    "       ) ");
            sqlCount.append("AND ( entity.status LIKE :keyword " +
                    "           OR entity.content LIKE :keyword " +
                    "           OR entity.quantity = :keyword " +
                    "           OR entity.customer.lastName LIKE :keyword " +
                    "       ) ");
        }

        if(Objects.nonNull(searchDto.getContent())){
            sql.append(" AND ( entity.content = :content )");
            sqlCount.append(" AND ( entity.content = :content )");
        }
    }

    private void setParameter(Query query, Query qCount, CartSearchDto searchDto){
        if (Objects.nonNull(searchDto.getKeyword())) {
            query.setParameter("keyword", searchDto.getKeyword());
            qCount.setParameter("keyword", searchDto.getKeyword());
        }

        if (Objects.nonNull(searchDto.getContent())) {
            query.setParameter("content", searchDto.getContent());
            qCount.setParameter("content", searchDto.getContent());
        }
    }
    @Override
    public CartResponseDto updateBy(@NonNull UUID id, @NonNull CartRequestDto dto) {

        boolean isExistCustomer = customerRepo.existsById(dto.getCustomer().getId());
        boolean isExitsCart = cartRepo.isExistInCart(id);

        if(!isExitsCart){
            throw new MedicineRuntimeException(500, "not.found_entity");
        }

        if (!isExistCustomer) {
            throw new MedicineRuntimeException(500, "not.found_entity");
        }
        CartEntity entity = cartRepo.getById(id);
        this.setValue(entity, dto);

        return cartMapper.entityToResponseDto(entity);
    }

    @Override
    public Boolean deleteBy(@NonNull UUID id) {
        boolean isExitsCart = cartRepo.isExistInCart(id);
        if (!isExitsCart) {
            throw new MedicineRuntimeException(500, "not.found_entity");
        }
        cartRepo.deleteById(id);
        return true;
    }

    @Override
    public Boolean deleteAll(List<UUID> idList) {
        return null;
    }
}
