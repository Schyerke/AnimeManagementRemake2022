package org.example.genre;

import java.util.Arrays;

public enum Genre {
    ACTION("action"),
    ADVENTURE("adventure"),
    COMEDY("comedy"),
    DRAMA("drama"),
    FANTASY("fantasy"),
    HISTORICAL("historical"),
    HORROR("horror"),
    MYSTERY("mystery"),
    ROMANCE("romance"),
    SCI_FI("sci-fi"),
    SLICE_OF_LIFE("slice of life"),
    THRILLER("thriller");

    private final String genre;

    Genre(String genre) {
        this.genre = genre;
    }

    public String genre() {
        return genre;
    }

    public static Genre map(String genre){
        return Arrays.stream(Genre.values())
                .filter(g -> g.genre().equals(genre))
                .findFirst()
                .orElse(null);
    }

}
