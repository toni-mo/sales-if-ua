package sales.users.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextLoader;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sales.roles.domain.Role;
import sales.roles.service.RoleService;
import sales.users.domain.City;
import sales.users.domain.User;
import sales.users.service.CityService;
import sales.util.Constants;

import java.util.Date;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by taras on 05.08.15.
 */
@ContextConfiguration(locations =
        {
                "classpath:META-INF/applicationContext.xml",
                "classpath:test-mvc-servlet.xml"
        },
        loader = ContextLoader.class)
@WebAppConfiguration
public class TestUserController extends AbstractTestNGSpringContextTests {

    private static final String MAIN_URL = "/user";
    private static final String CLIENT_URL = "/client";
    private static final String SHOP_URL = "/shop";

    private static final Long USER_ID = 1L;
    private static Long userId;

    private MvcResult result;
    private String userJson;

    private MockMvc mockMvc;
    private User user;


    @Autowired
    private WebApplicationContext wac;

    @Autowired
    CityService cityService;

    @Autowired
    RoleService roleService;

    @BeforeMethod
    public void initMockMvc() throws JsonProcessingException {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

        this.user = new User("1a1dc91c907325c69271ddf0c944bc72",
                "taras",
                "client",
                cityService.getOneByName("смт Зуя"),
                "tarik.danylyuk@gmail.com",
                "12342535",
                new Date(),
                roleService.getRoleByValue(Constants.CLIENT));

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        this.userJson = ow.writeValueAsString(this.user);
    }

    public void testAddUserInUserController() throws Exception {
        result = mockMvc.perform(post(MAIN_URL)
                .content(userJson)
                .contentType(MediaType.APPLICATION_JSON)
                .sessionAttr("comment", this.user))
                .andExpect(status().isCreated())
                .andReturn();

        String response = result.getResponse().getContentAsString();
        userId = new ObjectMapper().readValue(response, User.class).getId();
    }

    public void testGetUserInUserController() throws Exception{
        mockMvc.perform(get(MAIN_URL + "/" + USER_ID)
                .accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON));
    }

    public void testDeleteUserInUserController() throws Exception{
        mockMvc.perform(delete(MAIN_URL + "/delete" + userId))
                .andExpect(status().isOk());
    }
}
