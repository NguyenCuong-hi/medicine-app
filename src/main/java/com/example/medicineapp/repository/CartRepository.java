package com.example.medicineapp.repository;

import com.example.medicineapp.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, UUID> {

    @Query(value = "SELECT CASE WHEN (SELECT 1 FROM tbl_cart WHERE id = :id ) THEN 'TRUE' ELSE 'FALSE' END ", nativeQuery = true)
    boolean isExistInCart(UUID id);
}
