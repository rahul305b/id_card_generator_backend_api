package com.id.web;

import com.id.entities.Authentication;
import com.id.models.AuthenticationModel;
import com.id.service.AuthenticationService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
@Slf4j
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/userLogin")
    public Map<String,Object> userLogin(@RequestPart(name="authModel",required = false) AuthenticationModel authenticationModel){
        Authentication authentication= authenticationService.userLogin(authenticationModel);
        final Map<String, Object> results = new HashMap<>();
        if(authentication==null){
            results.put("success",false);
            results.put("message", "Login failed");
        }
        else{
            results.put("success",true);
            results.put("message", "Login Successful");

        }
        return results;
        }
    }

