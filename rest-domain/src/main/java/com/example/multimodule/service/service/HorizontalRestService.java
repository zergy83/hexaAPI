package com.example.multimodule.service.service;

import com.example.multimodule.service.dto.HorizontalGetRequestDTO;
import com.example.multimodule.service.dto.HorizontalGetResponseDTO;

public interface HorizontalRestService {

    HorizontalGetResponseDTO getCurrentCallNumberForThisUser(HorizontalGetRequestDTO requestDTO);

}
