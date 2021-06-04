package com.id.service;

import com.id.entities.IdInformation;
import com.id.repositories.IdRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public List<IdInformation> fetchAll() {
        return idRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public IdInformation fetchByID(Long id){
        return this.idRepository.findById(id).get();
    }
}
