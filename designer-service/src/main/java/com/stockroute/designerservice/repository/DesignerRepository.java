package com.stockroute.designerservice.repository;

import com.stockroute.designerservice.model.DesignerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DesignerRepository extends MongoRepository<DesignerEntity, String> {
    List<DesignerEntity> findByDesignerId(String designerId);
    List<DesignerEntity> findByEmailId(String emailId);

    List<DesignerEntity> deleteDesignerByDesignerId(String designerId);

}
