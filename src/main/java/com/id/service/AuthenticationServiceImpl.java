package com.id.service;

import com.id.entities.Authentication;
import com.id.models.AuthenticationModel;
import com.id.repositories.AuthenticationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService{

    private final AuthenticationRepository authenticationRepository;

    @Override
    public Authentication userLogin(AuthenticationModel authenticationModel){
        return this.authenticationRepository.findByUserNameAndPassword(authenticationModel.getUserName(), authenticationModel.getPassword());

    }



}
