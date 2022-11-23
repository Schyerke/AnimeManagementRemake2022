package org.example.anime;

import org.example.genre.Genre;

import java.util.Scanner;

public enum AnimeManager {
    INSTANCE;
    public void addAnime() {
        try {
            AnimeDatabase.INSTANCE.save(createAnime());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch(Exception e){ e.printStackTrace(); }
    }

    public void deleteAnime() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter anime name: ");
        String name = scanner.nextLine();
        AnimeDatabase.INSTANCE.deleteByName(name);
    }

    private Anime createAnime(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter anime name: ");
        String name = scanner.nextLine();
        Genre userGenre;
        while(true){
            System.out.println("Enter anime genre: ");
            String genre = scanner.nextLine();
            userGenre = Genre.map(genre);
            if(userGenre != null){
                break;
            }
            System.out.println("No such genre");
        }
        System.out.println("Enter anime rating: ");
        String rating = scanner.nextLine();
        return new Anime(name, userGenre, rating);
    }
}
