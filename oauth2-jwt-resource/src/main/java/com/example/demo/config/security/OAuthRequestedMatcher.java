/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.config.security;

import javax.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.util.matcher.RequestMatcher;

/**
 *
 * @author vnaraujo
 */
@Configuration
public class OAuthRequestedMatcher implements RequestMatcher {

    @Override
    public boolean matches(HttpServletRequest request) {
        String auth = request.getHeader("Authorization");
        return (auth != null) && auth.startsWith("Bearer") || request.getParameter("access_token") != null;
    }
}
