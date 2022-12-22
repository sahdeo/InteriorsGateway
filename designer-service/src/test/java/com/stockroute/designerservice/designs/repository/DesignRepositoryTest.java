package com.stockroute.designerservice.designs.repository;

import com.stockroute.designerservice.design.model.Design;
import com.stockroute.designerservice.design.model.DesignDetails;
import com.stockroute.designerservice.design.repository.DesignRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public class DesignRepositoryTest {

    @Autowired
    private DesignRepository designRepository;

    private Design design;
    private DesignDetails designDetails1, designDetails2;

    @BeforeEach
    public void setUp() {
        design = new Design();
        designDetails1 = new DesignDetails();

    }

    @AfterEach
    public void tearDown() {
        design = null;
        designDetails1 = null;
        designDetails2 = null;
        designRepository.deleteAll();
    }

    @Test
    public void givenDesignToSaveReturnDesign() {
        designRepository.insert(design);
        Design design1 = designRepository.findById(design.getDesignId()).get();
        assertNotNull(design1);
        assertEquals(design.getDesignId(), design1.getDesignId());
    }


    @Test
    public void givenTrackReturnAllDesign() {
        designRepository.insert(design);

        List<Design> list = designRepository.findAll();
        assertEquals(1, list.size());
        assertEquals("laptop", list.get(0).getDesignName());
    }


    @Test
    public void givenDesignToDeleteShouldReturnDeleteDesign() {
        designRepository.insert(design);
        Design design1 = designRepository.findById(design.getDesignId()).get();
        designRepository.delete(design1);
        assertEquals(Optional.empty(), designRepository.findById(design1.getDesignId()));

    }
}

