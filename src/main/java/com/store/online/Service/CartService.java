/**
 * 
 */
package com.store.online.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.store.online.POJO.Cart;
import com.store.online.POJO.ProductData;

/**
 * @author Harikrishnan
 *
 */
@Service
public interface CartService {

	public Cart createCart(List<ProductData> productDataList);

	public Cart modifyCart(int cartId);
	
	public Cart getCart(Cart cart);

}
