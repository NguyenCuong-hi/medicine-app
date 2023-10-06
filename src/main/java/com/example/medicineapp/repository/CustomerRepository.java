package com.example.medicineapp.repository;

import com.example.medicineapp.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, UUID> {

    @Query (value = " SELECT CASE WHEN EXISTS " +
            "( SELECT 1 FROM tbl_customers WHERE id =:id )" +
            " THEN 'TRUE' ELSE  'FALSE' ", nativeQuery = true)
    boolean existsById(UUID id);
}
