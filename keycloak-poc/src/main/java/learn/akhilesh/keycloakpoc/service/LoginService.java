package learn.akhilesh.keycloakpoc.service;

import learn.akhilesh.keycloakpoc.dto.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.keycloak.authorization.client.AuthzClient;
import org.keycloak.authorization.client.Configuration;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class LoginService {

    @Value("${keycloak.realm}")
    private String realm;

    @Value("${keycloak.client-id}")
    private String client;

    @Value("${keycloak.client-secret}")
    private String clientSecret;

    @Value("${keycloak.auth-server-url}")
    private String authUrl;

    public AccessTokenResponse getAccessToken(LoginRequest loginRequest) {
        Map<String, Object> clientCredentials = new HashMap<>();
        clientCredentials.put("secret", clientSecret);
        clientCredentials.put("provider", "secret");
        Configuration configuration = new Configuration(authUrl, realm, client,
                clientCredentials, null);
        AuthzClient authzClient = AuthzClient.create(configuration);
        return authzClient
                .obtainAccessToken(loginRequest.getUsername(), loginRequest.getPassword());
    }
}
