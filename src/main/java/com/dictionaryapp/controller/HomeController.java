package com.dictionaryapp.controller;

import com.dictionaryapp.service.impl.LoggedUser;
import com.dictionaryapp.service.WordService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    private WordService wordService;
    private LoggedUser loggedUser;

    public HomeController(WordService wordService, LoggedUser loggedUser) {
        this.wordService = wordService;
        this.loggedUser = loggedUser;
    }

    @GetMapping("/")
    public ModelAndView index(){
        String view = "";
        if(loggedUser.isLogged()){
            view = "redirect:/home";
        }else{
            view = "index";
        }
        return new ModelAndView(view);
    }

    @GetMapping("/home")
    public ModelAndView home(){
        if(!loggedUser.isLogged()){
            return new ModelAndView("redirect:/login");
        }

        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("allWordsDTO", this.wordService.findAllWordsForHomepage());
        return modelAndView;
    }

}
