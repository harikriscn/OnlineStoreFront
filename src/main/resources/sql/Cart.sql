  
CREATE TABLE TBL_CART (
  cart_id INT AUTO_INCREMENT  PRIMARY KEY,
  created_date VARCHAR(40)
);

CREATE TABLE TBL_CART_DETAIL (
  cart_detail_id INT AUTO_INCREMENT  PRIMARY KEY,
  cart_id INT,
  product_id INT,
  quantity VARCHAR(10),
  created_date VARCHAR(40),
  modified_date VARCHAR(40)
);
