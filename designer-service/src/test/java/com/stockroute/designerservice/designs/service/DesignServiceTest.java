package com.stockroute.designerservice.designs.service;

import com.stockroute.designerservice.design.exception.DesignAlreadyExistsException;
import com.stockroute.designerservice.design.exception.DesignNotFoundException;
import com.stockroute.designerservice.design.model.Design;
import com.stockroute.designerservice.design.model.DesignDetails;
import com.stockroute.designerservice.design.repository.DesignRepository;
import com.stockroute.designerservice.design.service.DesignServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.ArgumentMatchers.any;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DesignServiceTest {

    private Design design1, design2;
    private DesignDetails designDetails1, designDetails2;

    @Mock
    private DesignRepository designRepository;

    @InjectMocks
    private DesignServiceImpl designService;

    @BeforeEach
    public void setUp() {

        design1 = new Design();
        designDetails1 = new DesignDetails("3",1081,100);

        design2 = new Design();
        designDetails2 = new DesignDetails("1",1029,100);
    }

    @AfterEach
    public void tearDown() {

        design1 = null;
        design2 = null;
        designDetails1 = null;
        designDetails2 = null;
    }

    @Test
    public void givenDesignToSaveReturnSavedDesign() throws DesignAlreadyExistsException {
        when(designRepository.findById(design1.getDesignId())).thenReturn(Optional.empty());
        when(designRepository.save(design1)).thenReturn(design1);
        assertEquals(design1, designService.saveDesign(design1));
        verify(designRepository, times(1)).save(any());
        verify(designRepository, times(1)).findById(any());

    }

    @Test
    public void givenDesignToSaveReturnDesignFailure() {
        when(designRepository.findById(design1.getDesignId())).thenReturn(Optional.ofNullable(design1));
        assertThrows(DesignAlreadyExistsException.class, () -> designService.saveDesign(design1));
        verify(designRepository, times(0)).save(any());
        verify(designRepository, times(1)).findById(any());

    }
}

