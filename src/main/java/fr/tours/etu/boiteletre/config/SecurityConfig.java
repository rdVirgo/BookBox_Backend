package fr.tours.etu.boiteletre.config;

import fr.tours.etu.boiteletre.filter.JwtAuthFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;
/**
 * Security configuration file.
 * Defines access rules according to user roles (USER / ADMIN).
 * 20/12/2025
 * @author Radia MERABTENE & Mamadou COULIBALY
 * @version 1.0
 */

@Configuration
@EnableWebSecurity //activating spring security
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthFilter jwtAuthFilter;

    @Bean
    /**
     * a method to define the access roles to the HTTP queries
     *
     * @param
     */
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
               // deactivating the CSRF since we are using JWT no cookies
                .csrf(csrf -> csrf.disable())

                // making the server Stateless because everything will be managed with JWT Tokens
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )

               // authorizing the call of the backend app
                .cors(cors -> cors.configurationSource(request -> {
                    var corsConfig = new CorsConfiguration();
                    corsConfig.setAllowedOrigins(List.of("http://localhost:4200"));
                    corsConfig.setAllowedMethods(List.of("GET","POST","PUT","DELETE","OPTIONS"));
                    corsConfig.setAllowedHeaders(List.of("*"));
                    corsConfig.setAllowCredentials(true);
                    return corsConfig;
                }))

                // Access permission
                .authorizeHttpRequests(auth -> auth
                        // login and sig in
                        .requestMatchers("/api/auth/**").permitAll()// authentication public
                        .requestMatchers(HttpMethod.GET, "api/coordinates/**").permitAll()
                        // the API users accessible for admin only
                        //.requestMatchers(HttpMethod.GET, "/api/users/**").hasAnyRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/users/**").hasAnyRole("ADMIN","USER")
                        .requestMatchers(HttpMethod.PUT, "/api/users/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/users/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST,"api/users").permitAll()  // sig in for everyone
                        .requestMatchers(HttpMethod.GET,"/api/box/**", "/api/reservation/**").permitAll() // only reading

                         // for a user logging in only -> creating and deleting updating reservations and boxes
                        .requestMatchers(HttpMethod.POST, "/api/reservation/**").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.PUT , "/api/reservation/**").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.DELETE , "/api/reservation/**").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.POST,"/api/box/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT,"/api/box/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE,"/api/box/**").hasRole("ADMIN")


                        // the rest need authentication
                        .anyRequest().authenticated()
                )


                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    //creating encrypted password while creating a user
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
