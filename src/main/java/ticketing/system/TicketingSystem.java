package ticketing.system;

import ticketing.system.model.User;
import ticketing.system.model.Ticket;
import ticketing.system.service.QueueService;
import ticketing.system.service.QueueManagerService;
import ticketing.system.service.WaitingRoomService;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages the operations of the ticketing system.
 */
public class TicketingSystem{
    private final WaitingRoomService waitingRoomService;
    private final QueueManagerService queueManagerService;
    private final List<Ticket> tickets;
    private QueueService queueService;
    /**
     * Initializes a new TicketingSystem instance.
     */
    public TicketingSystem() {
        this.waitingRoomService = new WaitingRoomService();
        this.queueManagerService = new QueueManagerService(waitingRoomService);
        this.tickets = new ArrayList<>();
    }

    /**
     * Sets up the tickets to be sold.
     *
     * @param ticketCount the number of tickets to be set up
     */
    public void setupTickets(int ticketCount) {
        for (int i = 0; i < ticketCount; i++) {
            tickets.add(new Ticket(i));
        }
    }

    /**
     * Adds a user to the waiting room.
     *
     * @param userId the id of the user to be added
     */

    public void addUserToWaitingRoom(int userId) {
        waitingRoomService.addUser(new User(userId));
        queueManagerService.manageQueue();
    }

    /**
     * Starts the ticket sale by processing the users in the waiting room.
     */
    public void startSale() throws InterruptedException {
        this.queueService = new QueueService(waitingRoomService, tickets);
        queueService.processQueue();
    }
}
