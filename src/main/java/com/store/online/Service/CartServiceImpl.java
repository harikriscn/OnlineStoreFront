package com.store.online.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.online.store.Constants.StoreEnum;
import com.store.online.Dao.CartRepository;
import com.store.online.POJO.Cart;
import com.store.online.POJO.Product;
import com.store.online.POJO.ProductData;
import com.store.online.POJO.Rule;

import io.micrometer.core.instrument.util.StringUtils;

/**
 * @author Harikrishnan
 *
 */
@Component
public class CartServiceImpl implements CartService {
	
	Logger logger = LoggerFactory.getLogger(CartServiceImpl.class);
	
	@Autowired
	CartRepository cartRepository;
	
	private double totalPrice  = 0.0;
	
	private String key = null;

	@Override
	public Cart createCart(List<ProductData> productDataList) {
		logger.debug("createCart");
		Cart cart= cartRepository.createCart(productDataList);
		setCartTotalPrice(cart);
		return cart;
	}

	@Override
	public Cart getCart(Cart cart) {
		logger.debug("getCart");
		cart= cartRepository.getCart(cart);
		setCartTotalPrice(cart);
		return cart;
	}
	@Override
	public Cart modifyCart(int cartId) {
		logger.debug("modifyCart");
		return cartRepository.modifyCart(cartId);
	}
	
	private void setCartTotalPrice(Cart cart) {
		logger.debug("CartTotalPrice -- Method");
		totalPrice = 0.0;
		if(cart!= null && cart.getProductDataList().size()>0) {
			List<ProductData> prodDataList = cart.getProductDataList();
			List<Product> productList = new ArrayList<Product>();
			prodDataList.forEach(data->{
				productList.add(data.getProduct());
			});
			key = null;
			Map<String, Long> departments = productList.stream().collect(Collectors.groupingBy(Product::getDepartment,Collectors.counting()));
			
			departments.entrySet().stream().findAny().ifPresent(entry -> {
			      if(entry.getValue()>5) {
			    	  key = entry.getKey();
			    	  }
			});
			List<String> discounts = new ArrayList<String>();
			prodDataList.forEach(prodData-> {
				if(prodData != null && prodData.getProduct() != null) {
					if(prodData.getQty()>5) {
						double reducedPrice = prodData.getProduct().getCurrent_price()-(prodData.getProduct().getCurrent_price()/10);
						prodData.getProduct().setCurrent_price(reducedPrice);
						discounts.add(StoreEnum.SINGLE_ITEM_QTY_MORE_THAN_TEN.getEnumVal().toUpperCase());
					}
					if(StringUtils.isNotBlank(key) && key.equals(prodData.getProduct().getDepartment())) {
						double reducedPrice = prodData.getProduct().getCurrent_price()-(prodData.getProduct().getCurrent_price()/10);
						prodData.getProduct().setCurrent_price(reducedPrice);
						discounts.add(StoreEnum.SINGLE_ITEM_SAME_DEPARTMENT.getEnumVal().toUpperCase());
					}
					totalPrice = totalPrice + (prodData.getProduct().getCurrent_price()*prodData.getQty());
				}
			});
			if(totalPrice>50) {
				totalPrice-=5;
				discounts.add(StoreEnum.TOTAL_COST_MORE_THAN_FIFTY.getEnumVal().toUpperCase());
			}
			Rule rule = new Rule();
			rule.setDiscounts(discounts);
			cart.setRule(rule);
			cart.setTotalPrice(totalPrice);
		}
	}


}
