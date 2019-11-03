/**
 * 
 */
package com.store.online.POJO;

import java.util.List;

/**
 * @author Harikrishnan
 *
 */
public class Cart {

	int cartId;
	double totalPrice;
	List<ProductData> productDataList;
	Rule rule;

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<ProductData> getProductDataList() {
		return productDataList;
	}

	public void setProductDataList(List<ProductData> productDataList) {
		this.productDataList = productDataList;
	}

	public Rule getRule() {
		return rule;
	}

	public void setRule(Rule rule) {
		this.rule = rule;
	}

}
