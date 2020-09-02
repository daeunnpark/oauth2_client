package com.daeunp.springsecurityclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class loginController {

    @GetMapping(value = {"/","/home"})
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @GetMapping("/userInfo")
    public ModelAndView user() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        ModelAndView page = new ModelAndView();
        /*
        User user = myUserDetailService.findByUsername(auth.getName());	// auth default setting 조사
        page.addObject("currentUser", user);
        page.addObject("username", user.getUsername());
        page.addObject("name", user.getName());
        page.addObject("id", user.getId());
        page.setViewName("userInfo");
        */
        return page;
    }

}
