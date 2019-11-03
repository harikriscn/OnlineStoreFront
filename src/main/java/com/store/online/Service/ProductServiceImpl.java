/**
 * 
 */
package com.store.online.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.online.Controller.ProductController;
import com.store.online.Dao.ProductDAO;
import com.store.online.Dao.ProductRepository;
import com.store.online.POJO.Product;

/**
 * @author Harikrishnan
 *
 */
@Service
public class ProductServiceImpl implements ProductService{
	Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public boolean addOrUpdateProducts(Product product) {
		logger.debug("addOrUpdateProducts --Service layer");
		if(product.getProduct_id()==0) {
			logger.debug("addProducts ");
			return productRepository.addProducts(product);
		} else {
			logger.debug("updateProduct ");
			return productRepository.updateProduct(product);
		}
	}

	@Override
	public boolean deleteProduct(int product_id) {
		logger.debug("deleteProduct --Service layer");
		return productRepository.deleteProduct(product_id);
	}

	@Override
	public List<Product> getProducts(Product product) {
		logger.debug("getProducts --Service layer");
		return productRepository.fetchProducts(product);
	}

}
