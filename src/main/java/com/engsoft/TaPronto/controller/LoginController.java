package com.engsoft.TaPronto.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.security.core.AuthenticationException;

@Controller
@RequestMapping("/login")
public class LoginController {


    @GetMapping
    public String login(Model model){

        return "login";
    }

    @GetMapping("/erro")
    public String loginErro(Model model, HttpServletRequest request){

        HttpSession secao = request.getSession(false);

        String mensagemErro = null;

        if(secao != null){
            AuthenticationException excecao = (AuthenticationException) secao.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);

            if(excecao != null){
                mensagemErro = excecao.getMessage();
            }
        }

        model.addAttribute("mensagem_erro", mensagemErro);

        return "login";
    }
}
