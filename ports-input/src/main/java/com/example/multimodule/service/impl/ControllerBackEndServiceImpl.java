package com.example.multimodule.service.impl;

import com.example.multimodule.application.dto.UserCoreReponseDTO;
import com.example.multimodule.application.dto.UserCoreRequestDTO;
import com.example.multimodule.application.ports.CoreService;
import com.example.multimodule.dto.UserRequestDTO;
import com.example.multimodule.service.ControllerBackEndService;
import org.springframework.stereotype.Service;

@Service
public class ControllerBackEndServiceImpl implements ControllerBackEndService {
    private final CoreService coreService;

    public ControllerBackEndServiceImpl(CoreService coreService) {
        this.coreService = coreService;
    }

    @Override
    public boolean callCoreAndCount(UserRequestDTO userRequestDTO) {
        // generate UserCoreRequestDTO for UserRequestDTO
        UserCoreRequestDTO coreRequestDTO= new UserCoreRequestDTO();

        UserCoreReponseDTO reponseDTO= coreService.processUserRequestFromControllerDomain(coreRequestDTO);

        return reponseDTO.isCallDone();
    }
}
