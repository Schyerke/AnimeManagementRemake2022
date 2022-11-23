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
        return animes.stream().filter(anime -> anime.name().equals(name)).findFirst().orElse(null);
    }

    public void save(Anime anime) {
        if (findByName(anime.name()) != null) {
            throw new IllegalArgumentException("Anime already in database");
        }
        animes.add(anime);
        System.out.println("Anime added");
    }
    public Anime findByName(Anime anime){
        return animes.stream().filter(anime1 -> anime1.name().equals(anime.name())).findFirst().orElse(null);
    }

    public boolean deleteByName(String name) {
        return animes.removeIf(anime -> anime.name().equals(name));
    }

    public void deleteByAnime(Anime anime) {
        animes.remove(anime);
        System.out.println("Anime deleted");
    }

}
