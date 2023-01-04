package com.stockroute.designerservice.designer.serviceTest;

import com.stockroute.designerservice.designer.exception.ProfileAlreadyExit;

import com.stockroute.designerservice.designer.model.Designer;
import com.stockroute.designerservice.designer.repository.DesignerRepository;
import com.stockroute.designerservice.designer.service.DesignerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class DesignerServiceTest {

    @Mock
    DesignerRepository designerRepository;

    @InjectMocks
    DesignerServiceImpl designerService;

    public Designer designer;

    private List<Designer> list;


    @BeforeEach
    public void setup() {
        list = new ArrayList<>();
        designer = Designer.builder().designerId("101").emailId("Chinna@123").
                firstName("chinna").lastName("chinnu").startDate(LocalDateTime.parse("12-12-2023")).endDate("13-12-2023").status(true).build();


    }


    @Test
    public void saveDesignerTest() throws ProfileAlreadyExit {

        given(designerRepository.save(designer)).willReturn(designer);
        designerService.saveDesigner(designer);
        assertThat(designerService).isNotNull();
    }
    @Test
    void getAllDesignersByEmailIdTest() throws Exception{

        when(designerRepository.findDesignerByEmailId(Mockito.any())).thenReturn(list);
        List<Designer> designersDetails=designerService.findDesignersByEmailId("Chinna@123");
        assertEquals(0, designersDetails.size());
    }

}

