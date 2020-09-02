package com.daeunp.springsecurityclient.controller;

import com.daeunp.springsecurityclient.model.User;
import com.daeunp.springsecurityclient.service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Map;

@RestController
public class controller {

    @Autowired
    MyUserDetailService myUserDetailService;

    @GetMapping("/userInfo")

    public ModelAndView userInfo(Principal principal){
        ModelAndView page = new ModelAndView();
        page.setViewName("userInfo");
        User user = myUserDetailService.findByUsername(principal.getName());
        page.addObject("name", user.getUsername());
        page.addObject("name", user.getName());
        page.addObject("role", user.getRoles());

        return page;
    }
}
