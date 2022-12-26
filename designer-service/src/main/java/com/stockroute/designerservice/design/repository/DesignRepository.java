package com.stockroute.designerservice.design.repository;

import com.stockroute.designerservice.design.model.Design;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DesignRepository extends MongoRepository<Design,String> {
    @Query("{'designDetails.designCode':{$in:[?0]}}")
    List<DesignRepository> findAllDesignFromCode(int designCode);

    List<DesignRepository> findByDesignId(String designId);
}
