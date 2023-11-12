package com.dictionaryapp.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@Table(name = "words")
public class Word extends BaseEntity {
    @NotNull
    @Size(min = 2, max = 40)
    private String term;
    @NotNull
    @Size(min = 2, max = 80)
    private String translation;
    @Size(min = 2, max = 200)
    private String example;
    @NotNull
    @Column(name = "input_date")
    private LocalDate inputDate;

    @NotNull
    @ManyToOne
    private Language language;

    @ManyToOne
    private User addedBy;

    public Word(String term, String translation, String example, String inputDate, Language language, User addedBy) {
        this.term = term;
        this.translation = translation;
        this.example = example;
        this.inputDate = LocalDate.parse(inputDate);
        this.language = language;
        this.addedBy = addedBy;
    }

    public Word() {
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

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public LocalDate getInputDate() {
        return inputDate;
    }

    public void setInputDate(LocalDate inputDate) {
        this.inputDate = inputDate;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public User getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(User addedBy) {
        this.addedBy = addedBy;
    }
}
