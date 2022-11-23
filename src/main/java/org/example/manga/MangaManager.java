package org.example.manga;

import org.example.genre.Genre;

import java.util.Scanner;

public enum MangaManager {
    INSTANCE;

    public void addManga() {
        try {
            MangaDatabase.INSTANCE.save(createManga());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch(Exception e){ e.printStackTrace(); }
    }

    public void deleteMangaByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter manga name: ");
        String name = scanner.nextLine();
        MangaDatabase.INSTANCE.deleteByName(name);
    }

    private Manga createManga(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter manga name: ");
        String name = scanner.nextLine();
        Genre userGenre;
        while(true){
            System.out.println("Enter manga genre: ");
            String genre = scanner.nextLine();
            userGenre = Genre.map(genre);
            if(userGenre != null){
                break;
            }
            System.out.println("No such genre");
        }
        System.out.println("Enter manga rating: ");
        String rating = scanner.nextLine();
        return new Manga(name, userGenre, rating);
    }
}
