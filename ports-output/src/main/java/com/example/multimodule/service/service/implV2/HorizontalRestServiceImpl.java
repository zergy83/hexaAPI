package com.example.multimodule.service.service.implV2;

import com.example.multimodule.service.dto.HorizontalGetRequestDTO;
import com.example.multimodule.service.dto.HorizontalGetResponseDTO;
import com.example.multimodule.service.feigncontract.SecondAPIClient;
import com.example.multimodule.service.model.UserCallRegister;
import com.example.multimodule.service.service.HorizontalRestService;
import org.springframework.stereotype.Service;

/**
 * This version uses FEIGN library, target url is hardcoded in SecondAPIClient interface
 */
@Service
public class HorizontalRestServiceImpl implements HorizontalRestService {
    private final SecondAPIClient secondAPIClient;

    public HorizontalRestServiceImpl(SecondAPIClient secondAPIClient) {
        this.secondAPIClient = secondAPIClient;
    }

    @Override
    public HorizontalGetResponseDTO getCurrentCallNumberForThisUser(HorizontalGetRequestDTO requestDTO) {
        //call second API
        UserCallRegister userCallRegister = secondAPIClient.getUserCallRegisterById(requestDTO.getUserName());

        //user mapper or by hand extraction
        HorizontalGetResponseDTO responseDTO = new HorizontalGetResponseDTO();
        responseDTO.setNumberOfCallForThisUser(userCallRegister.getNumberOfCall());
        return responseDTO;
    }
}
