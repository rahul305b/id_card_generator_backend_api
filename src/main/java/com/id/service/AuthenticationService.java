package com.id.service;

import com.id.entities.Authentication;
import com.id.models.AuthenticationModel;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {
    Authentication userLogin(AuthenticationModel authenticationModel);
}
