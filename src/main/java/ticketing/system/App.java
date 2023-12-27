package ticketing.system;

public class App {
    public static void main(String[] args) throws InterruptedException {
        // Prepare the system
        int acceptableRange = 1000;
        TicketingSystem ticketingSystem = new TicketingSystem(acceptableRange);

        // Create the tickets
        ticketingSystem.setupTickets(1000);
        // Add users to waiting room before sale starts
        for (int i = 0; i < 10000; i++) {
                ticketingSystem.addUserToWaitingRoom(i);
        }

        // Start the sale
        ticketingSystem.startSale();
    }
}
