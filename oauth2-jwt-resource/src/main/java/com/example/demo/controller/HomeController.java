/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import java.util.UUID;
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
@RequestMapping("/api/v1/home")
public class HomeController {

    @PreAuthorize("hasAuthority('ADMIN')") //Your user contains ADMIN authority
    @RequestMapping(method = RequestMethod.GET, value = "get", produces = "application/json")
    @ResponseBody
    public String get() {
        return String.format("%s you as ADMIN", UUID.randomUUID().toString());
    }

    @PreAuthorize("hasAuthority('COMUN')") // Access to COMUN authority when user contains 
    @RequestMapping(method = RequestMethod.POST, value = "post", produces = "application/json")
    @ResponseBody
    public String post() {
        return String.format("%s posted ", UUID.randomUUID().toString());
    }
}
