package machine;

import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        while (coffeeMachine.currentState != State.SHUTDOWN) {
            coffeeMachine.showMessage();
            System.out.println();
            coffeeMachine.handle(scanner.next());
            System.out.println();
        }
    }

    private enum State {
        WAITING("Write action (buy, fill, take, remaining, exit):"),
        BUY("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:"),
        FILL_WATER("Write how many ml of water do you want to add:"),
        FILL_MILK("Write how many ml of milk do you want to add:"),
        FILL_COFFEE("Write how many grams of coffee beans do you want to add:"),
        FILL_CUPS("Write how many disposable cups of coffee do you want to add:"),
        SHUTDOWN("Bey, bey!");

        private final String message;

        State(String message) {
            this.message = message;
        }
    }

    private State currentState = State.WAITING; // The machine starts in the WAITING status
    private int money;
    private int water;
    private int milk;
    private int coffee;
    private int cups;

    public CoffeeMachine(int money, int water, int milk, int coffee, int cups) {
        this.money = money;
        this.water = water;
        this.milk = milk;
        this.coffee = coffee;
        this.cups = cups;
    }

    public CoffeeMachine() {
        this(550, 400, 540, 120, 9);
    }

    public void showMessage() {
        System.out.println(currentState.message);
    }

    public void handle(String input) {
        switch (currentState) {
            case WAITING:
                switch (input) {
                    case "buy":
                        currentState = State.BUY;
                        break;
                    case "fill":
                        currentState = State.FILL_WATER;
                        break;
                    case "take":
                        take();
                        break;
                    case "remaining":
                        printState();
                        break;
                    case "exit":
                        currentState = State.SHUTDOWN;
                        break;
                    default:
                        System.err.println("ERROR: Invalid Input: " + input);
                        currentState = State.WAITING;
                        break;
                }
                break;
            case BUY:
                currentState = buy(input);
                break;
            case FILL_WATER:
            case FILL_MILK:
            case FILL_COFFEE:
            case FILL_CUPS:
                currentState = fill(input);
                break;
            default: // ERROR
                System.err.println("ERROR: Invalid State");
                currentState = State.SHUTDOWN;
                break;
        }
    }

    private void printState() {
        String state = String.format("The coffee machine has:\n" +
                "%d of water\n" +
                "%d of milk\n" +
                "%d of coffee beans\n" +
                "%d of disposable cups\n" +
                "%d of money", water, milk, coffee, cups, money);
        System.out.println(state);
    }

    private State fill(String amount) {
        try {
            switch (currentState) {
                case FILL_WATER:
                    water += Integer.valueOf(amount);
                    return State.FILL_MILK;
                case FILL_MILK:
                    milk += Integer.valueOf(amount);
                    return State.FILL_COFFEE;
                case FILL_COFFEE:
                    coffee += Integer.valueOf(amount);
                    return State.FILL_CUPS;
                case FILL_CUPS:
                    cups += Integer.valueOf(amount);
            }
        } catch (NumberFormatException ex) {
            System.err.println("ERROR: Invalid Input: " + amount);
            return currentState;
        }
        return State.WAITING;
    }

    private State buy(String order) {
        int reqWater = 0;
        int reqMilk = 0;
        int reqCoffee = 0;
        int price = 0;
        switch (order) {
            case "1": // espresso
                reqWater = 250;
                reqMilk = 0;
                reqCoffee = 16;
                price = 4;
                if (hasEnoughResources(reqWater, reqMilk, reqCoffee)) {
                    makeCoffee(reqWater, reqMilk, reqCoffee, price);
                }
                break;
            case "2": // latte
                reqWater = 350;
                reqMilk = 75;
                reqCoffee = 20;
                price = 7;
                if (hasEnoughResources(reqWater, reqMilk, reqCoffee)) {
                    makeCoffee(reqWater, reqMilk, reqCoffee, price);
                }
                break;
            case "3": // cappuccino
                reqWater = 200;
                reqMilk = 100;
                reqCoffee = 12;
                price = 6;
                if (hasEnoughResources(reqWater, reqMilk, reqCoffee)) {
                    makeCoffee(reqWater, reqMilk, reqCoffee, price);
                }
                break;
            case "back":
                break;
            default: // ERROR
                System.err.println("ERROR: Invalid Input: " + order);
                return State.BUY;
        }
        return State.WAITING;
    }

    private boolean hasEnoughResources(int reqWater, int reqMilk, int reqCoffee) {
        if (water < reqWater) {
            System.out.println("Sorry, not enough water!");
            return false;
        }
        if (milk < reqMilk) {
            System.out.println("Sorry, not enough milk!");
            return false;
        }
        if (coffee < reqCoffee) {
            System.out.println("Sorry, not enough coffee!");
            return false;
        }
        System.out.println("I have enough resources, making you a coffee!");
        return true;
    }

    private void makeCoffee(int reqWater, int reqMilk, int reqCoffee, int price) {
        cups -= 1;
        water -= reqWater;
        milk -= reqMilk;
        coffee -= reqCoffee;
        money += price;
    }

    private void take() {
        System.out.println("I gave you " + money);
        money = 0;
    }
}
