package com.kheyrinc.hrapi;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



import com.kheyrinc.hrapi.controller.UserController;
import com.kheyrinc.hrapi.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(controllers = UserController.class)
public class UserControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void testGetAllUser() throws Exception{
        mockMvc.perform(get("/api/v1/users"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect( jsonPath("$[0].firstname", is("test")));
    }


    @Test
    public void testGetOneUser() throws Exception{
        mockMvc.perform(get("/api/v1/user/1"))
                .andExpect(status().isOk())
                .andExpect( jsonPath("$.firstname", is("test")));
    }
}
