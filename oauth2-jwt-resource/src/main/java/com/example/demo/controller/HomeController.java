/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author vnaraujo
 */
@RestController
@RequestMapping("/api/v1/resource/")
public class HomeController {

    @RequestMapping(method = RequestMethod.GET, value = "home", produces = "application/json")
    @ResponseBody
    @PreAuthorize(value="#oauth2.hasAuthority('COMUN')")
    public String home() {
        return "Hello";
    }

    @RequestMapping(method = RequestMethod.GET, value = "oauth2callback", produces = "application/json")
    @ResponseBody
    @PreAuthorize(value="#oauth2.hasAuthority('ADMIN')")
    public String oauth2CallBack() {
        return "CallBack";
    }
}
