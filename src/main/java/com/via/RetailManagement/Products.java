package com.via.RetailManagement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Products {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int pId;
	
	String title;
	String category;
	int prices;
	
	public Products() {}

	public Products(String title, String category, int prices) {
		super();
		this.title = title;
		this.category = category;
		this.prices = prices;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
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

	public int getPrices() {
		return prices;
	}

	public void setPrices(int prices) {
		this.prices = prices;
	}

	@Override
	public String toString() {
		return "Products [pId=" + pId + ", title=" + title + ", category=" + category + ", prices=" + prices + "]";
	}

	
	
	
}
