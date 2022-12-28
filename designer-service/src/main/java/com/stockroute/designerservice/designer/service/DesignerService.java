package com.stockroute.designerservice.designer.service;
import com.stockroute.designerservice.designer.exception.ProfileAlreadyExit;
import com.stockroute.designerservice.designer.model.Designer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DesignerService {

    Designer saveDesigner(Designer designer) throws ProfileAlreadyExit;

    List<Designer> getAllDesigners();

    List<Designer> findDesignersByEmailId(String designerId);

    Designer updateDesigner(Designer designer);

    List<Designer> deleteDesignerById(String designerId);

    String deleteAllOrders();

}
