package com.example.multimodule.service;

import com.example.multimodule.dto.UserRequestDTO;

public interface ControllerBackEndService {
    boolean callCoreAndCount(UserRequestDTO userRequestDTO);
}
