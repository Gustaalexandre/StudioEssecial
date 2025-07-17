package com.cefet.StudioEssencial.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.cefet.StudioEssencial.security.JwtAuthenticationFilter;
import com.cefet.StudioEssencial.services.UsuarioDetailsService;

@Configuration
public class SecurityConfig {
    @Autowired
    private UsuarioDetailsService usuarioDetailsService;

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Desabilita verificação CSRF para permitir POST com token JWT
                .cors()  
                .and()
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**").permitAll() // Acesso ao H2 Console
                        .requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll() // Acesso
                                                                                                              // ao
                                                                                                              // Swagger
                                                                                                              // UI
                        .requestMatchers(HttpMethod.POST, "/usuarios").permitAll() // Permitir criação de usuário
                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll() // Permitir endpoint de login
                        .requestMatchers(HttpMethod.GET, "/pessoas").permitAll() // Regras de Autorização
                                                                                               // para
                        // Pessoas
                        .requestMatchers(HttpMethod.GET, "/pessoas/{id}").hasAnyRole("FUNCIONARIO")
                        .requestMatchers(HttpMethod.POST, "/pessoas").hasAnyRole("FUNCIONARIO")
                        .requestMatchers(HttpMethod.PUT, "/pessoas/**").hasAnyRole("FUNCIONARIO")
                        .requestMatchers(HttpMethod.DELETE, "/pessoas/**").hasRole("FUNCIONARIO")
                        .requestMatchers(HttpMethod.GET, "/procedimentos").hasAnyRole("FUNCIONARIO") // Regras de
                                                                                                     // Autorização para
                        // Procedimentos
                        .requestMatchers(HttpMethod.GET, "/procedimentos/{id}").hasAnyRole("FUNCIONARIO", "CLIENTE")
                        .requestMatchers(HttpMethod.POST, "/procedimentos").hasAnyRole("FUNCIONARIO")
                        .requestMatchers(HttpMethod.PUT, "/procedimentos/**").hasAnyRole("FUNCIONARIO")
                        .requestMatchers(HttpMethod.DELETE, "/procedimentos/**").hasAnyRole("FUNCIONARIO")
                        .requestMatchers(HttpMethod.GET, "/telefones").hasAnyRole("FUNCIONARIO") // Regras de
                                                                                                 // Autorização para
                        // Telefones
                        .requestMatchers(HttpMethod.GET, "/telefones/{id}").hasAnyRole("FUNCIONARIO")
                        .requestMatchers(HttpMethod.POST, "/telefones").hasAnyRole("FUNCIONARIO")
                        .requestMatchers(HttpMethod.PUT, "/telefones/**").hasAnyRole("FUNCIONARIO")
                        .requestMatchers(HttpMethod.DELETE, "/telefones/**").hasAnyRole("FUNCIONARIO")
                        .requestMatchers(HttpMethod.GET, "/agendamentos").hasAnyRole("FUNCIONARIO") // Regras de
                                                                                                    // Autorização para
                        // Agendamentos
                        .requestMatchers(HttpMethod.GET, "/agendamentos{id}").hasAnyRole("FUNCIONARIO")
                        .requestMatchers(HttpMethod.POST, "/agendamentos").hasAnyRole("FUNCIONARIO")
                        .requestMatchers(HttpMethod.PUT, "/agendamentos/**").hasAnyRole("FUNCIONARIO")
                        .requestMatchers(HttpMethod.DELETE, "/agendamentos/**").hasAnyRole("FUNCIONARIO")
                        .requestMatchers(HttpMethod.GET, "/pagamentos").hasAnyRole("FUNCIONARIO") // Regras de
                                                                                                  // Autorização para
                        // Pagamentos
                        .requestMatchers(HttpMethod.GET, "/pagamentos/{id}").hasAnyRole("FUNCIONARIO")
                        .requestMatchers(HttpMethod.GET, "/pagamentos/agendamentos/{agendamentoId}")
                        .hasAnyRole("FUNCIONARIO")
                        .requestMatchers(HttpMethod.POST, "/pagamentos").hasAnyRole("FUNCIONARIO")
                        .requestMatchers(HttpMethod.PUT, "/pagamentos/**").hasAnyRole("FUNCIONARIO")
                        .requestMatchers(HttpMethod.DELETE, "/pagamentos/**").hasAnyRole("FUNCIONARIO")
                        .anyRequest().authenticated() // Todos os outros endpoints exigem autenticação
                )
                .headers(headers -> headers.frameOptions().disable()) // Para H2 Console
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(usuarioDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:4200")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }
}