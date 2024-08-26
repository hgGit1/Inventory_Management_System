package com.ims.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ims.model.Inventory;

public interface ImsService {

	public List<Inventory> getInventory();

	public Inventory saveInventory(Inventory inventory);
	
	public int removeInventory(int id);
	
	public Inventory updateInventory(Inventory inventory);
	
	public Inventory findInventoryById(int inventoryId);
	
}
