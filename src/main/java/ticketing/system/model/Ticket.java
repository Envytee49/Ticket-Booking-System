package ticketing.system.model;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Represents a ticket in the ticketing system.
 */
public class Ticket {
    private final int id;
    private final AtomicBoolean locked = new AtomicBoolean(false);

    public Ticket(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    /**
     * Checks if the ticket is locked.
     *
     * @return true if the ticket is locked, false otherwise
     */
    public boolean isLocked() {
        return locked.get();
    }

    /**
     * Tries to lock the ticket for purchase. If the ticket is already locked,
     * it cannot be locked again.
     *
     * @return true if the ticket was successfully locked, false otherwise
     */
    public boolean tryLock() {
        return locked.compareAndSet(false, true);
    }
    public void tryOpen() {
        locked.compareAndSet(true, false);
    }
}
