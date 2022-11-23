package org.example.user;

import org.example.anime.Anime;
import org.example.anime.AnimeDatabase;
import org.example.manga.Manga;
import org.example.manga.MangaDatabase;
import org.example.session.SessionManager;

import java.util.List;

public class UserHelper {
    public static void showProfile() {
        User user = SessionManager.INSTANCE.getUser();
        System.out.println();
        System.out.println("User: " + user.getUsername());
        System.out.println("Email: " + user.getEmail());
        List<Manga> mangas = MangaDatabase.INSTANCE.findAll();
        List<Anime> animes = AnimeDatabase.INSTANCE.findAll();

        System.out.println("Mangas: ");
        for (Manga manga : mangas) {
            System.out.println(manga.name());
        }

        System.out.println("Animes: ");
        for (Anime anime : animes) {
            System.out.println(anime.name());
        }

        System.out.println();
    }
}
