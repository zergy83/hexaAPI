package com.example.multimodule.service.service.implV1;

import com.example.multimodule.service.dto.HorizontalGetRequestDTO;
import com.example.multimodule.service.dto.HorizontalGetResponseDTO;
import com.example.multimodule.service.service.HorizontalRestService;
import org.springframework.stereotype.Service;

@Service
public class HorizontalService implements HorizontalRestService {

    @Override
    public HorizontalGetResponseDTO getCurrentCallNumberForThisUser(HorizontalGetRequestDTO requestDTO) {
        //GET REST call, extract data and generate a response, this module may not need model as it just get data from DTO to DTO
        return new HorizontalGetResponseDTO();
    }
}
