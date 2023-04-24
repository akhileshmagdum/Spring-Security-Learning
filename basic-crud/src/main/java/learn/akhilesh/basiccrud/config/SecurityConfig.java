package learn.akhilesh.basiccrud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private CustomAuthFilter customAuthFilter;

    /**
     * Replacement to configure method in WebSecurityConfigurerAdapter
     *
     * @param httpSecurity
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests()
                .requestMatchers("/home/**").permitAll()
                //here MVC matchers can also be used for path variables
                .requestMatchers("/employee/all").hasRole("ADMIN")
                .requestMatchers("/employee/{id}").hasRole("USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic();

        //Adding filter to FilterChain
        httpSecurity.addFilterBefore(customAuthFilter, BasicAuthenticationFilter.class);

        return httpSecurity.build();
    }

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin_user")
                .roles("ADMIN")
                .password("pass")
                .build();
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("simple_user")
                .roles("USER")
                .password("word")
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }
}
