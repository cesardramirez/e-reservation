package com.platzi.ereservation.views.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static com.platzi.ereservation.util.Consts.URL_HOME;
import static com.platzi.ereservation.util.Consts.URL_LOGIN;

/**
 * Validate the personalized login.
 */
@Controller
@RequestMapping("app")
public class LoginController {

    @GetMapping(value = {URL_LOGIN, "/"})
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        String errorMessage = "Usuario no autorizado, debe autenticarse.";
        modelAndView.addObject("errorMsg", errorMessage);
        modelAndView.setViewName("login");

        return modelAndView;
    }

    @GetMapping(URL_HOME)
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");

        return modelAndView;
    }
}
