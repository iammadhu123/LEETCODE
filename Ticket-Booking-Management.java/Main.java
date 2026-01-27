import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        TicketManager manager = new TicketManager();
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("---Ticket Booking Management--- ");
            System.out.println("1->Book Ticket");
            System.out.println("2->Cancel Ticket");
            System.out.println("3->View Ticket");
            System.out.println("4->View Available Seats");
            System.out.println("5->Exit");
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter passenger name: ");
                    String name = sc.nextLine();
                    System.out.println("Enter passenger age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter from: ");
                    String from = sc.nextLine();
                    System.out.println("Enter destination: ");
                    String to = sc.nextLine();
                    manager.bookTicket(name, age, from, to);
                    break;
                case 2:
                    System.out.println("Enter ticketId to cancel");
                    int id = sc.nextInt();
                    manager.cancelTicket(id);
                    break;
                case 3:
                    manager.viewTickets();
                    break;
                case 4:
                    manager.viewAvailableSeats();
                    break;
                case 5:
                System.out.println("Thank you for chosing our services.");
                    break;
                default:
                System.out.println("Invalid choice");
            }
        }
    }
}
