package org.example.manga;

import org.example.genre.Genre;

public record Manga(String name, Genre genre, String rating)  {

    @Override
    public String toString() {
        return "Manga{" +
                "name='" + name + '\'' +
                ", genre=" + genre +
                ", rating='" + rating + '\'' +
                '}';
    }

}
