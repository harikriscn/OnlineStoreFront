CREATE TABLE TBL_USER (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  user_name VARCHAR(15) NOT NULL,
  email VARCHAR(100) DEFAULT NULL
);
  
CREATE TABLE TBL_PRODUCT (
  product_id INT AUTO_INCREMENT  PRIMARY KEY,
  department VARCHAR(250),
  current_price VARCHAR(10),
  company VARCHAR(30),
  product_title VARCHAR(30),
  product_subtitle VARCHAR(50),
  product_description VARCHAR(50),
  attributes VARCHAR(50),
  lifecycle_start VARCHAR(15),
  lifecycle_end VARCHAR(15),
  isbn VARCHAR(50),
  color VARCHAR(10),
  active VARCHAR(3),
  like_products VARCHAR(30)  
);
