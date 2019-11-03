/**
 * 
 */
package com.store.online.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author Harikrishnan
 *
 */
@Service
public class QueryService {
	@Value("${carttable.insert.query}")
	private String cartTableInsertQuery;
	
	@Value("${carttable.select.query}")
	private String cartTableSelectQuery;
	
	@Value("${cartDetailTable.insert.query}")
	private String cartDetailTableInsertQuery;
	
	@Value("${carttable.selectWithId.query}")
	private String cartTableSelectQueryWithId;
	
	
	@Value("${producttable.insert.query}")
	private String productTableInsertQuery;
	
	@Value("${producttable.update.query}")
	private String productTableUpdateQuery;
	
	@Value("${producttable.delete.queryWithId}")
	private String productTableDeleteQueryWithId;
	
	
	@Value("${producttable.select.query}")
	private String productTableSelectQuery;
	
	@Value("${producttable.select.queryWithId}")
	private String productTableSelectQueryWithId;

	public String getCartTableInsertQuery() {
		return cartTableInsertQuery;
	}

	public void setCartTableInsertQuery(String cartTableInsertQuery) {
		this.cartTableInsertQuery = cartTableInsertQuery;
	}

	public String getCartTableSelectQuery() {
		return cartTableSelectQuery;
	}

	public void setCartTableSelectQuery(String cartTableSelectQuery) {
		this.cartTableSelectQuery = cartTableSelectQuery;
	}

	public String getCartDetailTableInsertQuery() {
		return cartDetailTableInsertQuery;
	}

	public void setCartDetailTableInsertQuery(String cartDetailTableInsertQuery) {
		this.cartDetailTableInsertQuery = cartDetailTableInsertQuery;
	}

	public String getCartTableSelectQueryWithId() {
		return cartTableSelectQueryWithId;
	}

	public void setCartTableSelectQueryWithId(String cartTableSelectQueryWithId) {
		this.cartTableSelectQueryWithId = cartTableSelectQueryWithId;
	}

	public String getProductTableInsertQuery() {
		return productTableInsertQuery;
	}

	public void setProductTableInsertQuery(String productTableInsertQuery) {
		this.productTableInsertQuery = productTableInsertQuery;
	}

	public String getProductTableUpdateQuery() {
		return productTableUpdateQuery;
	}

	public void setProductTableUpdateQuery(String productTableUpdateQuery) {
		this.productTableUpdateQuery = productTableUpdateQuery;
	}

	public String getProductTableDeleteQueryWithId() {
		return productTableDeleteQueryWithId;
	}

	public void setProductTableDeleteQueryWithId(String productTableDeleteQueryWithId) {
		this.productTableDeleteQueryWithId = productTableDeleteQueryWithId;
	}

	public String getProductTableSelectQuery() {
		return productTableSelectQuery;
	}

	public void setProductTableSelectQuery(String productTableSelectQuery) {
		this.productTableSelectQuery = productTableSelectQuery;
	}

	public String getProductTableSelectQueryWithId() {
		return productTableSelectQueryWithId;
	}

	public void setProductTableSelectQueryWithId(String productTableSelectQueryWithId) {
		this.productTableSelectQueryWithId = productTableSelectQueryWithId;
	}
	
}
