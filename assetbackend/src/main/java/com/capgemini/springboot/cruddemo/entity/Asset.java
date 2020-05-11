package com.capgemini.springboot.cruddemo.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "assets")
@Data
public class Asset {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer asset_id;

	@Column
	private String title;

	@Column
	private String category;

	@Column
	private Integer quantity;
	
	@Column
	private Integer price;
	
	@Column
	private Integer total_price;
	
	@Column
	private String Details;

	public Integer getAsset_id() {
		return asset_id;
	}

	public void setAsset_id(Integer asset_id) {
		this.asset_id = asset_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getTotal_price() {
		return total_price;
	}

	public void setTotal_price(Integer total_price) {
		this.total_price = total_price;
	}

	public String getDetails() {
		return Details;
	}

	public void setDetails(String details) {
		Details = details;
	}

	@Override
	public String toString() {
		return "Product [asset_id=" + asset_id + ", title=" + title + ", category=" + category + ", quantity="
				+ quantity + ", price=" + price + ", total_price=" + total_price + ", Details=" + Details + "]";
	}
	
	

	

	

	

	
}
