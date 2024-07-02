package org.example.singleprocess;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * The Player class is responsible for sending and receiving messages.
 * It keeps track of the number of messages sent and received and ensures
 * the program stops after the initiator has sent and received 10 messages.
 */
public class Player implements Runnable {
    private static final int MAX_MESSAGES = 10;
    private final String name;
    private Player otherPlayer;
    private final AtomicInteger messageCounter = new AtomicInteger(0);

    public Player(String name, Player otherPlayer) {
        this.name = name;
        this.otherPlayer = otherPlayer;
    }

    public void setOtherPlayer(Player otherPlayer) {
        this.otherPlayer = otherPlayer;
    }

    @Override
    public void run() {
        try {
            if (name.equals("initiator")) {
                sendMessage("Message 1 from initiator");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void sendMessage(String message) throws InterruptedException {
        if (messageCounter.get() < MAX_MESSAGES) {
            System.out.println(name + " sending: " + message);
            otherPlayer.receiveMessage(message + " [count: " + messageCounter.incrementAndGet() + "]");
        }
    }

    public synchronized void receiveMessage(String message) throws InterruptedException {
        System.out.println(name + " received: " + message);
        if (messageCounter.get() < MAX_MESSAGES) {
            Thread.sleep(1000);
            sendMessage(message + " [reply]");
        }
    }
}
