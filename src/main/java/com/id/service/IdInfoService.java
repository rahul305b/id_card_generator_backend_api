package com.id.service;

import com.id.entities.IdInformation;

import java.util.List;

public interface IdInfoService {
    IdInformation saveId(IdInformation idInformation);

    List<IdInformation> fetchAll();

    IdInformation fetchByID(Long id);

    long fetchIdCount();

    IdInformation UpdateBranch(Long id,String branch);
}
