/**
 * 
 */
package com.store.online.Dao;

import java.util.List;

import com.store.online.POJO.Cart;
import com.store.online.POJO.ProductData;

/**
 * @author Harikrishnan
 *
 */

public interface CartDAO {
	
	Cart createCart(List<ProductData> productDataList);
	Cart modifyCart(int cartId);
	Cart getCart(Cart cart);

}
