import java.util.*;

public class TicketManager {
    private ArrayList<Ticket> tickets = new ArrayList<>();
    private int maxSeat = 10;
    private int nextTicketId;

    public TicketManager() {
        tickets = DataHandler.loadTickets();
        nextTicketId = tickets.stream().mapToInt(Ticket::getTicketId).max().orElse(0)+1;
    }

    public void bookTicket(String passengername, int age, String from, String to) {
        if (tickets.size() >= maxSeat) {
            System.out.println("No seat available");
            return;
        }

        int seatno = tickets.size();
        Ticket ticket = new Ticket(nextTicketId++, passengername, age, from, to, seatno);
        tickets.add(ticket);
        DataHandler.saveTickets(tickets);
        System.out.println("Ticket Booked Successfully "+ticket);
    }

    public void cancelTicket(int id) {
        Ticket t = tickets.stream().filter(ticket->ticket.getTicketId() == id).findFirst().orElse(null);
        if (t != null) {
            tickets.remove(t);
            DataHandler.saveTickets(tickets);
            System.out.println("Ticket Cancelled");
        } else {
            System.out.println("Ticket Not Found");
        }
    }

    public void viewTickets() {
        if (tickets.isEmpty()) {
            System.out.println("Tickets not booked yet");
            return;
        }
        tickets.forEach((ticket)->{
            System.out.println(ticket);
        });
    }

    public void viewAvailableSeats() {
        System.out.println("Available Seats: "+(maxSeat-tickets.size()));
    }
}
