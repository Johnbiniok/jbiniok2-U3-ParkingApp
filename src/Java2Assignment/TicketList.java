package Java2Assignment;

import java.util.ArrayList;
import java.util.List;

public class TicketList {
    private static List<Ticket> ticketList = new ArrayList<>();
    private static TicketList instance = null;

    private TicketList(){

    }

    public static List<Ticket> getTicketList(){
        return ticketList;
    }

    static void addTicketToList(boolean lostTicket){
        ticketList.add(new Ticket(MachineIn.userRandomDate(2012, 2020), MachineIn.IntBetween(7, 12), MachineIn.sameDay(), MachineIn.IntBetween(13, 23), lostTicket));
    }
    public static TicketList getTickets() {
        if (instance == null) {
            instance = new TicketList();
        }
        return instance;
    }

}
