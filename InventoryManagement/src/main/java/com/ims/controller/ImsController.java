package com.ims.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ims.model.Inventory;
import com.ims.service.ImsService;
import com.ims.service.ImsServiceImpl;
import com.ims.service.UserService;

import jakarta.persistence.PostUpdate;

@RestController
@RequestMapping("/ims")
public class ImsController {
	
	@Autowired
	private ImsService imsService;
	
	@GetMapping("/showAllInventory") //Admin,Support,ImsUser has access
	public ResponseEntity<?> showAllInventory(){
		
		List<Inventory> allInventory = imsService.getInventory();
		if(allInventory!=null && !allInventory.isEmpty()) {
			return new ResponseEntity<>(allInventory, HttpStatus.OK);
		}
		return new ResponseEntity<>(allInventory, HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/save-inventory") //Support and Admin has access
	public ResponseEntity<?> saveInventory(@RequestBody Inventory inventory){
		
		Inventory product = imsService.saveInventory(inventory);
		if(product!=null) {
			return new ResponseEntity<>(product, HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
	}
	
	@DeleteMapping("/remove/{id}")//Support and Admin has access
	public ResponseEntity<?> removeInventory(@PathVariable int id){
		
		int deletedId = imsService.removeInventory(id);
		if(deletedId!=0) {
			return new ResponseEntity<>(deletedId, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(id, HttpStatus.BAD_REQUEST);
		
	}
	
	@PutMapping("/update")//Admin and support has access
	public ResponseEntity<?> updateInventory(@RequestBody Inventory inventory){
		
		Inventory product = imsService.updateInventory(inventory);
		if(product!=null) {
			return new ResponseEntity<>(product, HttpStatus.CREATED);
		}
		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
	}
	
	@GetMapping("/findById/{inventoryId}")//Admin, Support and ImsUser has access
	public ResponseEntity<?> getInventoryById(@PathVariable int inventoryId){
		
		Inventory invent = imsService.findInventoryById(inventoryId);
		
		if(invent!=null) {
			return new ResponseEntity<>(invent, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		
		
	}
	

}
