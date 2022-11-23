package org.example.anime;

public enum AnimeDatabase {
    INSTANCE;
    // suppress this warning
    private final Anime[] animes = new Anime[100];
    private int animeCount;

    public Anime[] findAll(){
        return animes;
    }

    public Anime findByName(String name) {
        for (Anime anime : animes) {
            if (anime.name().equals(name)) {
                return anime;
            }
        }
        return null;
    }

    public void save(Anime anime) {
        animes[animeCount++] = anime;
    }
    public Anime findByName(Anime anime){
        for (Anime a : animes) {
            if (a.name().equals(anime.name())) {
                return a;
            }
        }
        return null;
    }

    public void deleteByName(String name) {
        for (int i = 0; i < animeCount; i++) {
            Anime anime = animes[i];
            if (anime.name().equals(name)) {
                animes[i] = animes[animeCount - 1];
                animes[animeCount - 1] = null;
                animeCount--;
                return;
            }
        }
    }

    public void deleteByAnime(Anime anime) {
        for (int i = 0; i < animeCount; i++) {
            Anime a = animes[i];
            if (a.equals(anime)) {
                animes[i] = animes[animeCount - 1];
                animes[animeCount - 1] = null;
                animeCount--;
                return;
            }
        }
    }

}
