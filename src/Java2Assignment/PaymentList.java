package Java2Assignment;

import java.io.*;
import java.nio.file.FileVisitResult;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * abstract class that controls a list of payments
 * list for all payments, check in-check out payments, and lost ticket payments
 */
public abstract class PaymentList {
    private static List<Payment> totalPayments = new ArrayList<>();
    private static List<Payment> checkInPay = new ArrayList<>();
    private static List<Payment> lostTickPay = new ArrayList<>();
    private static List<Payment> specialTick = new ArrayList<>();

    /**
     *
     * @param payAmt
     * @param payType
     */
    public static void addPaymentToList(double payAmt, String payType){
        if(payType.equals("check")){
            checkInPay.add(new Payment(payAmt, payType));
        }else if(payType.equals("lost")){
            lostTickPay.add(new Payment(payAmt, payType));
        }else if(payType.equals("special")){
            specialTick.add(new Payment(payAmt, payType));
        }
        totalPayments.add(new Payment(payAmt, payType));
    }

    /**
     *
     * @param listName this is a list of the different payments
     * @return the sum of all payments
     */
    public static String paySum(List<Payment> listName) {
        int sum = 0;
        for (Payment i: listName) sum += i.getPayAmt();
        NumberFormat defaultFormat = NumberFormat.getCurrencyInstance();
        return defaultFormat.format(sum);
    }

    /**
     *
     * @param typeList array of payments
     * @param type to keep track of which type of payments they are
     * @returnthe total of the check ins
     */
    public static int checkAmt(List<Payment> typeList, String type){
        int totalType = 0;
        for(Payment i: typeList){
            if(i.getPayType().equals(type)){
                totalType++;
            }
        }
        return totalType;
    }

    /**
     * This is to grab all other instances from the file and put them into the appropriate arrays
     * @throws IOException
     */
    public static void retrieveOtherTotals() throws IOException {
        ArrayList<Ticket> ticketList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(FileWrite.getFileName()));
        double totalCheckIn = 0;
        while(true){
            String line = reader.readLine();
            if(line == null){
                break;
            }
            String[] ticketParts = line.split(",");
            String payType = "check";
            if(ticketParts[5].equals(StartUp.getLostFee()) && ticketParts[5] != null){
                lostTickPay.add(new Payment(Double.parseDouble(ticketParts[5]), "lost"));
                payType = "lost";
            }else if(ticketParts[5].equals(StartUp.getSpecialCharge()) && ticketParts[5] != null){
                specialTick.add(new Payment(Double.parseDouble(ticketParts[5]), "special"));
                payType = "special";
            }else if(ticketParts[5] != null){
               System.out.println(ticketParts[5]);
               try {
                   checkInPay.add(new Payment(Double.parseDouble(ticketParts[5]), "check"));
               }catch (Exception e){
               }
            }
            if(ticketParts[5] != null) {
                totalPayments.add(new Payment(Double.parseDouble(ticketParts[5]), payType));
            }
        }
        reader.close();

    }

    /**
     * This is to display once the program is closed
     */
    public static void payData(){
        System.out.println(paySum(checkInPay) + " was collected from " + checkAmt(checkInPay, "check") + " check ins\r\n" +
                paySum(specialTick) + " was collected from " + checkAmt(specialTick, "special") + " Special events \r\n" +
                paySum(lostTickPay) + " was collected from " + checkAmt(lostTickPay, "lost") + " lost tickets\r\n" +
                paySum(totalPayments) + " was collected overall");
    }

}
