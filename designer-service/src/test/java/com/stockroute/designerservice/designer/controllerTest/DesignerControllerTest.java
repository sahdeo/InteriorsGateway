package com.stockroute.designerservice.designer.controllerTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stockroute.designerservice.design.service.DesignService;
import com.stockroute.designerservice.designer.model.Designer;
import com.stockroute.designerservice.designer.service.DesignerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@WebMvcTest
public class DesignerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DesignerService designerService;
    @MockBean
    private DesignService designService;

    private Designer designer;

    private List<Designer> designers;


    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public  void setup(){
        designers=new ArrayList<>();
        designer = Designer.builder().designerId("101").emailId("Chinna@123").
                firstName("chinna").lastName("chinnu").startDate(LocalDateTime.parse("12-12-2023")).endDate("13-12-2023").status(true).build();

    }


    @Test
    public void saveUserTestSuccess() throws Exception {

        when(designerService.saveDesigner(any())).thenReturn(designer);

        mockMvc.perform(post("/api/v11/addDesigner")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(designer)))
                .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());

    }

    @Test
    public void getAllUsers() throws Exception {

        mockMvc.perform(get("/api/v11/AllUDesigners")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(designer)))
                .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    @Test
    void getDesignerByEmailIdTest() throws Exception {
        Mockito.when(designerService.findDesignersByEmailId(Mockito.any())).thenReturn(designers);
        mockMvc.perform(get("/api/v11/findByEmailId/Chinna@123"))
                .andExpect(status().isOk());
    }
}
