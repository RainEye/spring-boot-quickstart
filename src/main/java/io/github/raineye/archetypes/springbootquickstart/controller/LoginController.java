package io.github.raineye.archetypes.springbootquickstart.controller;

import io.github.raineye.archetypes.springbootquickstart.service.LoginService;
import io.github.raineye.archetypes.springbootquickstart.util.RestResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public RestResponse<Object> login(String username, String password) {
        loginService.login(username, password);
        return RestResponse.ok();
    }
}
