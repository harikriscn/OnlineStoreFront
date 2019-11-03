/**
 * 
 */
package com.store.online.POJO;

/**
 * @author Harikrishnan
 *
 */
public class CartDetail {
	
	int cart_detail_id;
	int cart_id;
	int product_id;
	int quantity;
	String created_date;
	String modified_date;
	
	public int getCart_detail_id() {
		return cart_detail_id;
	}
	public void setCart_detail_id(int cart_detail_id) {
		this.cart_detail_id = cart_detail_id;
	}
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getCreated_date() {
		return created_date;
	}
	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}
	public String getModified_date() {
		return modified_date;
	}
	public void setModified_date(String modified_date) {
		this.modified_date = modified_date;
	}
	
	

}
