package com.engsoft.TaPronto.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    MvcRequestMatcher.Builder matcher(HandlerMappingIntrospector handlerMappingIntrospector) {
        return new MvcRequestMatcher.Builder(handlerMappingIntrospector);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity, MvcRequestMatcher.Builder mvcRequestMatcher) throws Exception{

        return httpSecurity.authorizeHttpRequests((authorize)->{
            authorize.anyRequest().permitAll();
        }).build();

       /* return httpSecurity.authorizeHttpRequests((authorize)->{
            authorize.requestMatchers(mvcRequestMatcher.pattern("/")).permitAll();
        }).formLogin((formlogin)->{
            formlogin.loginPage("/login")
                    .loginProcessingUrl("/login")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .defaultSuccessUrl("/cadastrar_empreendimento")
                    .permitAll();

        }).build();*/
    }

}
