/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/**
 *
 * @author mooshahe
 */
public class CoffeeMachine {
    private int water = 400;
    private int milk = 540;
    private int beans = 120;
    private int cups = 9;
    private int money = 550; 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CoffeeMachine cm = new CoffeeMachine();
        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String input = sc.nextLine().toLowerCase();
            if (input.equals("remaining")) {
                cm.printSupplies();
            }
            if (input.equals("buy")) {
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu");
                String selection = sc.nextLine().toLowerCase();
                if (selection.equals("back")) {
                    continue;
                } else {
                    int choice = Integer.valueOf(selection);
                    cm.buy(choice);
                }
            }
            if (input.equals("fill")) {
                System.out.println("Write how many ml of water you want to add:");
                int water = Integer.valueOf(sc.nextLine());
                System.out.println("Write how many ml of milk you want to add:");
                int milk = Integer.valueOf(sc.nextLine());
                System.out.println("Write how many grams of coffee beans you want to add:");
                int beans = Integer.valueOf(sc.nextLine());
                System.out.println("Write how many disposable cups of coffee you want to add:");
                int cups = Integer.valueOf(sc.nextLine());
                cm.fill(water, milk, beans, cups);
            }
            if (input.equals("take")) {
                cm.take();
            }
            if (input.equals("exit")) {
                break;
            }
            System.out.println("");
        }
    }
    
    public void printSupplies() {
        System.out.println(String.format("The coffee machine has:\n%d ml of water\n%d ml of milk\n%d g of coffee beans\n%d disposable cups\n$%d of money\n", this.water, this.milk, this.beans, this.cups, this.money));
    }
    
    public void buy(int selection) {
        int water;
        int milk;
        int beans;
        int cups;
        if (selection == 1) {
            water = this.water - 250;
            beans = this.beans - 16;
            if (water >= 0 && beans >= 0) {
                System.out.println("I have enough resources, making you a coffee!");
                this.water = water;
                this.beans = beans;
                this.money += 4;
                this.cups -= 1;
            } else {
                if (water < 0) {
                    System.out.println("Sorry, not enough water!");
                }
                if (beans < 0) {
                    System.out.println("Sorry, not enough beans!");
                }
            }  
        }
        if (selection == 2) {
            water = this.water - 350;
            milk = this.milk - 75;
            beans = this.beans - 20;
            if (water >= 0 && milk >= 0 && beans >= 0) {
                System.out.println("I have enough resources, making you a coffee!");
                this.water = water;
                this.milk = milk;
                this.beans = beans;
                this.money += 7;
                this.cups -= 1;
            } else {
                if (water < 0) {
                    System.out.println("Sorry, not enough water!");
                }
                if (milk < 0) {
                    System.out.println("Sorry, not enough milk!");
                }
                if (beans < 0) {
                    System.out.println("Sorry, not enough beans!");
                }
            }
        }
        if (selection == 3) {
            water = this.water - 200;
            milk = this.milk - 100;
            beans = this.beans - 12;
            if (water >= 0 && milk >= 0 && beans >= 0) {
                System.out.println("I have enough resources, making you a coffee!");
                this.water = water;
                this.milk = milk;
                this.beans = beans;
                this.money += 6;
                this.cups -= 1;
            } else {
                if (water < 0) {
                    System.out.println("Sorry, not enough water!");
                }
                if (milk < 0) {
                    System.out.println("Sorry, not enough milk!");
                }
                if (beans < 0) {
                    System.out.println("Sorry, not enough beans!");
                }
            }
        }
    }
    
    public void fill(int water, int milk, int beans, int cups) {
        this.water += water;
        this.milk += milk;
        this.beans += beans;
        this.cups += cups;
    }
    
    public void take() {
        System.out.println("I gave you $" + this.money);
        this.money = 0;
    }
}
