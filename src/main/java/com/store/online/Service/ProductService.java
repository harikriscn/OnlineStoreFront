package com.store.online.Service;

import java.util.List;

import com.store.online.POJO.Product;

/**
 * @author Harikrishnan
 *
 */
public interface ProductService {

	boolean addOrUpdateProducts(Product product);

	boolean deleteProduct(int product_id);

	List<Product> getProducts(Product product);

}
