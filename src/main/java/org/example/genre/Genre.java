package org.example.genre;

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

}
