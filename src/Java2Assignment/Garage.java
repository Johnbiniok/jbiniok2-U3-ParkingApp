package Java2Assignment;

import java.util.ArrayList;
import java.util.List;

public class Garage {
    private static int carsThrough;
    private static List<Ticket> tickets = new ArrayList<>();
    public Garage(){
        carsThrough++;
    }
}
