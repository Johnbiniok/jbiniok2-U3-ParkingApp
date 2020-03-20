package Java2Assignment;

import java.text.NumberFormat;
import java.time.LocalDate;

public class Ticket {
    private LocalDate dateIn;
    private int timeIn;
    private LocalDate dateOut;
    private int timeOut;
    private String paymentAmount;
    private boolean ticketLost;
    private PaymentList payList;

    /**
     *
     * @param dateIn ticket start date
     * @param timeIn ticket start time
     * @param sameDate boolean to find if it is the same date or not
     * @param timeOut ticket out time
     * @param ticketLost boolean for if the ticket is lost
     */
    public Ticket(LocalDate dateIn, int timeIn, boolean sameDate, int timeOut, boolean ticketLost){
        this.dateIn = dateIn;

        this.timeIn = timeIn;
        this.timeOut = timeOut;
        if(sameDate){
            this.dateOut = dateIn;
        }else{
            this.dateOut = dateIn.plusDays(1);
        }
        this.ticketLost = ticketLost;
        this.paymentAmount = determinePayment();
    }

    /**
     * method to determine how much the payment will be
     * @return a string of the payment amount that is formatted
     */
    public String determinePayment(){
        double min = 5.00;
        double max = 25.00;
        double med = 15.00;
        int timeDifference = timeOut - timeIn;
       NumberFormat defaultFormat = NumberFormat.getCurrencyInstance();
       if(ticketLost){
           PaymentList.addPaymentToList(max, "lost");
           return defaultFormat.format(max);
       }else if(dateOut.compareTo(dateIn) == 0){
            if(timeDifference <= 3){
                PaymentList.addPaymentToList(min,"check");
                return defaultFormat.format(min);
            }else{
                int chargeHours = timeDifference - 3;
                double totalCharge = 5.00;
                double chargeCheck = totalCharge + chargeHours;
                if(chargeCheck <= med) {
                    PaymentList.addPaymentToList(chargeCheck, "check");
                    return defaultFormat.format(chargeCheck);
                }else{
                    PaymentList.addPaymentToList(med, "check");
                    return defaultFormat.format(med);
                }
            }
        }else if(dateOut.compareTo(dateIn) > 0) {
           PaymentList.addPaymentToList(med, "check");
           return defaultFormat.format(med);
       }
        return "There was an error somewhere";
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

    /*public static LocalDate userRandomDate(int startYear, int endYear) {
        int day = IntBetween(1, 28);
        int month = IntBetween(1, 12);
        int year = IntBetween(startYear, endYear);
        return LocalDate.of(year, month, day);
    }

    private static int IntBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }*/

    /*public void clockIn(){
        MachineIn inClock = new MachineIn();
        this.dateIn = inClock.getDateIn();
        this.timeIn = inClock.getTimeIn();
    }
    public void clockOut(){
        MachineOut outClock = new MachineOut();
        this.dateOut = outClock.getDateOut();
        this.timeOut = outClock.getTimeOut();
    }
    public void addTicket(){
        addTicketToList
    }*/
}
