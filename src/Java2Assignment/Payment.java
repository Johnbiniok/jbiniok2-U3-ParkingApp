package Java2Assignment;

public class Payment {
    private double payAmount;
    private String payType;
    public Payment(double payAmount, String payType){
        this.payType = payType;
        this.payAmount = payAmount;
    }

    public double getPayAmt(){
        return payAmount;
    }
    public String getPayType(){
        return payType;
    }

}
