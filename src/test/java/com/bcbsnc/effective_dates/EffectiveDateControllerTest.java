package com.bcbsnc.effective_dates;

import com.bcbsnc.effective_dates.api.EffectiveDateController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EffectiveDateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EffectiveDateController effectiveDateController;

    @Test
    public void under65AEP_200Status() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/effectivedates/under65")
        )
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void over65_200Status() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/effectivedates/over65")
        )
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void help_200Status() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/effectivedates/help")
        )
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void configuration_200Status() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/effectivedates/configure")
        )
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    //broken for now.
//    @Test
//    public void under65Json() throws Exception {
//        mockMvc.perform(get("/api/effectivedates/under65")
//        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.EffectiveAndExpirationDates", Matchers.is(LocalDate.parse("2019-12-01"))));
//    }
}
