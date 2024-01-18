package org.uengine.process.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ActivityController.class)
public class ActivityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetActivities() throws Exception {
        mockMvc.perform(get("/api/activities"))
                .andExpect(status().isOk());
    }
}