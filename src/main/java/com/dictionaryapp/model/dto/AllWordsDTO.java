package com.dictionaryapp.model.dto;

import java.util.Set;

public class AllWordsDTO {

    private Set<WordDTO> germanWordSet;
    private Set<WordDTO> spanishWordSet;
    private Set<WordDTO> frenchWordSet;
    private Set<WordDTO> italianWordSet;

    private int germanWordsCount;
    private int frenchWordsCount;
    private int italianWordsCount;
    private int spanishWordsCount;
    public int AllWordsCount;

    public AllWordsDTO() {
    }

    public AllWordsDTO(Set<WordDTO> germanWordSet, Set<WordDTO> spanishWordSet, Set<WordDTO> frenchWordSet, Set<WordDTO> italianWordSet) {
        this.germanWordSet = germanWordSet;
        this.spanishWordSet = spanishWordSet;
        this.frenchWordSet = frenchWordSet;
        this.italianWordSet = italianWordSet;
    }

    public int getGermanWordsCount() {
        if(germanWordSet.isEmpty()){
            return 0;
        }
        return germanWordSet.size();
    }

    public int getFrenchWordsCount() {
        if(frenchWordSet.isEmpty()){
            return 0;
        }
        return frenchWordSet.size();
    }

    public int getItalianWordsCount() {
        if(italianWordSet.isEmpty()){
            return 0;
        }
        return italianWordSet.size();
    }

    public int getSpanishWordsCount() {
        if(spanishWordSet.isEmpty()){
            return 0;
        }
        return spanishWordSet.size();
    }

    public int getAllWordsCount() {
        return getGermanWordsCount() + getSpanishWordsCount() + getFrenchWordsCount() + getItalianWordsCount();
    }

    public Set<WordDTO> getGermanWordSet() {
        return germanWordSet;
    }

    public void setGermanWordSet(Set<WordDTO> germanWordSet) {
        this.germanWordSet = germanWordSet;
    }

    public Set<WordDTO> getSpanishWordSet() {
        return spanishWordSet;
    }

    public void setSpanishWordSet(Set<WordDTO> spanishWordSet) {
        this.spanishWordSet = spanishWordSet;
    }

    public Set<WordDTO> getFrenchWordSet() {
        return frenchWordSet;
    }

    public void setFrenchWordSet(Set<WordDTO> frenchWordSet) {
        this.frenchWordSet = frenchWordSet;
    }

    public Set<WordDTO> getItalianWordSet() {
        return italianWordSet;
    }

    public void setItalianWordSet(Set<WordDTO> italianWordSet) {
        this.italianWordSet = italianWordSet;
    }
}
