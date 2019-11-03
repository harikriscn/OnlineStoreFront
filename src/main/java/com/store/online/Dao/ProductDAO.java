/**
 * 
 */
package com.store.online.Dao;

import java.util.List;

import com.store.online.POJO.Product;

/**
 * @author Harikrishnan
 *
 */
public interface ProductDAO {
	
	public boolean addProducts(Product product);
	public boolean updateProduct(Product product);
	public boolean deleteProduct(int product_id);
	public List<Product> fetchProducts(Product product);
	public Product fetchProductsById(int product_id);

}
