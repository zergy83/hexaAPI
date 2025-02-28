package com.example.multimodule.service.feigncontract;

import com.example.multimodule.service.model.UserCallRegister;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "userClient", url = "https://jsonplaceholder.typicode.com")
public interface SecondAPIClient {
    @GetMapping("/users/{id}")
    UserCallRegister getUserCallRegisterById(@PathVariable("name") String userName);
}

