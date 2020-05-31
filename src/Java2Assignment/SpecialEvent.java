package Java2Assignment;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;

public class SpecialEvent extends Ticket{
    private static SpecialEvent ticket = null;
    private int ticketID;
    private LocalDate dateIn;
    private int timeIn;
    private LocalDate dateOut;
    private int timeOut;
    private String paymentAmount;
    private boolean ticketLost;

    /**
     *
     * @param dateIn ticket start date
     * @param timeIn ticket start time
     * @param sameDate boolean to find if it is the same date or not
     * @param timeOut ticket out time
     * @param ticketLost boolean for if the ticket is lost
     */
    public SpecialEvent(int ticketID, LocalDate dateIn, int timeIn, boolean sameDate, int timeOut, boolean ticketLost){
        super(dateIn, timeIn, sameDate, timeOut, ticketLost);
        this.ticketID = StartUp.getLastTicketID() + 1;
        this.paymentAmount = null;
    }

    /**
     *
     * @return the instance of the ticket
     */
    private static SpecialEvent getInstance()
    {
        if (ticket == null)
            TicketList.addNormalTicket(false);
        return ticket;
    }

   @Override
    public void setPaymentAmount(String paymentAmount){
        this.paymentAmount = paymentAmount;
    }
}
