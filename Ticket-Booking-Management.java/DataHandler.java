import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class DataHandler {
    private static final String FILE_NAME = "C:\\Users\\Windows 11\\Ticket-Booking-Management\\tickets.csv";
    public static void saveTickets(ArrayList<Ticket> tickets) {
        try(PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for(Ticket t : tickets){
                writer.println(t.toCSV());
            }
        } catch (IOException e) {
            System.out.println("Error in saving ticket."+e.getMessage());
        }
    }
    public static ArrayList<Ticket> loadTickets(){
        ArrayList<Ticket> tickets = new ArrayList<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return tickets;
        }
        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))){
            String line;
            while ((line = reader.readLine()) != null) {
                tickets.add(Ticket.fromCSV(line));
            }
        } catch(IOException e) {
            System.out.println("Error loading tickets: "+e.getMessage());
        }
        return tickets;
    }
}
