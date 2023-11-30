package ticketing.system.model;

import ticketing.system.service.QueueService;

import java.util.Queue;
import java.util.Random;

/**
 * Represents a user in the ticketing system.
 */
public class User implements Runnable{
    private final int id;
    private final int arrivalTime;
    private Integer queuePosition;

    /**
     * Initializes a new User instance.
     *
     * @param id the id of the user
     * @param arrivalTime the arrival time of the user
     */
    public User(int id, int arrivalTime) {
        this.id = id;
        this.arrivalTime = arrivalTime;
    }

    public int getId() {
        return id;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    /**
     * Returns the queue position of the user.
     *
     * @return the queue position of the user
     */
    public Integer getQueuePosition() {
        return queuePosition;
    }

    /**
     * Sets the queue position of the user.
     *
     * @param queuePosition the queue position to be set
     */
    public void setQueuePosition(Integer queuePosition) {
        this.queuePosition = queuePosition;
    }

    @Override
    public void run() {
        try {
            Random random = new Random();
            int randomNumber = random.nextInt(3000);
            QueueService.attemptPurchase(this, randomNumber);
        } catch (InterruptedException e) {
            throw new RuntimeException("Sorry, something happen");
        }
    }
}
