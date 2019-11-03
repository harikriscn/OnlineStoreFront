package com.store.online.Dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.store.online.Mapper.ProductRowMapper;
import com.store.online.POJO.Product;
import com.store.online.Service.QueryService;

/**
 * @author Harikrishnan
 *
 */
@Repository
public class ProductRepository implements ProductDAO{
	
	Logger logger = LoggerFactory.getLogger(ProductRepository.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	ProductRowMapper productRowMapper;
	
	@Autowired
	QueryService queryService;

	@Override
	public boolean addProducts(Product product){
		logger.debug("Repository --addProducts");
		boolean retVal = false;
		String like_Products = "";
		for(int prod : product.getLike_products()) {
			 
			like_Products += prod+" ";
		}
		int update = jdbcTemplate.update(queryService.getProductTableInsertQuery(), 
				new Object[] {product.getDepartment(), product.getCurrent_price(),product.getCompany(),
				           product.getProduct_title(),product.getProduct_subtitle(), product.getProduct_description(),
				           product.getAttributes(),product.getLifecycle_start(),product.getLifecycle_end(),product.getIsbn(),
				           product.getColor(),product.isActive()?"Yes":"No", like_Products.trim()});
		logger.debug("Product added to Database successfully");
		if(update>0) {
			retVal = true;
		}
		return retVal;
	}

	@Override
	public boolean updateProduct(Product product) {
		logger.debug("Repository --updateProduct");
		
		boolean retVal = false;
		String updateQuery =  queryService.getProductTableUpdateQuery(); 
				
		int update = jdbcTemplate.update(updateQuery, 
				new Object[] {product.getCurrent_price(),product.getProduct_id()});
		if(update>0) {
			retVal = true;
		}
		return retVal;
	}

	@Override
	public boolean deleteProduct(int product_id) {
		logger.debug("Repository --deleteProduct");
		
		boolean retVal = false;
		int update = jdbcTemplate.update(queryService.getProductTableDeleteQueryWithId(), 
				new Object[] {product_id});
		if(update>0) {
			retVal = true;
		}
		return retVal;
	}

	@Override
	public List<Product> fetchProducts(Product product) {
		logger.debug("Repository --fetchProducts");
		
		String sql = queryService.getProductTableSelectQuery();
		
		logger.debug("fetchquery "+ sql);
		List<Product> products = (List<Product>) jdbcTemplate.query(sql,   new Object[] {product.getDepartment(), product.getCompany(), product.getProduct_title()},
				productRowMapper);
		
		logger.debug("FetchedProducts from the repository!!");
		return products;
	}

	public Product fetchProductsById(int product_id) {
		logger.debug("Repository --fetchProductsById");
		
		String sql = queryService.getProductTableSelectQueryWithId();
		logger.debug("fetchquery "+ sql);
		List<Product> products = (List<Product>) jdbcTemplate.query(sql,  new Object[] {product_id},productRowMapper);
		
		logger.debug("FetchedProducts from the repository!!");
		return products.get(0);
		
	}

}
