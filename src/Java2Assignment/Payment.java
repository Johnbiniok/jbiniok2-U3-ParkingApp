package Java2Assignment;

public class Payment {
    private double payAmount;
    private String payType;

    /**
     *
     * @param payAmount how much is being paid
     * @param payType is it lost, checked, or special
     */
    public Payment(double payAmount, String payType){
        this.payType = payType;
        this.payAmount = payAmount;
    }

    /**
     *
     * @return payAmount
     */
    public double getPayAmt(){
        return payAmount;
    }

    /**
     *
     * @return payType
     */
    public String getPayType(){
        return payType;
    }

}
