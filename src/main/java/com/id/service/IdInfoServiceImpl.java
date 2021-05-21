package com.id.service;

import com.id.entities.IdInformation;
import com.id.repositories.IdRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class IdInfoServiceImpl implements  IdInfoService{
    private final IdRepository idRepository;

    @Override
    public IdInformation saveId(IdInformation idInformation){
        IdInformation IdInfoDB=idRepository.saveAndFlush(idInformation);
        return this.idRepository.saveAndFlush(IdInfoDB);
    }
}
