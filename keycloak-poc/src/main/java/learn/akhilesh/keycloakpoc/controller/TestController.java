package learn.akhilesh.keycloakpoc.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public String getTest(Authentication authentication) {
        return "Authentication working!!!";
    }
}
