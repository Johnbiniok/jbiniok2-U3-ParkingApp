package Java2Assignment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public abstract class FileOut {
    public FileOut() throws IOException {

    }
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

