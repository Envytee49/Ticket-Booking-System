import ticketing.system.model.Ticket;
import ticketing.system.model.User;
import ticketing.system.service.QueueManagerService;
import ticketing.system.service.QueueService;
import ticketing.system.service.WaitingRoomService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Test {
//    @org.junit.Test
//    public void testProgress() {
//        // Arrange
//        int acceptableRange = 100;
//        WaitingRoomService waitingRoomService = new WaitingRoomService();
//        QueueManagerService queueManagerService = new QueueManagerService(waitingRoomService, acceptableRange);
//        List<Ticket> tickets = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            tickets.add(new Ticket(i));
//        }
//        QueueService queueService = new QueueService(waitingRoomService, tickets);
//
//        // Act
//        for (int i = 0; i < 15; i++) {
//            waitingRoomService.addUser(new User(i, 0));
//        }
//        queueManagerService.manageQueue();
//        queueService.processQueue();
//
//        // Assert
//        assertEquals(0, queueService.getTickets().size());
//    }
//
//    @org.junit.Test
//    public void testMutualExclusion() {
//        // Arrange
//        int acceptableRange = 100;
//        WaitingRoomService waitingRoomService = new WaitingRoomService();
//        QueueManagerService queueManagerService = new QueueManagerService(waitingRoomService, acceptableRange);
//        List<Ticket> tickets = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            tickets.add(new Ticket(i));
//        }
//        QueueService queueService = new QueueService(waitingRoomService, tickets);
//
//        // Act & Assert
////        assertDoesNotThrow(() -> {
////            for (int i = 0; i < 15; i++) {
////                waitingRoomService.addUser(new User(i, 0));
////            }
////            queueManagerService.manageQueue();
////            queueService.processQueue();
////        });
//    }
//
//    @org.junit.Test
//    public void testNoStarvation() {
//        // Arrange
//        int acceptableRange = 100;
//        WaitingRoomService waitingRoomService = new WaitingRoomService();
//        QueueManagerService queueManagerService = new QueueManagerService(waitingRoomService, acceptableRange);
//        List<Ticket> tickets = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            tickets.add(new Ticket(i));
//        }
//        QueueService queueService = new QueueService(waitingRoomService, tickets);
//
//        // Act
//        for (int i = 0; i < 15; i++) {
//            waitingRoomService.addUser(new User(i, 0));
//        }
//        queueManagerService.manageQueue();
//        queueService.processQueue();
//
//        // Assert
//        assertEquals(5, waitingRoomService.getWaitingRoom().size());
//    }
//
//    @org.junit.Test
//    public void testFairness() {
//        // Arrange
//        int acceptableRange = 100;
//        WaitingRoomService waitingRoomService = new WaitingRoomService();
//        QueueManagerService queueManagerService = new QueueManagerService(waitingRoomService, acceptableRange);
//        List<Ticket> tickets = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            tickets.add(new Ticket(i));
//        }
//        QueueService queueService = new QueueService(waitingRoomService, tickets);
//
//        // Act
//        for (int i = 0; i < 10; i++) {
//            waitingRoomService.addUser(new User(i, 0));
//        }
//        queueManagerService.manageQueue();
//
//        // Assert
//        for (User user : waitingRoomService.getWaitingRoom()) {
//            assertTrue(Math.abs(user.getQueuePosition() - waitingRoomService.getWaitingRoom().size()) <= acceptableRange);
//        }
//    }
}
