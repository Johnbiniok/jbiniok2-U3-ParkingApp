package Java2Assignment;

import java.time.LocalDate;
import java.time.LocalTime;

public class MachineOut {
  private LocalDate dateOut;
    private int timeOut;
    public MachineOut(LocalDate dateIn, int timeIn){
       // super(dateIn, timeIn);
        //UserInterface.inGarage = false;
        //get random number to see if they were there more than one day
       // int randomDay = (int)(Math.random() * (2 - 1 + 1) + 1);
       /* switch(randomDay){
            case 1:
                dateOut =
                break;
            case 2:
                break;
        }*/


    }

    public LocalDate getDateOut() {
        return dateOut;
    }

}
