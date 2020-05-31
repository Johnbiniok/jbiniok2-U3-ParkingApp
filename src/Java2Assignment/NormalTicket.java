package Java2Assignment;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import static Java2Assignment.StartUp.*;
import static java.lang.Double.doubleToLongBits;
import static java.lang.Double.parseDouble;

public class NormalTicket extends Ticket {
    private static NormalTicket ticket = null;
    private String ID = null;
    private static int ticketID;
    private LocalDate dateIn;
    private int timeIn;
    private LocalDate dateOut;
    private int timeOut;
    //String forPay = determinePayments();
    private String paymentAmount = null;
    private boolean ticketLost;
    private PaymentList payList;
    private static boolean firstRun = true;

    /**
     *
     * @param dateIn ticket start date
     * @param timeIn ticket start time
     * @param sameDate boolean to find if it is the same date or not
     * @param timeOut ticket out time
     * @param ticketLost boolean for if the ticket is lost
     */
    public NormalTicket(int ticketID, LocalDate dateIn, int timeIn, boolean sameDate, int timeOut, boolean ticketLost){
        super(dateIn, timeIn, sameDate, timeOut, ticketLost);
        int startingPoint = StartUp.getLastTicketID();
        if(firstRun) {
            NormalTicket.ticketID = StartUp.getLastTicketID() + 1;
            firstRun = false;
        }else{
            NormalTicket.ticketID++;
        }
        this.paymentAmount = null;
    }
    private static NormalTicket getInstance()
    {
        if (ticket == null)
            TicketList.addNormalTicket(false);
        return ticket;
    }

    /**
     *
     * @param paymentAmount sets the payment amount for the object
     */
    public void setPaymentAmount(String paymentAmount){
        this.paymentAmount = paymentAmount;
    }
    /*void setPaymentAmount(){
        try {
            this.paymentAmount = determinePayments(this);
        }catch(NullPointerException ex){
            System.out.println("IT AINT WORKIN");
        }
    }*/
}
