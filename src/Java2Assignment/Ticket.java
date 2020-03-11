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
    public Ticket(LocalDate dateIn, int timeIn, boolean sameDate, int timeOut, boolean ticketLost){
       // this.dateIn = MachineIn.userRandomDate(2012, 2020);
        //this.timeIn = MachineIn.IntBetween(11, 13);
        this.dateIn = dateIn;

        this.timeIn = timeIn;
        this.timeOut = timeOut;
        if(sameDate){
            this.dateOut = dateIn;
        }else{
            this.dateOut = dateIn.plusDays(1);
        }
        this.paymentAmount = determinePayment();
        this.ticketLost = ticketLost;
    }
    public String determinePayment(){
        NumberFormat defaultFormat = NumberFormat.getCurrencyInstance();
        if(dateOut == dateIn && !ticketLost){
            int timeDifference = timeOut - timeIn;
            if(timeDifference <= 3){
                return defaultFormat.format(5.00);
            }else{
                int chargeHours = timeDifference - 3;
                double totalCharge = 5.00;
                return defaultFormat.format(totalCharge + chargeHours);
            }
        }else if(dateIn.compareTo(dateOut) > 0 && !ticketLost){
            return defaultFormat.format(15.00);
        }
        return defaultFormat.format(25.00);
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

    public static LocalDate userRandomDate(int startYear, int endYear) {
        int day = IntBetween(1, 28);
        int month = IntBetween(1, 12);
        int year = IntBetween(startYear, endYear);
        return LocalDate.of(year, month, day);
    }

    private static int IntBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

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
