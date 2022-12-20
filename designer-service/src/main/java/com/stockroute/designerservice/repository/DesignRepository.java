package com.stockroute.designerservice.repository;

import com.stockroute.designerservice.model.Design;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DesignRepository extends MongoRepository<Design,String> {
    @Query ("{'designDetails.designCode':{$in:[?0]}}")
    List<Design> findAllDesignFromCode(int designCode);
}
