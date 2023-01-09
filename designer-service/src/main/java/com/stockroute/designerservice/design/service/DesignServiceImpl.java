package com.stockroute.designerservice.design.service;
import com.stockroute.designerservice.design.dto.UpdateDesign;
import com.stockroute.designerservice.design.exception.DesignAlreadyExistsException;
import com.stockroute.designerservice.design.exception.DesignNotFoundException;
import com.stockroute.designerservice.design.model.Design;
import com.stockroute.designerservice.design.model.DesignDetails;
import com.stockroute.designerservice.design.rabbitmqConfig.DesignDto;
import com.stockroute.designerservice.design.rabbitmqConfig.Producer;
import com.stockroute.designerservice.design.repository.DesignRepository;
import com.stockroute.designerservice.designer.model.Designer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class DesignServiceImpl implements DesignService {
    private DesignRepository designRepository;
    private Producer producer;

    @Autowired
    public DesignServiceImpl(DesignRepository designRepository,Producer producer) {
        this.designRepository = designRepository;
        this.producer=producer;
    }

    @Override
    public Design saveDesign(Design design) throws DesignAlreadyExistsException {
        if (designRepository.findById(design.getDesignId()).isPresent()) {
            throw new DesignAlreadyExistsException();
        }
        return designRepository.save(design);
    }


    @Override
    public Design buyDesign(String designID) throws DesignNotFoundException {
        Design design = findDesignByDesignId(designID);
        designRepository.findByDesignId(designID);
        DesignDto designDto = new DesignDto();
        designDto.setDesignName(design.getDesignName());
        designDto.setDesignId(design.getDesignId());
        designDto.setDesignPrice(design.getDesignPrice());
        designDto.setCustomerEmailId(design.getCustomerEmailId());
        System.out.println(designDto);

        producer.sendMessageToRabbitmq(designDto);

        return design;
    }

    @Override
    public Design uploadImage(String designId, MultipartFile file) throws IOException, DesignNotFoundException {
        Optional<Design> designOptinal = designRepository.findById(designId);

        if (designOptinal.isEmpty()) {
            throw new DesignNotFoundException();
        }
        Design design = designOptinal.get();
        design.setImage(file.getBytes());
        designRepository.save(design);
        return design;
    }


    @Override
    public boolean deleteDesign(String designId) throws DesignNotFoundException {
        boolean flag = false;
        if (designRepository.findById(designId).isEmpty()) {
            throw new DesignNotFoundException();
        } else {
            designRepository.deleteById(designId);
            flag = true;
        }
        return flag;
    }

    @Override
    public List<Design> getAllDesign(int design) throws DesignNotFoundException {
        if (designRepository.findAllDesignFromCode(design).isEmpty()) {
            throw new DesignNotFoundException();
        }
        return designRepository.findAllDesignFromCode(design);
    }

    @Override
    public Design updateDesign(UpdateDesign updateDesign, String designId) {
        Optional <Design> optionalDesign=designRepository.findById(designId);
        if ( optionalDesign.isEmpty()){
            return null;
        }
        Design designFound=optionalDesign.get();
        Design design=new Design();
        design.setDesignId(designId);
        if(updateDesign.getDesignName().equals("string"))
            design.setDesignName(designFound.getDesignName());
        else design.setDesignName(updateDesign.getDesignName());
        if(updateDesign.getRatings().equals("string"))
            design.setRatings(designFound.getRatings());
        else design.setRatings(updateDesign.getRatings());
        if(updateDesign.getColor().equals("string"))
            design.setColor(designFound.getColor());
        else design.setColor(updateDesign.getColor());
        if(updateDesign.getSize()==0)
            design.setSize(designFound.getSize());
        else design.setSize(updateDesign.getSize());
        if(updateDesign.getDesignerEmailId().equals("string"))
            design.setDesignerEmailId(designFound.getDesignerEmailId());
        else design.setDesignerEmailId(updateDesign.getDesignerEmailId());

       // DesignDetails designDetails=new DesignDetails();
        DesignDetails updateDesignDetails=updateDesign.getDesignDetails();

        if(updateDesignDetails.getDesignModel().equals("string"))
            design.setDesignModel(designFound.getDesignModel());
        else design.setDesignModel(updateDesignDetails.getDesignModel());
        if(updateDesignDetails.getDesignCode()==0)
            design.setDesignCode(designFound.getDesignCode());
        else design.setDesignCode(updateDesignDetails.getDesignCode());
        if(updateDesignDetails.getDesignPrice()==0)
            design.setDesignPrice(designFound.getDesignPrice());
        else design.setDesignPrice(updateDesignDetails.getDesignPrice());

       // design.setDesignDetails(designDetails);


        return designRepository.save(design);
    }
    @Override
    public List<Design> getDesignDetails() throws Exception {
        return designRepository.findAll();
    }

    @Override
    public Design findDesignByDesignId(String designId) throws DesignNotFoundException {
        Optional<Design> designOptinal = designRepository.findById(designId);

        if (designOptinal.isEmpty()) {
            throw new DesignNotFoundException();
        }
        return designOptinal.get();

    }
    @Override
    public List<Design> findDesignersByEmailId(String EmailId) {
        return designRepository.findByDesignerEmailId(EmailId);
    }
}


