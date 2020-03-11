package Java2Assignment;

import java.util.List;

public class PaymentList {
    private static List<Payment> totalPayments;
    private static List<Payment> checkInPay;
    private static List<Payment> lostTickPay;
    public PaymentList(){

    }
    public static void addPaymentToList(double payAmt, String payType){
        if(payType.equals("check")){
            checkInPay.add(new Payment(payAmt, payType));
            totalPayments.add(new Payment(payAmt, payType));
        }else if(payType.equals("lost")){
            lostTickPay.add(new Payment(payAmt, payType));
            totalPayments.add(new Payment(payAmt, payType));
        }else{
            totalPayments.add(new Payment(payAmt, payType));
        }
    }
}
