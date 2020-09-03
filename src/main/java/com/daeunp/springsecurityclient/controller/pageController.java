package com.daeunp.springsecurityclient.controller;

import com.daeunp.springsecurityclient.model.User;
import com.daeunp.springsecurityclient.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@RestController
public class pageController {

    @Autowired
    CustomUserDetailsService userService;

    @GetMapping(value = {"/", "/home"})
    public ModelAndView home() {
        ModelAndView page = new ModelAndView();
        page.setViewName("home");
        return page;
    }

    @GetMapping("/userInfo")
    public ModelAndView userInfo(Principal principal) {
        User user = userService.findByUsername(principal.getName());

        ModelAndView page = new ModelAndView();
        page.setViewName("userInfo");
        page.addObject("name", user.getUsername());
        page.addObject("name", user.getName());
        page.addObject("role", user.getRoles());

        return page;
    }
}
