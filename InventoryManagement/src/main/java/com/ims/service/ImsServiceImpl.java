package com.ims.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ims.model.Inventory;
import com.ims.model.Inventory.catogoryEnum;
import com.ims.repository.InventoryRepository;

@Service
public class ImsServiceImpl implements ImsService{
	
	@Autowired
	public InventoryRepository inventoryRepository;
	
	
//	List<Inventory> inventoryList = new ArrayList<>(Arrays.asList(
//			new Inventory(1, catogoryEnum.Mens, "Jeans", "Peter", 1500),
//			new Inventory(2, catogoryEnum.Ladies, "Top", "H&M", 1799)
//			));

	@Override
	public List<Inventory> getInventory() {
		// TODO Auto-generated method stub
		List<Inventory> inventoryList = inventoryRepository.findAll();
		return inventoryList;
	}

	@Override
	public Inventory saveInventory(Inventory inventory) {
		// TODO Auto-generated method stub
		try {
			inventoryRepository.save(inventory);
			return inventory;
		} catch(Exception e) {
			System.out.println("Throwing error in saving data in db: "+e);
		}
		return null;
		
	}

	@Override
	public int removeInventory(int id) {
		// TODO Auto-generated method stub
		try {
			inventoryRepository.deleteById(id);
			return id;
		} catch(Exception e) {
			System.out.println("Trowing error in deleting data from Repository:"+e);
		}
		
		return 0;
	}

	@Override
	public Inventory updateInventory(Inventory inventory) {
		int id = inventory.getInventoryId();
		try {
			Optional<Inventory> invent = inventoryRepository.findById(id);
			if(invent.isPresent()) {
				if(inventory.getBrand()!=invent.get().getBrand()) {
					invent.get().setBrand(inventory.getBrand());
				}
				
				if(inventory.getCategory()!=invent.get().getCategory()) {
					invent.get().setCategory(inventory.getCategory());
				}
				
				if(inventory.getName()!=invent.get().getName()) {
					invent.get().setName(inventory.getName());
				}
				
				if(inventory.getPrice()!=invent.get().getPrice()) {
					invent.get().setPrice(inventory.getPrice());
				}
				
				inventoryRepository.save(invent.get());
				return invent.get();
			}
			
		} catch(Exception e) {
			System.out.println("Throwing error in updating the record: "+e);
		}
		
		
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
