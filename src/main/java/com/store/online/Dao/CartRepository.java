/**
 * 
 */
package com.store.online.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.store.online.Controller.CartController;
import com.store.online.Mapper.CartRowMapper;
import com.store.online.POJO.Cart;
import com.store.online.POJO.CartDetail;
import com.store.online.POJO.Product;
import com.store.online.POJO.ProductData;
import com.store.online.Service.QueryService;

/**
 * @author Harikrishnan
 *
 */
@Repository
public class CartRepository implements CartDAO {
	
	Logger logger = LoggerFactory.getLogger(CartRepository.class);
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	CartRowMapper cartRowMapper;
	
	@Autowired
	QueryService queryService;
	
	int cart_id = 0;

	@Override
	public Cart createCart(List<ProductData> productDataList) {
		logger.debug("createCart");
		Cart cart = new Cart();
		LocalDate localDate = LocalDate.now();
		List<ProductData> productDatareturnList = new ArrayList<ProductData>();
		
		int update = jdbcTemplate.update(queryService.getCartTableInsertQuery(), new Object[] { localDate,localDate });
		if(update>0) {
			logger.debug("Cart data created");
			cart_id = jdbcTemplate.query(queryService.getCartTableSelectQuery(), new RowMapper<Integer>() {
				@Override
				public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
					return rs.getInt("cart_id");
				}
			}).get(0);
		}
		logger.debug("cart_id" +cart_id);
		productDataList.forEach(prodData-> {
			if(prodData.getProduct()!=null) {
				jdbcTemplate.update(queryService.getCartDetailTableInsertQuery(),
						new Object[] { cart_id, prodData.getProduct().getProduct_id(),prodData.getQty(), localDate });
				logger.debug("Cart detail table data created");
				Product product = productRepository.fetchProductsById(prodData.getProduct().getProduct_id());
				prodData.setProduct(product);
				productDatareturnList.add(prodData);
			}
		});
		cart.setCartId(cart_id);
		cart.setProductDataList(productDatareturnList);
		logger.debug("Cart object populated");
		return cart;
	}

	@Override
	public Cart modifyCart(int cartId) {
		logger.debug("modifyCart" +cartId);
		Cart cart = new Cart();
		logger.debug("cart_id" +cart.getCartId());
		return cart;
	}
	@Override
	public Cart getCart(Cart cart) {
		logger.debug("getCart");
		List<ProductData> productDatareturnList = new ArrayList<ProductData>();
		logger.debug("cart_id" +cart.getCartId());
		//Cart data
		List<CartDetail> cartDetailList = jdbcTemplate.query(queryService.getCartTableSelectQueryWithId(), new Object[] { cart.getCartId() }, cartRowMapper);
		if(cartDetailList.size()>0) {
			logger.debug("Cart data fetched successfully");
			cartDetailList.forEach(cartDetail ->{
				ProductData prodData = new ProductData();
				Product product = productRepository.fetchProductsById(cartDetail.getProduct_id());
				prodData.setProduct(product);
				prodData.setQty(cartDetail.getQuantity());
				productDatareturnList.add(prodData);
			});
		}
		
		cart.setProductDataList(productDatareturnList);
		logger.debug("Cart object populated");
		return cart;
	}

}
