/**
 * 
 */
package com.store.online.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.online.POJO.Cart;
import com.store.online.POJO.Product;
import com.store.online.POJO.ProductData;
import com.store.online.Service.CartService;

/**
 * @author Harikrishnan
 *
 */
@RestController
@RequestMapping("/v1/cart")
public class CartController {
	
	Logger logger = LoggerFactory.getLogger(CartController.class);
	
	@Autowired
	CartService cartService;
	
	/**
	 *  Adding cart in to the repository
	 * @param productDataList
	 * @return
	 */
	@GetMapping(path = "/getCart", produces = "application/json")
	public Cart getCart(@RequestBody Cart cart) {
		logger.debug("Get Cart Controller");
		return cartService.getCart(cart);
	}
	
	
	/**
	 *  Adding cart in to the repository
	 * @param productDataList
	 * @return
	 */
	@PostMapping(path = "/createCart", consumes = "application/json")
	public Cart createCart(@RequestBody List<ProductData> productDataList) {
		logger.debug("Create Cart Controller");
		return cartService.createCart(productDataList);
	}
	
	/**
	 * Modify the cart details and returning the modified cart
	 * @param cart
	 * @return
	 */
	@PostMapping("/modifyCart")
	public Cart modifyCart(@RequestBody Cart cart) {
		logger.debug("Modify Cart Controller");
		return cartService.modifyCart(cart.getCartId());
	}

}
