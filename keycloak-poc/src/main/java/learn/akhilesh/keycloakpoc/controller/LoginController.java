package learn.akhilesh.keycloakpoc.controller;

import learn.akhilesh.keycloakpoc.dto.LoginRequest;
import learn.akhilesh.keycloakpoc.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public AccessTokenResponse getLogin(@RequestBody LoginRequest loginRequest) {
        return loginService.getAccessToken(loginRequest);
    }
}
