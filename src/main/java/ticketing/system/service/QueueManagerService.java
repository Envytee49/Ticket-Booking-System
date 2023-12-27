package ticketing.system.service;

import ticketing.system.model.User;

import java.util.Collections;
import java.util.List;

public class QueueManagerService {
    private final WaitingRoomService waitingRoomService;

    /**
     * Initializes a new QueueManagerService instance.
     *
     * @param waitingRoomService the service to manage the waiting room
     */
    public QueueManagerService(WaitingRoomService waitingRoomService) {
        this.waitingRoomService = waitingRoomService;
    }

    /**
     * Manages the queue by setting the queue position for each user in the waiting room.
     */
    public void manageQueue() {
        List<User> users = waitingRoomService.getWaitingRoom();
        Collections.shuffle(WaitingRoomService.queuePosition);
        for (User user : users) {
            int queuePosition = calculateQueuePosition(user);
            user.setQueuePosition(queuePosition);
        }
    }

    /**
     * Calculates the queue position for the given user.
     *
     * @param user user in the waiting room
     * @return the queue position for the user
     */
    private int calculateQueuePosition(User user) {
        return WaitingRoomService.queuePosition.get(user.getId());
    }
}


