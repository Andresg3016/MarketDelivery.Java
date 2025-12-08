package com.proyecto.MarketDelivery.config;

import com.proyecto.MarketDelivery.security.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    private final UserDetailsServiceImpl userDetailsService;

    public SecurityConfig(UserDetailsServiceImpl uds) {
        this.userDetailsService = uds;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())

            .authorizeHttpRequests(authz -> authz
                // 🔥 Recursos estáticos accesibles sin login
                .requestMatchers("/css/**", "/js/**", "/img/**", "/static/**").permitAll()

                // 🔥 Rutas públicas
                .requestMatchers("/", "/home", "/register", "/login", "/api/usuarios/register").permitAll()

                // 🔐 Rutas protegidas por rol
                .requestMatchers("/emprendedor/**").hasRole("EMPRENDEDOR")
                .requestMatchers("/cliente/**").hasRole("CLIENTE")
                .requestMatchers("/admin/**").hasRole("ADMINISTRADOR") // 🔥 nuevo

                // 🔐 Todo lo demás requiere autenticación
                .anyRequest().authenticated()
            )

            .formLogin(form -> form
                .loginPage("/login")                       // Página personalizada de login
                .defaultSuccessUrl("/dashboard", true)     // Redirección tras login exitoso
                .permitAll()
            )

            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")                     // Redirección tras logout
                .permitAll()
            )

            // Para permitir acceso a la consola H2 (si la usas)
            .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable()));

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, PasswordEncoder passwordEncoder) throws Exception {
        AuthenticationManagerBuilder authBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
        return authBuilder.build();
    }
}
