package com.jwtsample.jwtsample;

import com.fasterxml.jackson.databind.ObjectMapper;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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
	
	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders
        		.webAppContextSetup(wac)
                .build();
	}
	
	@Test
	public void getMerchantTransactionsById() throws Exception{
		String request = "  {\r\n" + 
				"      \"schemaVersion\": \"1.0\",\r\n" + 
				"      \"requestId\": \"WF123458\",\r\n" + 
				"      \"sessionId\": \"SF7632603147897963917\",\r\n" + 
				"      \"timestamp\": \"3131231121\",\r\n" + 
				"      \r\n" + 
				"      \"channelName\": \"Web\",	\r\n" + 
				"        \"commandName\": \"/Get_SettlementAccTypes\",\r\n" + 
				"            \"payLoad\": {\r\n" + 
				"                                \r\n" + 
				"             }\r\n" + 
				"}";
        Object randomObj = new Object() {
            public final String id = "1234";
        };
        MediaType MEDIA_TYPE_JSON_UTF8 = new MediaType("application", "json", java.nio.charset.Charset.forName("UTF-8"));
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(randomObj);
		mockMvc.perform(post("/pg/request")
			    .contentType(MEDIA_TYPE_JSON_UTF8)
			    .content(request))
			    //.characterEncoding("utf-8"))
				.andExpect(status().isOk())
				//.andExpect(content().contentType(MEDIA_TYPE_JSON_UTF8))
				//.andExpect(jsonPath("$", hasSize(1)))
//				.andExpect(jsonPath("$[0].id").value(1L))
//				.andExpect(jsonPath("$[0].firstName").value("David"))
				.andDo(print());
	}
}
