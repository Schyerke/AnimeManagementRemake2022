package org.example.menu;

import org.example.anime.AnimeManager;
import org.example.manga.MangaManager;
import org.example.session.SessionManager;
import org.example.user.UserHelper;

import java.util.Scanner;

import static org.example.console.ConsoleUtils.clearScreen;

public class MainMenu  {

    private final String MESSAGE;
    private static final String EXIT = "exit";

    public MainMenu(){
        MESSAGE = getUserMessage();
    }

    public void start() {
        System.out.println(MESSAGE);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        clearScreen();
        if(input.equals(EXIT)){
            System.out.println("Exiting...");
            System.exit(0);
        }
        if(SessionManager.isLoggedIn()){
            userLoggedInChoice(input);
        } else{
            userNotLoggedInChoice(input);
        }
        start();
    }

    private void userLoggedInChoice(String input){
        switch (input){
            case "1" -> UserHelper.showProfile();
            case "2" -> AnimeManager.INSTANCE.addAnime();
            case "3" -> MangaManager.INSTANCE.addManga();
            case "4" -> AnimeManager.INSTANCE.deleteAnime();
            case "5" -> MangaManager.INSTANCE.deleteMangaByName();
            default -> System.out.println("Invalid input");
        }
    }

    private void userNotLoggedInChoice(String input){
        switch (input) {
            case "1" -> SessionManager.login();
            case "2" -> SessionManager.signup();
            default -> System.out.println("Invalid input");
        }
    }


    private String getUserMessage(){
        StringBuilder sb = new StringBuilder();
        if(SessionManager.isLoggedIn()){
            sb.append("Welcome back, ").append(SessionManager.getUser().getUsername()).append("!\n");
            sb.append("""
                    1: View your profile
                    2: Add a new anime
                    3: Add a new manga
                    4: Delete an anime
                    5: Delete a manga
                    "exit": Exit the program
                    """);
        } else {
            sb.append("Welcome to the application!\n");
            sb.append("""
                    1: Log in
                    2: Sign up
                    "exit": Exit the program
                    """);
        }
        return sb.toString();
    }

}
