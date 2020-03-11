package Java2Assignment;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        runApplication();
    }

    /**
     * run the loop for user interface and in/out
     */
    private static void runApplication(){
        //TicketList userTick = TicketList.getTickets();
        UserInterface ui = UserInterface.getUserInterface();
        //List<Ticket> ticketList = new List<userTick>();
        int userChoice = 0;
        do {
            userChoice = ui.uiMenu();
            if(userChoice == 1 && !UserInterface.isInGarage()){
                TicketList.addTicketToList(false);
                UserInterface.setInGarage();
            }else if(userChoice == 1){
                //userTick.clockOut();
                TicketList.addTicketToList(false);
                UserInterface.setOutGarage();
            }else if(userChoice == 2){
                TicketList.addTicketToList(true);
                UserInterface.setOutGarage();
            }
        }while(userChoice != 3);
        //if the loop is exited then exit the program
        System.exit(1);
    }


}