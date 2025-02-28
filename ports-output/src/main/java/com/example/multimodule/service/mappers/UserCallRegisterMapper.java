package com.example.multimodule.service.mappers;

import com.example.multimodule.service.entities.UserCallRegisterEntity;
import com.example.multimodule.service.model.UserCallRegister;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserCallRegisterMapper {

    UserCallRegisterEntity asEntity(UserCallRegister userCallRegister);
}
