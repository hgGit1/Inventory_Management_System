package com.ims.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ims.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Integer>{

}
