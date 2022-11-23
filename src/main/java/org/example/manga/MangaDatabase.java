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
        for (Manga manga : mangas) {
            if (manga.name().equals(name)) {
                System.out.println("Found " + manga.name());
                return manga;
            }
        }
        System.out.println("No such manga");
        return null;
    }

    public void deleteByName(String name) {
        Manga manga = findByName(name);
        if (manga != null) {
            mangas.remove(manga);
            System.out.println("Manga deleted");
        }
        else {
            System.out.println("No such manga");
        }
    }

    public void deleteByManga(Manga manga) {
        mangas.remove(manga);
        System.out.println("Manga deleted");
    }
}
