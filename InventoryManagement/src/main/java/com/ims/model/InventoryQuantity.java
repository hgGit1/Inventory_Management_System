package com.ims.model;

import com.ims.model.Inventory.catogoryEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="INVENTORY_QUANTITY")
public class InventoryQuantity {
	@Id
	@Column(name="IQ_ID")
	private int id;
	
	@Column(name="INVENTORY_Name")
	private String inventoryName;
	
	@Enumerated(EnumType.STRING)
	@Column(name="CATEGORY")
	private catogoryEnum category;
	
	@Column(name="QUANTITY_LEFT")
	private Long quantity;

	public String getInventoryName() {
		return inventoryName;
	}

	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
	}

	public catogoryEnum getCategory() {
		return category;
	}

	public void setCategory(catogoryEnum category) {
		this.category = category;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public InventoryQuantity(String inventoryName, catogoryEnum category, Long quantity) {
		super();
		this.inventoryName = inventoryName;
		this.category = category;
		this.quantity = quantity;
	}

	public InventoryQuantity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	

}
