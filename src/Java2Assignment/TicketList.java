package Java2Assignment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class TicketList {
    private static List<Ticket> ticketList = new ArrayList<>();
    private static TicketList instance = null;

    public static List<Ticket> getTicketList(){
        return ticketList;
    }

    /**
     * method that essentially adds the ticket that has been generated randomly to a cumulative list of all tickets
     * @param lostTicket boolean that will be true if the ticket is lost
     */
    static void addTicketToList(boolean lostTicket){
        ticketList.add(new Ticket(MachineIn.userRandomDate(2012, 2020), MachineIn.IntBetween(7, 12), MachineIn.sameDay(), MachineIn.IntBetween(13, 23), lostTicket));
    }

    /**
     * Method that is used to display the total paydata in paymentlist and then also write to the file
     * @throws IOException
     */
    public static void listToFile() throws IOException {
        PaymentList.payData();
        FileWrite fw = new FileWrite(ticketList);
    }

}
