package Java2Assignment;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * abstract class that controls a list of payments
 * list for all payments, check in-check out payments, and lost ticket payments
 */
public abstract class PaymentList {
    private static List<Payment> totalPayments = new ArrayList<>();
    private static List<Payment> checkInPay = new ArrayList<>();
    private static List<Payment> lostTickPay = new ArrayList<>();

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
        }
        totalPayments.add(new Payment(payAmt, payType));
    }

    public static String paySum(List<Payment> listName) {
        int sum = 0;
        for (Payment i: listName) sum += i.getPayAmt();
        NumberFormat defaultFormat = NumberFormat.getCurrencyInstance();
        return defaultFormat.format(sum);
    }

    public static int checkAmt(List<Payment> typeList, String type){
        int totalType = 0;
        for(Payment i: typeList){
            if(i.getPayType().equals(type)){
                totalType++;
            }
        }
        return totalType;
    }

    public static void payData(){
        System.out.println(paySum(checkInPay) + " was collected from " + checkAmt(checkInPay, "check") + " check ins\r\n" +
                paySum(lostTickPay) + " was collected from " + checkAmt(lostTickPay, "lost") + " lost tickets\r\n" +
                paySum(totalPayments) + " was collected overall");
    }

}
