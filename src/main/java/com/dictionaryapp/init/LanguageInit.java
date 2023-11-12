package com.dictionaryapp.init;

import com.dictionaryapp.model.entity.Language;
import com.dictionaryapp.model.enums.LanguageNames;
import com.dictionaryapp.repo.LanguageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

    @Component
    public class LanguageInit implements CommandLineRunner {
       private final LanguageRepository languageRepository;

        public LanguageInit(LanguageRepository languageRepository) {
            this.languageRepository = languageRepository;
        }

        @Override
        public void run(String... args){
            boolean hasLanguages = languageRepository.count() > 0;
            if (!hasLanguages) {
                List<Language> languages = new ArrayList<>();
                Arrays.stream(LanguageNames.values())
                        .forEach(languageName -> {
                            Language language = new Language();
                            language.setName(languageName);
                            languages.add(language);
                        });
                languageRepository.saveAll(languages);
            }
        }
    }

