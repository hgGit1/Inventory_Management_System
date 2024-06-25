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
@Table(name = "Inventory_Detail")
public class Inventory {
	
//	private static final String Mens = "Mens";
//	private static final String Ladies = "Ladies";
	
	public enum catogoryEnum{
		Mens, Ladies, Kids
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="INVENTORY_ID")
	private int inventoryId;
	
	@Enumerated(EnumType.STRING)
	@Column(name="CATEGORY")
	private catogoryEnum category;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="BRAND")
	private String brand;
	
	@Column(name="PRICE")
	private int price;
	
	public int getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}
	public catogoryEnum getCategory() {
		return category;
	}
	public void setCategory(catogoryEnum category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Inventory(int inventoryId, catogoryEnum category, String name, String brand, int price) {
		super();
		this.inventoryId = inventoryId;
		this.category = category;
		this.name = name;
		this.brand = brand;
		this.price = price;
	}
	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Inventory [inventoryId=" + inventoryId + ", category=" + category + ", name=" + name + ", brand="
				+ brand + ", price=" + price + "]";
	}
	
	

}
