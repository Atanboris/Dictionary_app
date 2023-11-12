package com.dictionaryapp.model.entity;

import com.dictionaryapp.model.enums.LanguageNames;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "languages")
public class Language extends BaseEntity {
    @NotNull
    @Enumerated(EnumType.STRING)
    private LanguageNames name;
    @NotNull
    private String description;

    public LanguageNames getName() {
        return name;
    }

    public void setName(LanguageNames name) {
        this.name = name;
        setDescription(name);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(LanguageNames languageNames) {
        String description = "";
        switch (languageNames){
            case FRENCH: description =
                    "A Romance language spoken worldwide, known for its elegance and cultural richness. It's the official language of France and numerous nations, famed for its cuisine, art, and literature.";
            break;
            case GERMAN: description =
                    "A West Germanic language, is spoken by over 90 million people worldwide. Known for its complex grammar and compound words, it's the official language of Germany and widely used in Europe.";
            break;
            case ITALIAN: description =
                    "A Romance language spoken in Italy and parts of Switzerland, with rich cultural heritage. Known for its melodious sounds, it's a gateway to Italian art, cuisine, and history.";
            break;
            case SPANISH: description =
                    "A Romance language, is spoken by over 460 million people worldwide. It boasts a rich history, diverse dialects, and is known for its melodious sound, making it a global cultural treasure.";
            break;
        }
        this.description = description;
    }
}
