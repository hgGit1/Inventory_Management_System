package com.ims.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ims.model.Inventory;
import com.ims.model.InventoryQuantity;

import jakarta.persistence.NamedQuery;

public interface InventoryRepository extends JpaRepository<Inventory, Integer>{
	
	@Query("Select i.name, i.category, COUNT(i) from Inventory i GROUP BY i.name, i.category")
//	@Query("Select new  com.ims.model.InventoryQuantity(i.name, i.category, COUNT(i)) from Inventory i GROUP BY i.name, i.category")
	List<Object[]> findInventoryQuantity();

}
