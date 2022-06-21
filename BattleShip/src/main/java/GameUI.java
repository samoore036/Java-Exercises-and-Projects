/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mooshahe
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class GameUI {
    private ArrayList<String> shipNames = new ArrayList<>();
    private Ship ship1 = new Ship();
    private Ship ship2 = new Ship();
    private Ship ship3 = new Ship();
    private ArrayList<Ship> ships = new ArrayList<>();
    private GameBoard board;
    private int guessCount = 0;
    
    public GameUI(GameBoard board) {
        this.board = board;   
    }
    
    private void setBoard() {
        this.createShips();
        for (Ship s : this.ships) {
            s.setLocations(this.board.placeShip(3));
        }
        
    }
    
    public void start() {
        this.setBoard();
        System.out.println(String.format("Your goal is to sink three ships: %s, %s, and %s.", this.ships.get(0).getName(), this.ships.get(1).getName(), this.ships.get(2).getName()));
        System.out.println("Try to sink them all in the fewest amount of guesses.");
        while (!this.ships.isEmpty()) {
            String guess = this.board.getUserInput("Enter a guess");
            this.checkGuess(guess);
        }
        System.out.println("All ships are sunk!");
        if (this.guessCount <= 18) {
            System.out.println(String.format("Good job! It only took %s guesses!",this.guessCount));
        } else {
            System.out.println(String.format("Took you long enough with %s guesses!", this.guessCount));
        }
    }
    
    public void createShips() {
        this.shipNames();
        ship1.setName(getRandomName());
        ship2.setName(getRandomName());
        ship3.setName(getRandomName());
        this.ships.add(ship1);
        this.ships.add(ship2);
        this.ships.add(ship3);
    }
    
    private void checkGuess(String guess) {
        this.guessCount++;
        String result = "miss";
        
        for (Ship s : this.ships) {
            result = s.checkYourself(guess);
            if (result.equals("hit")) {
                break;
            }
            if (result.equals("kill")) {
                System.out.println(String.format("You sunk %s!",s.getName()));
                this.ships.remove(s);
                break;
            }
        }
        System.out.println(result);
    }
    
    private String getRandomName() {
        int randomIndex = new Random().nextInt(this.shipNames.size());
        String shipName = this.shipNames.get(randomIndex);
        this.shipNames.remove(randomIndex);
        return shipName;
    }
    
    private void shipNames() {
        this.shipNames.add("USS Bonhomme Richard");
        this.shipNames.add("Queen Mary");
        this.shipNames.add("The Titanic");
        this.shipNames.add("The Bismarck");
        this.shipNames.add("USS Constitution");
        this.shipNames.add("RMS Lusitania");
        this.shipNames.add("Santa Maria");
        this.shipNames.add("Mayflower");
        this.shipNames.add("The Golden Hinde");
        this.shipNames.add("Cutty Sark");
        this.shipNames.add("Yamato");
        this.shipNames.add("Acheron");
        this.shipNames.add("The Black Swan");
        this.shipNames.add("USS Dallas");
        this.shipNames.add("The Flying Dutchman");
        this.shipNames.add("Nautilus");
        this.shipNames.add("Pequod");
    }
}
