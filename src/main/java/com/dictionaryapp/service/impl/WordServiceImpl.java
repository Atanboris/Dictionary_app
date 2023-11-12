package com.dictionaryapp.service.impl;

import com.dictionaryapp.model.bindingmodels.WordAddBindingModel;
import com.dictionaryapp.model.dto.AllWordsDTO;
import com.dictionaryapp.model.dto.WordDTO;
import com.dictionaryapp.model.entity.Language;
import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.model.entity.Word;
import com.dictionaryapp.model.enums.LanguageNames;
import com.dictionaryapp.repo.LanguageRepository;
import com.dictionaryapp.repo.UserRepository;
import com.dictionaryapp.repo.WordRepository;
import com.dictionaryapp.service.WordService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class WordServiceImpl implements WordService {
    private WordRepository wordRepository;
    private LanguageRepository languageRepository;
    private UserRepository userRepository;
    private LoggedUser loggedUser;

    public WordServiceImpl(WordRepository wordRepository, LanguageRepository languageRepository, UserRepository userRepository, LoggedUser loggedUser) {
        this.wordRepository = wordRepository;
        this.languageRepository = languageRepository;
        this.userRepository = userRepository;
        this.loggedUser = loggedUser;
    }

    @Override
    public boolean addWord(WordAddBindingModel wordAddBindingModel) {
        if(wordAddBindingModel == null){
            return false;
        }
        if(wordAddBindingModel.getLanguage() == null){
            return false;
        }
        String term = wordAddBindingModel.getTerm();
        String translation = wordAddBindingModel.getTranslation();
        String example = wordAddBindingModel.getExample();
        String inputDate = wordAddBindingModel.getInputDate();
        Language language =this.languageRepository.findByName(wordAddBindingModel.getLanguage());

        if(term.isBlank() || translation.isBlank() || example.isBlank()){
            return false;
        }
        User user = userRepository.findByUsername(loggedUser.getUsername());

        Word word = new Word(term,translation,example,inputDate,language,user);


        this.wordRepository.save(word);
        return true;
    }

    @Override
    public AllWordsDTO findAllWordsForHomepage() {
        List<Word> allWords = this.wordRepository.findAll();

        Set<WordDTO> germanWords = new HashSet<>();
        Set<WordDTO> frenchWords = new HashSet<>();
        Set<WordDTO> italianWords = new HashSet<>();
        Set<WordDTO> spanishWords = new HashSet<>();

        for (Word word: allWords) {
            LanguageNames name = word.getLanguage().getName();
            WordDTO wordDTO = new WordDTO(word.getTerm(),
                    word.getTranslation(),
                    word.getAddedBy().getUsername(),
                    word.getInputDate().toString(),
                    word.getExample(),
                    word.getId());

            switch (name){
                case GERMAN:germanWords.add(wordDTO);
                break;
                case FRENCH:frenchWords.add(wordDTO);
                break;
                case ITALIAN:italianWords.add(wordDTO);
                break;
                case SPANISH:spanishWords.add(wordDTO);
                break;
            }
        }
        return new AllWordsDTO(germanWords,spanishWords,frenchWords,italianWords);

    }

    @Override
    public void remove(long id) {
        this.wordRepository.deleteById(id);
    }

    @Override
    public void removeAll() {
        this.wordRepository.deleteAll();
    }
}
