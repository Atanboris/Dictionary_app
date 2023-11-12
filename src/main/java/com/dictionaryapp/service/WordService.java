package com.dictionaryapp.service;

import com.dictionaryapp.model.bindingmodels.WordAddBindingModel;
import com.dictionaryapp.model.dto.AllWordsDTO;

public interface WordService {
    boolean addWord(WordAddBindingModel wordAddBindingModel);

    AllWordsDTO findAllWordsForHomepage();

    void remove(long id);

    void removeAll();
}
