package com.id.web;


import com.id.Exceptions.ResourceNotFoundException;
import com.id.dto.IdInfoDTO;
import com.id.entities.IdInformation;
import com.id.models.IdInfoModel;
import com.id.repositories.IdRepository;
import com.id.service.IdInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
@Slf4j
public class IdCardController {
    private final IdInfoService idInfoService;
    private final IdRepository idRepository;

//Save API
    @PostMapping(value="/idCard")
    public IdInfoDTO saveIdInfo(@RequestPart(name="idCardModel",required = false) IdInfoModel idInfoModel){

        IdInformation idInfoDTO = this.idInfoService.saveId(IdInformation.from(idInfoModel));
        return idInfoDTO.to();
    }

    //GET All Details API
    @GetMapping("/idCard")
    public List<IdInfoDTO> getIdInfo(){
        List <IdInfoDTO> idInfoDTOS = new ArrayList<>();
        List<IdInformation> idInfos= idInfoService.fetchAll();
       for(IdInformation idInformation : idInfos){
           //IdInfoDTO idInfoDTO=idInformation.to();

           idInfoDTOS.add(idInformation.to());
       }
        return idInfoDTOS;
    }

    //Get Particular detail by id api
    @GetMapping("/idCard/{id}")
    public IdInfoDTO fetchIdCardByID(@PathVariable Long id){
        return this.idInfoService.fetchByID(id).to();
    }

    //Update the detail by id API
    @PutMapping("/idCard/{id}")
    public IdInfoDTO saveIdDetails(@PathVariable Long id,@RequestPart(name="idCardModel",required = false) IdInformation idInformation){
        IdInfoDTO IdCardOptional = idInfoService.fetchByID(id).to();

        idInformation.setId(id);
        idInfoService.saveId(idInformation);
        return this.idInfoService.saveId(idInformation).to();
    }

    //Delete the details by id API
    @DeleteMapping("/idCard/{id}")
    public Map<String,Boolean> deleteId(@PathVariable(value="id") Long id)throws Exception{
        IdInformation idInformation=idRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("ID Card not found on:"+id));
        idRepository.delete(idInformation);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;

    }

}
