package Java2Assignment;

import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import static Java2Assignment.StartUp.*;
import static Java2Assignment.StartUp.getHourCharge;
import static java.lang.Double.parseDouble;

public abstract class TicketList {
    private static List<Ticket> ticketList = new ArrayList<>();
    private static TicketList instance = null;
    private static int ticketID = 0;
    private static String paymentAmount = "";

    public static String getPaymentAmount(){
        return paymentAmount;
    }
    public static List<Ticket> getTicketList(){
        return ticketList;
    }

    /**
     * This method is to add normal tickets to the list
     * @param lostTicket this affects the price of the ticket
     */
    static void addNormalTicket(boolean lostTicket){
        NormalTicket userTicket = null;
        userTicket = new NormalTicket(StartUp.getLastTicketID(), MachineIn.userRandomDate(2012, 2020), MachineIn.IntBetween(7, 12), MachineIn.sameDay(), MachineIn.IntBetween(13, 23), lostTicket);
        paymentAmount = determineNormalPayments(userTicket);
        userTicket.setPaymentAmount(paymentAmount);
        ticketList.add(userTicket);
        System.out.println(userTicket.toString());
        System.out.println(paymentAmount);

    }

    /**
     * This method is to add special tickets to the list
     * @param lostTicket this affects the price of the ticket
     */
    static void addSpecialTicket(boolean lostTicket){
        SpecialEvent userTicket = null;
        userTicket = new SpecialEvent(StartUp.getLastTicketID(), MachineIn.userRandomDate(2012, 2020), MachineIn.IntBetween(7, 12), MachineIn.sameDay(), MachineIn.IntBetween(13, 23), lostTicket);
        paymentAmount = determineSpecialPayments(userTicket);
        userTicket.setPaymentAmount(paymentAmount);
        ticketList.add(userTicket);
        System.out.println(userTicket.toString());
        System.out.println(paymentAmount);
    }

    /**
     * method that essentially adds the ticket that has been generated randomly to a cumulative list of all tickets
     *@return String that will be a string of the payment
     */
    public static String determineNormalPayments(Ticket ticket) {
        double min = parseDouble(getMinCharge());
        String maxholder = getLostFee();
        double max = parseDouble(maxholder);
        double med = parseDouble(getMaxCharge());
        double minHours = parseDouble(getMinHours());
        double hourCharge = parseDouble(getHourCharge());
        int timeDifference = ticket.getTimeOut() - ticket.getTimeIn();
        DecimalFormat dc = new DecimalFormat("#.00");
        if(ticket.getLostTicket()){
            PaymentList.addPaymentToList(max, "lost");
            return dc.format(max);
        } else if(ticket.getDateOut().compareTo(ticket.getDateIn()) == 0){
            if(timeDifference <= minHours){
                PaymentList.addPaymentToList(min,"check");
                return dc.format(min);
            }else{
                double chargeHours = (timeDifference - minHours) * hourCharge;
                double chargeCheck = min + chargeHours;
                if(chargeCheck <= med) {
                    PaymentList.addPaymentToList(chargeCheck, "check");
                    return dc.format(chargeCheck);
                }else{
                    PaymentList.addPaymentToList(med, "check");
                    return dc.format(med);
                }
            }
        }else if(ticket.getDateOut().compareTo(ticket.getDateIn()) > 0) {
            PaymentList.addPaymentToList(med, "check");
            return dc.format(med);
        }
        return dc.format(StartUp.getSpecialCharge());
    }

    /**
     *
     * @param ticket passes in a ticket object to calculate payment
     * @return String that states special payments
     */
    public static String determineSpecialPayments(Ticket ticket) {
        double max = Double.parseDouble(StartUp.getLostFee());
        double specialPrice = Double.parseDouble(StartUp.getSpecialCharge());
        int timeDifference = ticket.getTimeOut() - ticket.getTimeIn();
        DecimalFormat dc = new DecimalFormat("#.00");;
        if(ticket.getLostTicket()){
            PaymentList.addPaymentToList(max, "lost");
            return dc.format(max);
        }else {
            PaymentList.addPaymentToList(specialPrice, "special");
            return dc.format(specialPrice);
        }
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
