package com.id.web;


import com.id.dto.IdInfoDTO;
import com.id.entities.IdInformation;
import com.id.models.IdInfoModel;
import com.id.service.IdInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
@Slf4j
public class IdCardController {
    private final IdInfoService idInfoService;

    @PostMapping(value="/idCard")
    public IdInfoDTO saveIdInfo(@RequestPart(name="idCardModel",required = false) IdInfoModel idInfoModel){

        IdInformation idInfoDTO = this.idInfoService.saveId(IdInformation.from(idInfoModel));
        return idInfoDTO.to();
    }
}
