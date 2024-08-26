package com.ims.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ims.model.InventoryQuantity;

public interface InventoryQuantityRepository extends JpaRepository<InventoryQuantity, Integer> {

}
