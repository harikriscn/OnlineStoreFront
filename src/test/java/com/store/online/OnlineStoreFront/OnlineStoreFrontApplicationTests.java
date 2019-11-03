package com.store.online.OnlineStoreFront;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest
class OnlineStoreFrontApplicationTests {
	
	/*@InjectMocks
	ProductController productController;*/
	
	@Autowired
	private MockMvc mockMvc; 
	

	/*@BeforeAll
    public void init() {
        MockitoAnnotations.initMocks(this);
    }*/
     
	/*@Test
	void contextLoads() {
		MockitoAnnotations.initMocks(this);
	}*/
	@Test
	public void testApplicationAvailable() {
		try {
			this.mockMvc.perform(get("/v1/product/ping")).andExpect(status().isOk());
		} catch (Exception e) {
			System.out.println("Mock is failure");
			e.printStackTrace();
		}
	}

}
