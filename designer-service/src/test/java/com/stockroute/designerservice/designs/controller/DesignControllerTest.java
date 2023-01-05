//package com.stockroute.designerservice.designs.controller;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.stockroute.designerservice.design.controller.DesignController;
//import com.stockroute.designerservice.design.exception.DesignAlreadyExistsException;
//import com.stockroute.designerservice.design.model.Design;
//import com.stockroute.designerservice.design.model.DesignDetails;
//import com.stockroute.designerservice.design.service.DesignService;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import org.junit.jupiter.api.extension.ExtendWith;
//
//@ExtendWith(MockitoExtension.class)
//public class DesignControllerTest {
//
//    @Autowired
//    MockMvc mockMvc;
//
//    @Mock
//    DesignService designService;
//
//    @InjectMocks
//    DesignController designController;
//
//    Design design1, design2;
//
//    DesignDetails designDetails1, designDetails2;
//
//    @BeforeEach
//    public void setUp() {
//        design1 = new Design();
//        designDetails1 = new DesignDetails("1", 1021, 100);
//
//        design2 = new Design();
//        designDetails2 = new DesignDetails("2", 1031, 170);
//
//        mockMvc = MockMvcBuilders.standaloneSetup(designController).build();
//
//    }
//
//    @AfterEach
//    public void tearDown() {
//
//        design1 = null;
//        design2 = null;
//        designDetails1 = null;
//        designDetails2 = null;
//    }
//
//    @Test
//    public void givenDesignToSaveReturnSaveDesign() throws Exception {
//        when(designService.saveDesign(any())).thenReturn(design1);
//        mockMvc.perform(post("/api/v2/design")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(jsonToString(design1)))
//                .andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());
//        verify(designService, times(1)).saveDesign(any());
//    }
//
//    @Test
//    public void givenDesignToSaveDesignFailure() throws Exception {
//        when(designService.saveDesign(any())).thenThrow(DesignAlreadyExistsException.class);
//        mockMvc.perform(post("/api/v2/design")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(jsonToString(design1)))
//                .andExpect(status().isConflict()).andDo(MockMvcResultHandlers.print());
//        verify(designService, times(1)).saveDesign(any());
//    }
//
//
//    @Test
//    public void givenDesignCodeDeleteDesign() throws Exception {
//        when(designService.deleteDesign(anyString())).thenReturn(true);
//        mockMvc.perform(delete("/api/v2/design/design1")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
//        verify(designService, times(1)).deleteDesign(anyString());
//    }
//
//    private static String jsonToString(final Object o) throws JsonProcessingException {
//        String result;
//        try {
//            ObjectMapper mapper = new ObjectMapper();
//            String jsonContent = mapper.writeValueAsString(o);
//            result = jsonContent;
//            return result;
//
//        } catch (JsonProcessingException e) {
//            result = "JsonProcessingException";
//        }
//        return result;
//    }
//
//}
