package com.dictionaryapp.model.bindingmodels;

import com.dictionaryapp.model.enums.LanguageNames;
import com.dictionaryapp.validation.StringDateIsInPresentOrPast;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class WordAddBindingModel {
    @Size(min = 2, max = 40, message = "The term length must be between 2 and 40 characters!")
    private String term;
    @Size(min = 2, max = 80, message = "The translation length must be between 2 and 80 characters!")
    private String translation;
    @Size(min = 2, max = 200, message = "The example length must be between 2 and 200 characters!")
    private String example;
    @StringDateIsInPresentOrPast(message = "The input date must be in the past or present!")
    private String inputDate;
    @NotNull(message = "You must select a language!")
    private LanguageNames language;

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getInputDate() {
        return inputDate;
    }

    public void setInputDate(String inputDate) {
        this.inputDate = inputDate;
    }

    public LanguageNames getLanguage() {
        return language;
    }

    public void setLanguage(LanguageNames language) {
        this.language = language;
    }
}
