package com.stockroute.designerservice.designer.repository;

import com.stockroute.designerservice.designer.model.Designer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DesignerRepository extends MongoRepository<Designer,String> {
    List<Designer> findDesignerByEmailId(String EmailId);

    List<Designer> deleteDesignerByEmailId(String designerId);
}

