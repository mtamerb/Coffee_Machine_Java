package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private static int water = 400;
    private static int milk = 540;
    private static int beans = 120;
    private static int cups = 9;
    private static int money = 550;
    private static int waterNeeded = 0;
    private static int milkNeeded = 0;
    private static int beansNeeded = 0;
    private static int moneyNeeded = 0;

    public static void main(String[] args) {
        action();
    }

    public static void action() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String command = sc.nextLine();
        switch (command) {
            case "buy":
                buy(sc);
                break;
            case "fill":
                fill(sc);
                break;
            case "take":
                take();
                break;
            case "remaining":
                remaining();
                break;
            case "exit":
                break;
            default:
                System.out.println("Unknown action.");
                action();
        }
    }

    public static void remaining() {
        System.out.println("The coffee machine has:");
        System.out.printf("%d of water\n", water);
        System.out.printf("%d of milk\n", milk);
        System.out.printf("%d of coffee beans\n", beans);
        System.out.printf("%d of of disposable cups\n", cups);
        System.out.printf("$%d of money\n\n", money);
        action();
    }

    public static void buy(Scanner sc) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String menu = sc.nextLine();

        switch (menu) {
            case "1": // espresso
                waterNeeded = 250;
                milkNeeded = 0;
                beansNeeded = 16;
                moneyNeeded = 4;
                checking();
                action();
                break;
            case "2": // latte
                waterNeeded = 350;
                milkNeeded = 75;
                beansNeeded = 20;
                moneyNeeded = 7;
                checking();
                action();
                break;
            case "3": // cappuccino
                waterNeeded = 200;
                milkNeeded = 100;
                beansNeeded = 12;
                moneyNeeded = 6;
                checking();
                action();
                break;
            case "back": // back
                action();
                break;
            default:
                System.out.println("Unknown coffee type");
                buy(sc);
                break;
        }
    }

    public static void fill(Scanner sc) {
        System.out.println("Write how many ml of water do you want to add: ");
        water += sc.nextInt();
        System.out.println("Write how many ml of milk do you want to add: ");
        milk += sc.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        beans += sc.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        cups += sc.nextInt();
        action();
    }

    public static void take() {
        System.out.printf("I gave you $%d\n\n", money);
        money = 0;
        action();
    }

    public static void checking() {
        if (water < waterNeeded) {
            System.out.println("Sorry, not enough water!\n");
        } else if (milk < milkNeeded) {
            System.out.println("Sorry, not enough milk!\n");
        } else if (beans < beansNeeded) {
            System.out.println("Sorry, not enough coffee beans!\n");
        } else if (cups < 1) {
            System.out.println("Sorry, not enough disposable cups!\n");
        } else {
            System.out.println("I have enough resources, making you a coffee!\n");
            water -= waterNeeded;
            milk -= milkNeeded;
            beans -= beansNeeded;
            cups -= 1;
            money += moneyNeeded;
        }
    }

}
