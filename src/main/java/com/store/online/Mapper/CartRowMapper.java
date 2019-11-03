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
import com.store.online.POJO.CartDetail;

/**
 * @author Harikrishnan
 *
 */

@Component
public class CartRowMapper implements ResultSetExtractor<List<CartDetail>> {

	Logger logger = LoggerFactory.getLogger(CartRowMapper.class);
	
	@Override
	public List<CartDetail> extractData(ResultSet rs) throws SQLException, DataAccessException {
		logger.debug("CartRowMapper extractData ");
		List<CartDetail> cartDetailList = new ArrayList<CartDetail>();
		
		while(rs!=null && rs.next()) {
			CartDetail cartDetail = new CartDetail();
			cartDetail.setCart_detail_id(rs.getInt("cart_detail_id"));
			cartDetail.setCart_id(rs.getInt("cart_id"));
			cartDetail.setProduct_id(rs.getInt("product_id"));
			cartDetail.setQuantity(rs.getInt("quantity"));
			cartDetail.setCreated_date(rs.getString("created_date")!=null?rs.getString("created_date"):"");
			cartDetail.setModified_date(rs.getString("modified_date")!=null?rs.getString("modified_date"):"");
			cartDetailList.add(cartDetail);
		}
		logger.debug("Result mapped and its size: " + cartDetailList.size());
		return cartDetailList;
		
	}

}
