package ticketing.system.service;

import ticketing.system.exception.TicketGreaterThanUserException;
import ticketing.system.model.Ticket;
import ticketing.system.model.User;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Handles the operations of the queue.
 */
public class QueueService {
    private static WaitingRoomService waitingRoomService;
    public static List<Ticket> tickets;

    /**
     * Initializes a new QueueService instance.
     *
     * @param waitingRoomService the service to manage the waiting room
     * @param tickets the list of tickets available for sale
     */
    public QueueService(WaitingRoomService waitingRoomService, List<Ticket> tickets) {
        QueueService.waitingRoomService = waitingRoomService;
        QueueService.tickets = new CopyOnWriteArrayList<>(tickets);
    }

    /**
     * Processes the users in the waiting room, allowing them to attempt to purchase tickets.
     */
    public void processQueue() throws InterruptedException {
        List<User> users;
        while(tickets.size() != 0) {
            users = waitingRoomService.getWaitingRoom().stream()
                    .sorted(Comparator.comparing(User::getQueuePosition)).toList();
            Thread[] threads = new Thread[tickets.size()];
            try {
                for (int i = 0; i < tickets.size(); i++) {
                    threads[i] = new Thread(users.get(i));
                    threads[i].start();
                }
            }catch (ArrayIndexOutOfBoundsException e) {
                new TicketGreaterThanUserException();
                break;
            }
            // Wait for every thread to finish
            for(int i = 0; i < tickets.size(); i++) {
                threads[i].join();
            }

            Thread.sleep(2000);

            if(tickets.size() != 0) {
                System.out.println("let next "+ tickets.size()+" users in queue");
            }
            else System.out.println("TICKET SOLD OUT");
        }

    }

    /**
     * Allows the given user to attempt to purchase a ticket.
     *
     * @param user the user who will attempt to purchase a ticket
     */
    public static void attemptPurchase(User user, int processTime) {
            for (Ticket ticket : tickets) {
                if (ticket.tryLock()) {
                    // If process time > 2000 (2s) then the user get kicked out and unlock the key
                    if(processTime > 2000) {
                        try {
                            // Sleep the user thread so that ensuring, all tickets in  the batch is chosen
                            Thread.sleep(2001);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println("User " + user.getId() + " failed to purchase ticket " + ticket.getId());
                        ticket.tryOpen();
                    }
                    // Else successfully purchase the ticket
                    else {
                        System.out.println("User " + user.getId() + " purchased ticket " + ticket.getId());
                        tickets.remove(ticket);
                    }
                    // Remove user from waiting room after purchase
                    waitingRoomService.getWaitingRoom().remove(user);
                    break;
                }
            }
    }
    /**
     * Returns the list of tickets.
     *
     * @return the list of tickets
     */
    public List<Ticket> getTickets() {
        return tickets;
    }
}
