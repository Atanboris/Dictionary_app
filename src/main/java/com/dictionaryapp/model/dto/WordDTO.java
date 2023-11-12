package com.dictionaryapp.model.dto;

public class WordDTO {
    private String term;
    private String translation;
    private String username;
    private String inputDate;
    private String example;
    private Long id;


    public WordDTO(String term, String translation, String username, String inputDate,String example, Long id) {
        this.term = term;
        this.translation = translation;
        this.username = username;
        this.inputDate = inputDate;
        this.example = example;
        this.id = id;
    }

    public WordDTO() {
    }

    public String getExample() {
        return example;
    }

    public Long getId() {
        return id;
    }

    public void setExample(String example) {
        this.example = example;
    }

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getInputDate() {
        return inputDate;
    }

    public void setInputDate(String inputDate) {
        this.inputDate = inputDate;
    }
}
