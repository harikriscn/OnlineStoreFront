/**
 * 
 */
package com.store.online.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.store.online.Dao.CartRepository;
import com.store.online.POJO.Product;

/**
 * @author Harikrishnan
 *
 */
@Component
public class ProductRowMapper implements ResultSetExtractor<List<Product>> {

	Logger logger = LoggerFactory.getLogger(ProductRowMapper.class);
	
	@Override
	public List<Product> extractData(ResultSet rs) throws SQLException, DataAccessException {
		logger.debug("ProductRowMapper extractData ");
		List<Product> productList = new ArrayList<Product>();
		Product product = new Product();
		while(rs!=null && rs.next()) {
			product.setProduct_id(rs.getInt("product_id"));
			product.setDepartment(rs.getString("department"));
			product.setCurrent_price(rs.getDouble("current_price"));
			product.setCompany(rs.getString("company"));
			product.setProduct_title(rs.getString("product_title"));
			product.setProduct_subtitle(rs.getString("product_subtitle"));
			product.setProduct_description(rs.getString("product_description"));
			product.setAttributes(rs.getString("attributes"));
			product.setLifecycle_start(rs.getString("lifecycle_start"));
			product.setLifecycle_end(rs.getString("lifecycle_end"));
			product.setIsbn(rs.getString("isbn"));
			product.setColor(rs.getString("color"));
			product.setActive(rs.getString("active").equalsIgnoreCase("Yes")? true :false);
			String likeProd = rs.getString("like_products");
			String[] likeProdArray = likeProd.split(" ");
			List<Integer> likeProds = new ArrayList<Integer>();
			for(String prod : likeProdArray)
				likeProds.add(Integer.parseInt(prod));
			product.setLike_products(likeProds);
			productList.add(product);
		}
		logger.debug("ProductRowMapper extracted Data & size: "+ productList.size());
		return productList;
	}

}
