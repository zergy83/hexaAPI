package com.example.multimodule.application.mappers;

import com.example.multimodule.application.dto.UserCoreRequestDTO;
import com.example.multimodule.application.model.UserCallTrace;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserCoreRequestMapper {

    UserCallTrace asUserCallTrace(UserCoreRequestDTO userCoreRequestDTO);
}
