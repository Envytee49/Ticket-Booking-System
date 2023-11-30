package ticketing.system;

public class App {
    public static void main(String[] args) throws InterruptedException {
        // Prepare the system
        int acceptableRange = 10;
        TicketingSystem ticketingSystem = new TicketingSystem(acceptableRange);

        // Create the tickets
        ticketingSystem.setupTickets(80);
        // Add users to waiting room before sale starts
        for (int i = 0; i < 100; i++) {
                ticketingSystem.addUserToWaitingRoom(i, 0);
        }

        // Start the sale
        ticketingSystem.startSale();

//        // Users arrive at different times
//        for (int i = 400; i < 700; i++) {
//            ticketingSystem.addUserToWaitingRoom(i, 1);
//        }
//        ticketingSystem.startSale();
//
//        for (int i = 700; i < 900; i++) {
//            ticketingSystem.addUserToWaitingRoom(i, 2);
//        }
//        ticketingSystem.startSale();
//
//        for (int i = 900; i < 2000; i++) {
//            ticketingSystem.addUserToWaitingRoom(i, 3);
//        }
//        ticketingSystem.startSale();
    }
}
