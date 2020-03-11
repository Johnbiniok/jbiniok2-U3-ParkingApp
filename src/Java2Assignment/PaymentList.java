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
        }else if(payType.equals("lost")){
            lostTickPay.add(new Payment(payAmt, payType));
        }
        totalPayments.add(new Payment(payAmt, payType));
    }

    public static int sum(List<Payment> listName) {
        int sum = 0;
        for (Payment i: listName) sum += i.getPayAmt();
        return sum;
    }

    @Override
    public String toString() {
        return sum(checkInPay) + " was collected from check ins\r\n" +
                sum(lostTickPay) + " was collected from check ins\r\n" +
                sum(totalPayments) + " was collected in total";
    }
}
