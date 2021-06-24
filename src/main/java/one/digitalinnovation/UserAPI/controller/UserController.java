package one.digitalinnovation.UserAPI.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(("/api/v1/users"))
public class UserController {

    @GetMapping
    public String getUser() {
        return "API test!";
    }
}
