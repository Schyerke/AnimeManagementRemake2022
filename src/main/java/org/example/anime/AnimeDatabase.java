package org.example.anime;

import java.util.ArrayList;
import java.util.List;

public enum AnimeDatabase {
    INSTANCE;
    // suppress this warning
    private final List<Anime> animes = new ArrayList<>();

    public List<Anime> findAll(){
        return animes;
    }

    public Anime findByName(String name) {
        for (Anime anime : animes) {
            if (anime.name().equals(name)) {
                System.out.println("Found " + anime.name());
                return anime;
            }
        }
        System.out.println("No such anime");
        return null;
    }

    public void save(Anime anime) {
        if (findByName(anime.name()) != null) {
            throw new IllegalArgumentException("Anime already in database");
        }
        animes.add(anime);
        System.out.println("Anime added");
    }
    public Anime findByName(Anime anime){
        for (Anime _anime : animes) {
            if (_anime.name().equals(anime.name())) {
                System.out.println("Found " + _anime.name());
                return _anime;
            }
        }
        System.out.println("No such anime");
        return null;
    }

    public void deleteByName(String name) {
        Anime anime = findByName(name);
        if (anime != null) {
            animes.remove(anime);
            System.out.println("Anime deleted");
        }
        else {
            System.out.println("No such anime");
        }
    }

    public void deleteByAnime(Anime anime) {
        animes.remove(anime);
        System.out.println("Anime deleted");
    }

}
