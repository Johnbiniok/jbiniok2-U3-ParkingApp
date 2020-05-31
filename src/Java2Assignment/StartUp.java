package Java2Assignment;

import java.io.*;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.nio.file.Files.readAllLines;

public abstract class StartUp {
    public int ticketID;
    private static String fileName = "ticketFile.txt";
    private static ArrayList<Ticket> ticketList;
    private static String garageName;
    private static String minCharge;
    private static String minHours;
    private static String maxCharge;
    private static String hourCharge;
    private static String lostFee;
    private static String specialCharge;
    private static ArrayList<Double> allCharges;
    private static Scanner keyboard = new Scanner(System.in);

    public StartUp() throws IOException, NullPointerException {

    }
    /*public boolean hasConfig(){

    }*/

    /**
     * This method is going look to see if there is an initialization file
     *if it does not have one, it will create one and ask questions to configure
     * if it does have one, it will load the information from the init file
     */
    public static void initialization() throws IOException, Exception {
        try {
            File file = new File("init.txt");
            //this is to create a new initialization file
            if (file.createNewFile()) {
                File forTickets = new File("ticketFile.txt");
                if(forTickets.createNewFile()){
                    System.out.println("Welcome for the first time!");
                }
                FileWriter writeInit = new FileWriter(file);
                BufferedWriter toWrite = new BufferedWriter(writeInit);
                System.out.println("New Initialization Startup...");
                System.out.println("Please Enter the full parking garage name:");
                garageName = keyboard.nextLine();
                toWrite.write(garageName);
                toWrite.newLine();

                System.out.println("What will be the minimum charge?");
                minCharge = keyboard.nextLine();
                toWrite.write(minCharge);
                toWrite.newLine();

                System.out.println("How many hours before you begin to charge?");
                minHours = keyboard.nextLine();
                toWrite.write(minHours);
                toWrite.newLine();

                System.out.println("What will be your maximum charge?");
                maxCharge = keyboard.nextLine();
                toWrite.write(maxCharge);
                toWrite.newLine();

                System.out.println("How much would you like to charge per hour?");
                hourCharge = keyboard.nextLine();
                toWrite.write(hourCharge);
                toWrite.newLine();

                System.out.println("How much do you charge for special events?");
                specialCharge = keyboard.nextLine();
                toWrite.write(specialCharge);
                toWrite.newLine();

                System.out.println("How much do you charge for lost tickets?");
                lostFee = keyboard.nextLine();
                toWrite.write(lostFee);
                toWrite.close();

                //this is if they have an initialization file already
            } else {
                //gather info from the initialization file
                FileReader fr = new FileReader(file);   //reads the file
                BufferedReader br = new BufferedReader(fr);  //creates a buffering character input stream
                //StringBuffer sb = new StringBuffer();    //constructs a string buffer with no characters
                String line = br.readLine();
                garageName = line;
                int counter = 1;
                while (line != null) {
                    line = br.readLine();
                   if(counter == 1) {
                        minCharge = line;
                    }else if(counter == 2) {
                        minHours = line;
                    }else if(counter == 3) {
                        maxCharge = line;
                    }else if(counter == 4) {
                        hourCharge = line;
                    }else if(counter == 5) {
                        specialCharge = line;
                    }else if(counter == 6) {
                        lostFee = line;
                    }
                    counter++;
                }

                System.out.println("Initialized startup file");
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

    }

    /**
     *
     * @return the ID for the last ticket in the file
     */
    public static int getLastTicketID(){
        int iDHolder = 1;
        //ArrayList<TicketList> ticketList = null;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(FileWrite.getFileName()));

            String line = reader.readLine();;
            while(line != null){
                String[] idTrack = line.split(",");
                if(Integer.parseInt(idTrack[0]) > iDHolder){
                    iDHolder = Integer.parseInt(idTrack[0]);
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
           /* FileInputStream fileIn = new FileInputStream(FileWrite.getFileName());
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
           // ticketList = (ArrayList<Ticket>)objectIn.readObject();
            List<?> tickets;
            tickets = (List<?>) objectIn.readObject();
            // Ticket ticket = (Ticket)objectIn.readObject();
            for (Object pullTicket: tickets) {
                if(pullTicket instanceof Ticket) {
                    if (((Ticket) pullTicket).getTicketID() > iDHolder) {
                        iDHolder = ((Ticket) pullTicket).getTicketID();
                    }
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
            return Integer.parseInt(null);
        }*/
        return iDHolder;
    }
    public static String getGarageName(){
        return garageName;
    }
    public static ArrayList<Double> getAllCharges(){
        return allCharges;
    }

    public static String getMinCharge() {
        return minCharge;
    }

    public static String getMinHours() {
        return minHours;
    }

    public static String getMaxCharge() {
        return maxCharge;
    }

    public static String getHourCharge() {
        return hourCharge;
    }

    public static String getLostFee() {
        return lostFee;
    }

    public static String getSpecialCharge() {
        return specialCharge;
    }
}
