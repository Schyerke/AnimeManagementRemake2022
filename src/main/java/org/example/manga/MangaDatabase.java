package org.example.manga;

public enum MangaDatabase {
    INSTANCE;

    private final Manga[] mangas = new Manga[100];
    private int mangaCount;

    public Manga[] findAll(){
        return mangas;
    }


    // throws an IllegalArgumentException if the manga is already in the database
    public void save(Manga manga) {
        //checks if the manga is already in the database
        if (findByName(manga.name()) != null) {
            throw new IllegalArgumentException("Manga already in database");
        }
        mangas[mangaCount++] = manga;
    }

    public Manga findByName(String name) {
        for (Manga manga : mangas) {
            if (manga.name().equals(name)) {
                return manga;
            }
        }
        return null;
    }

    public void deleteByName(String name) {
        for (int i = 0; i < mangaCount; i++) {
            Manga manga = mangas[i];
            if (manga.name().equals(name)) {
                mangas[i] = mangas[mangaCount - 1];
                mangas[mangaCount - 1] = null;
                mangaCount--;
                return;
            }
        }
    }

    public void deleteByManga(Manga manga) {
        for (int i = 0; i < mangaCount; i++) {
            Manga m = mangas[i];
            if (m.equals(manga)) {
                mangas[i] = mangas[mangaCount - 1];
                mangas[mangaCount - 1] = null;
                mangaCount--;
                return;
            }
        }
    }
}
