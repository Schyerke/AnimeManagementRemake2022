package org.example.anime;

import org.example.genre.Genre;

public record Anime(String name, Genre genre, String rating) {

    @Override
    public String toString() {
        return "Anime{" +
                "name='" + name + '\'' +
                ", genre=" + genre +
                ", rating='" + rating + '\'' +
                '}';
    }
}
