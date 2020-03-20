package Java2Assignment;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * class to write the ticket list to a file
 */
public class FileWrite {
    private static String fileName = "ticketFile.txt";
    //private String fileName = "ticketFile.txt";
    public FileWrite(List<Ticket> ticketList) throws IOException {
        FileWriter toFile = new FileWriter(fileName);
        BufferedWriter writeFile = new BufferedWriter(toFile);
        for(Ticket t: ticketList){
            String morningNoon;
            if(t.getTimeIn() == 12){
                morningNoon = "P.M.";
            }else{
                morningNoon = "A.M.";
            }
            writeFile.write(t.getTimeIn() + morningNoon + "      " + t.getDateIn() + "     " + t.getTimeOut() + "P.M.   " + t.getDateOut() + "      " + t.getPaymentAmount() + "         " + t.getLostTicket() + "\r\n");
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
