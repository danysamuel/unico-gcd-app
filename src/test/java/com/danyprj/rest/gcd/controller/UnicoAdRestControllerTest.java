package com.danyprj.rest.gcd.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UnicoAdRestControllerTest {

	 private MockMvc mockMvc;

	 @Autowired
	 private UnicoAdRestController unicoAdRestController;
	
	 @Before
	    public void setup() {

	       
	        MockitoAnnotations.initMocks(this);
	        mockMvc = MockMvcBuilders.standaloneSetup(unicoAdRestController).build();
	    }

	@Test
	public void testPush() throws Exception {
	    mockMvc.perform(get("/push/20/30"))
	    .andExpect(status().isOk())
	    .andDo(print());
	}
	

	@Test
	public void testList() throws Exception {
	    mockMvc.perform(get("/list"))
	    .andExpect(status().isOk())
	    .andDo(print());
	}
	
	
	  
	    
	
	
	
}
