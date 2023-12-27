package ticketing.system;

public class App {
    public static void main(String[] args) throws InterruptedException {
        // Prepare the system
        TicketingSystem ticketingSystem = new TicketingSystem();

        // Create the tickets
        ticketingSystem.setupTickets(10);
        // Add users to waiting room before sale starts
        for (int i = 0; i < 100; i++) {
                ticketingSystem.addUserToWaitingRoom(i);
        }
        // Start the sale
        ticketingSystem.startSale();
    }
}
