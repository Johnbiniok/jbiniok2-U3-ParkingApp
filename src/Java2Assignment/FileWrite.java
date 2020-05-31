package Java2Assignment;

import java.io.*;
import java.util.List;

/**
 * class to write the ticket list to a file
 */
public class FileWrite {
    private static String fileName = "ticketFile.txt";

    /**
     *
     * @param ticketList pass in list to add to the file
     * @throws IOException
     */
    public FileWrite(List<Ticket> ticketList) throws IOException {
        FileWriter toFile = new FileWriter(fileName, true);
        BufferedWriter writeFile = new BufferedWriter(toFile);
        for(Ticket t: ticketList){
            String morningNoon;
            if(t.getTimeIn() == 12){
                morningNoon = "P.M.";
            }else{
                morningNoon = "A.M.";
            }
            writeFile.write(t.getTicketID() + "," + t.getTimeIn() + morningNoon + "," + t.getDateIn() + "," + t.getTimeOut() + "P.M.," + t.getDateOut() + "," + TicketList.getPaymentAmount() + "," + t.getLostTicket() + "\r\n");
        }
        writeFile.close();
        toFile.close();
    }

    /**
     * use for another way to make sure the file is the same
     * @return fileName
     */
    public static String getFileName(){
        return fileName;
    }
}
