package Java2Assignment;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.io.Serializable;

public abstract class Ticket implements Tickets, Serializable{
    private int ticketID;
    private LocalDate dateIn;
    private int timeIn;
    private LocalDate dateOut;
    private int timeOut;
    private String paymentAmount;
    private boolean ticketLost;
    private PaymentList payList;


    public Ticket(LocalDate dateIn, int timeIn, boolean sameDate, int timeOut, boolean ticketLost){
        this.ticketID = StartUp.getLastTicketID() + 1;
        this.dateIn = dateIn;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        if(sameDate){
            this.dateOut = dateIn;
        }else{
            this.dateOut = dateIn.plusDays(1);
        }
        this.ticketLost = ticketLost;
        this.paymentAmount = getPaymentAmount();
    }


    public LocalDate getDateIn(){
        return dateIn;
    }
    public int getTimeIn(){
        return timeIn;
    }
    public LocalDate getDateOut(){
        return dateOut;
    }
    public int getTimeOut(){
        return timeOut;
    }
    public String getPaymentAmount(){
        return paymentAmount;
    }
    public boolean getLostTicket(){return ticketLost;}

    public int getTicketID() {
        return ticketID;
    }

    @Override
    public String toString() {
        int getHours = this.timeOut - this.timeIn;
        int getLaterHours = this.timeOut - 12;
        if(this.ticketLost) {
            return "Receipt for vehicle id " + this.ticketID + "\r\n \r\n Lost Ticket \r\n";
        }else{
            return "Receipt for vehicle id " + this.ticketID + "\r\n \r\n" + getHours + " hours parked " + this.timeIn +
                    getAmPm(this.timeIn) + " - " + getLaterHours + "p.m." + "\r\n";
        }
    }

    public String getAmPm(int findInt){
        if(findInt < 12){
            return "a.m.";
        }else{
            return "p.m.";
        }
    }
}
