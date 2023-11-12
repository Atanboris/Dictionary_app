package com.dictionaryapp.controller;

import com.dictionaryapp.model.bindingmodels.UserLoginBindingModel;
import com.dictionaryapp.model.bindingmodels.UserRegisterBindingModel;
import com.dictionaryapp.service.UserService;
import com.dictionaryapp.service.impl.LoggedUser;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    private UserService userService;
    private LoggedUser loggedUser;

    public UserController(UserService userService, LoggedUser loggedUser) {
        this.userService = userService;
        this.loggedUser = loggedUser;
    }

    @GetMapping("/login")
    public ModelAndView login(@ModelAttribute("userLoginBindingModel")
                                  UserLoginBindingModel userLoginBindingModel){

        if(loggedUser.isLogged()) {
            return new ModelAndView("redirect:/home");
        }

        return new ModelAndView("login");
    }
    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("userLoginBindingModel") @Valid
                                  UserLoginBindingModel userLoginBindingModel,
                              BindingResult bindingResult){
        boolean hasLoggedIn = this.userService.login(userLoginBindingModel);

        if(!hasLoggedIn){
            ModelAndView modelAndView = new ModelAndView("login");
            modelAndView.addObject("hasLoginError", true);
            return modelAndView;
        }
        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/register")
    public ModelAndView register(@ModelAttribute("userRegisterBindingModel")
                                     UserRegisterBindingModel userRegisterBindingModel){
        if(loggedUser.isLogged()) {
            return new ModelAndView("redirect:/home");
        }
        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public ModelAndView register(@ModelAttribute("userRegisterBindingModel") @Valid
                                     UserRegisterBindingModel userRegisterBindingModel,
                                 BindingResult bindingResult){
       boolean hasRegistered = this.userService.register(userRegisterBindingModel);
       if(!hasRegistered){
           return new ModelAndView("register");
       }
       return new ModelAndView("redirect:/login");
    }
    @GetMapping("/logout")
    public ModelAndView logout(){
        if(!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }

        this.userService.logout();
        return new ModelAndView("redirect:/");
    }

}
