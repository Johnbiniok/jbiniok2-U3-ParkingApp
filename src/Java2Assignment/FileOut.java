package Java2Assignment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * abstract class to output file contents into the console
 */
public abstract class FileOut {
    public FileOut() throws IOException {

    }

    /**
     * method to write the whole file to the console
     * @throws FileNotFoundException
     */
    public static void writeWholeFile() throws FileNotFoundException {
        try (BufferedReader readFile = new BufferedReader(new FileReader(FileWrite.getFileName()))) {
            String currentLine;
            System.out.println("Time In      Day In      Time Out     Day Out     Amount Paid    Ticket Lost");
            while ((currentLine = readFile.readLine()) != null) {
                System.out.println(currentLine);
            }
        } catch (IOException e) {
            System.out.println("Internal error");
            e.printStackTrace();
        }
    }
    }

