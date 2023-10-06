package com.example.medicineapp.repository;

import com.example.medicineapp.entity.ProductPreviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductPreviewRepository extends JpaRepository<ProductPreviewEntity, UUID> {

}
