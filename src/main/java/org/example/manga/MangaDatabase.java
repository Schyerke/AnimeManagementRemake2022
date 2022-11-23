package org.example.manga;

import java.util.ArrayList;
import java.util.List;

public enum MangaDatabase {
    INSTANCE;

    private final List<Manga> mangas = new ArrayList<>();

    public List<Manga> findAll(){
        return mangas;
    }

    // throws an IllegalArgumentException if the manga is already in the database
    public void save(Manga manga) {
        //checks if the manga is already in the database
        if (findByName(manga.name()) != null) {
            throw new IllegalArgumentException("Manga already in database");
        }
        mangas.add(manga);
        System.out.println("Manga added");
    }

    public Manga findByName(String name) {
        return mangas.stream().filter(manga -> manga.name().equals(name)).findFirst().orElse(null);
    }

    public boolean deleteByName(String name) {
        return mangas.removeIf(manga -> manga.name().equals(name));
    }

    public void deleteByManga(Manga manga) {
        mangas.remove(manga);
        System.out.println("Manga deleted");
    }
}
