package com.jwtsample.jwtsample;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jwtsample.models.User;
import com.jwtsample.repositories.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ActiveProfiles(value="test")
@SpringBootTest
@EnableWebMvc
public class UserControllerTests {
	@Autowired
	WebApplicationContext wac;
	@Autowired
	private ObjectMapper objectMapper;
	private MockMvc mockMvc;
	@Autowired
	private UserRepository userRepository;
	
	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders
        		.webAppContextSetup(wac)
                .build();
	}

	private void setupUser(){
		User user = new User();
		user.setAccessId("accessId");
		user.setUsername("testUser");
		user.setPassword("123456");
		user.setEnabled(true);
		userRepository.save(user);
	}

	@Test
	public void getAllUserWithBasicInfo() throws Exception {
		setupUser();
		mockMvc.perform(get("/user/basic/all/"))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json"))
				//  .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Applicant Test"))
				.andDo(print());

	}

}
