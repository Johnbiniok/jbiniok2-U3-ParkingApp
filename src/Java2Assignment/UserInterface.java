package Java2Assignment;

import java.util.Scanner;

public class UserInterface {
    public static boolean inGarage = false;
    private static Scanner keyboard = new Scanner(System.in);
    private static UserInterface instance = null;
    private static Ticket userTicket;
    private UserInterface(){

    }
    public static UserInterface getUserInterface() {
        if (instance == null) {
            instance = new UserInterface();
        }
        return instance;
    }

    /**
     * if they are not in the garage, run program to start garage/ticket, if they are then run to close garage/ticket
     * @return the users choice of start ticket, close ticket, or close garage(1-3)
     */
    public int uiMenu(){
        int currentChoice;
        if(!inGarage){
            displayIn();
            currentChoice = keyboard.nextInt();
            return currentChoice;
            //if they are in the garage, set program to close garage/ticket
        }else{
            displayOut();
            currentChoice = keyboard.nextInt();
            return currentChoice;
        }
    }

    /**
     * find if the car is inside or outside of the garage
     * @return true if in the garage and false if not
     */
    public static boolean isInGarage(){
        return inGarage;
    }
    public static void setInGarage(){
        inGarage = true;
    }
    public static void setOutGarage(){
        inGarage = false;
    }

    /**
     * message to be displayed every time
     */
    public void startMessage(){
        System.out.println("Welcome to park-o-mania");
    }

    /**
     * display menu to bring car into garage
     */
    private void displayIn(){
        startMessage();
        System.out.println("1. Check In");
        System.out.println("3. Close Garage");
    }

    /**
     * display menu to take out a car
     */
    private void displayOut(){
        startMessage();
        System.out.println("1. Check Out");
        System.out.println("2. Lost Ticket");
    }





}
