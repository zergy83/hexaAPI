package com.example.multimodule.controllers;

import com.example.multimodule.dto.UserRequestDTO;
import com.example.multimodule.service.impl.ControllerBackEndServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final ControllerBackEndServiceImpl service;

    public UserController(ControllerBackEndServiceImpl service) {
        this.service = service;
    }

    // Endpoint
    @GetMapping("/{id}")
    public boolean getUserCount(@PathVariable Long id) {
    return service.callCoreAndCount(new UserRequestDTO());
    }
}
