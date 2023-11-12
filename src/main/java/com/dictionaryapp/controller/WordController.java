package com.dictionaryapp.controller;

import com.dictionaryapp.service.impl.LoggedUser;
import com.dictionaryapp.model.bindingmodels.WordAddBindingModel;
import com.dictionaryapp.service.WordService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WordController {

    private WordService wordService;
    private LoggedUser loggedUser;

    public WordController(WordService wordService, LoggedUser loggedUser) {
        this.wordService = wordService;
        this.loggedUser = loggedUser;
    }


    @GetMapping("/word/add")
    public ModelAndView add(@ModelAttribute("wordAddBindingModel")
                                WordAddBindingModel wordAddBindingModel){
        if(!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }
        return new ModelAndView("word-add");
    }

    @PostMapping("/word/add")
    public ModelAndView add(@ModelAttribute("wordAddBindingModel") @Valid
                                WordAddBindingModel wordAddBindingModel,
                            BindingResult bindingResult){
    boolean hasWordBeenAdded = this.wordService.addWord(wordAddBindingModel);

    if(!hasWordBeenAdded){
        return new ModelAndView("word-add");
    }
    return new ModelAndView("redirect:/home");
    }

    @GetMapping("/word/remove/{id}")
    public ModelAndView remove( @PathVariable("id") long id){
        if(!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }
        this.wordService.remove(id);
        return new ModelAndView("redirect:/home");
    }

    @GetMapping("word/remove/all")
    public ModelAndView removeAll(){
        if(!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }
        this.wordService.removeAll();
        return new ModelAndView("redirect:/home");
    }
}

