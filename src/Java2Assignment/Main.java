package Java2Assignment;

import java.io.IOException;
import java.util.List;

import static Java2Assignment.TicketList.addNormalTicket;

public class Main {

    /**
     * The main driver has and initialization and a run command
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        StartUp.initialization();
        runApplication();
    }
    private static boolean normal;
    /**
     * run the loop for user interface and in/out
     */
    private static void runApplication() throws IOException {
        PaymentList.retrieveOtherTotals();
        UserInterface ui = UserInterface.getUserInterface();
        int userChoice = 0;
        do {
            userChoice = ui.uiMenu();
            //check into the garage
            if(userChoice == 1 && !UserInterface.isInGarage()){
                normal = true;
                UserInterface.setInGarage();

                //check into a special event
            }else if(userChoice == 2 && !UserInterface.isInGarage()){
                normal = false;
                UserInterface.setInGarage();

                //check out of the garage with your ticket
            } else if(userChoice == 1 && UserInterface.isInGarage()){
                //userTick.clockOut();
                if(normal) {
                    TicketList.addNormalTicket(false);
                }else{
                    TicketList.addSpecialTicket(false);
                }
                UserInterface.setOutGarage();

                //check out of the garage without your ticket
            }else if(userChoice == 2 && UserInterface.isInGarage()){
                if(normal) {
                    TicketList.addNormalTicket(true);
                }else{
                    TicketList.addSpecialTicket(true);
                }
                UserInterface.setOutGarage();
            }
        }while(userChoice != 3);

        //upload to the file
        TicketList.listToFile();

        //if the loop is exited then exit the program
        System.exit(1);
    }



}
