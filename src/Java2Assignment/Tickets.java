package Java2Assignment;

import java.time.LocalDate;
import java.util.ArrayList;

public interface Tickets {
    String getAmPm(int findInt);
    LocalDate getDateIn();
    int getTimeIn();
    LocalDate getDateOut();
    int getTimeOut();
    String getPaymentAmount();
    boolean getLostTicket();
    int getTicketID();
    void setPaymentAmount(String paymentAmount);
}
