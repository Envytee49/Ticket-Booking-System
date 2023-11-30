package ticketing.system.exception;

import ticketing.system.service.QueueService;

public class TicketGreaterThanUserException{
    public TicketGreaterThanUserException() {
        try {
            Thread.sleep(5000);
            System.out.println("Ticket left: " + QueueService.tickets.size());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
