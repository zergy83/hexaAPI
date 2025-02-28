package com.example.multimodule.application.service;

import com.example.multimodule.application.dto.UserCoreReponseDTO;
import com.example.multimodule.application.dto.UserCoreRequestDTO;
import com.example.multimodule.service.model.UserCallRegister;

public interface CoreService {

    UserCoreReponseDTO processUserRequestFromControllerDomain(UserCoreRequestDTO userCoreRequestDTO);

    void getFromDatabase();

    int callAnotherAPI(String userName);

    void persistUserCall(UserCallRegister callRegister);


}
