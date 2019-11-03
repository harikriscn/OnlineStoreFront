package com.store.online.POJO;

import java.util.List;

/**
 * @author Harikrishnan
 *
 */
public class Product {
	int product_id;
	String department;
	double current_price;
	String company;
	String product_title;
	String product_subtitle;
	String product_description;
	String attributes;
	String lifecycle_start;
	String lifecycle_end;
	String isbn;
	String color;
	boolean active;
	List<Integer> like_products;

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getCurrent_price() {
		return current_price;
	}

	public void setCurrent_price(double current_price) {
		this.current_price = current_price;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getProduct_title() {
		return product_title;
	}

	public void setProduct_title(String product_title) {
		this.product_title = product_title;
	}

	public String getProduct_subtitle() {
		return product_subtitle;
	}

	public void setProduct_subtitle(String product_subtitle) {
		this.product_subtitle = product_subtitle;
	}

	public String getProduct_description() {
		return product_description;
	}

	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}

	public String getAttributes() {
		return attributes;
	}

	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}

	public String getLifecycle_start() {
		return lifecycle_start;
	}

	public void setLifecycle_start(String lifecycle_start) {
		this.lifecycle_start = lifecycle_start;
	}

	public String getLifecycle_end() {
		return lifecycle_end;
	}

	public void setLifecycle_end(String lifecycle_end) {
		this.lifecycle_end = lifecycle_end;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<Integer> getLike_products() {
		return like_products;
	}

	public void setLike_products(List<Integer> like_products) {
		this.like_products = like_products;
	}

	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", department=" + department + ", current_price=" + current_price
				+ ", company=" + company + ", product_title=" + product_title + ", product_subtitle=" + product_subtitle
				+ ", product_description=" + product_description + ", attributes=" + attributes + ", lifecycle_start="
				+ lifecycle_start + ", lifecycle_end=" + lifecycle_end + ", isbn=" + isbn + ", color=" + color
				+ ", active=" + active + ", like_products=" + like_products + "]";
	}

}
