package org.example.singleprocess;

/**
 * The MainSingleProcess class is responsible for initializing and starting
 * two Player instances within the same Java process.
 */
public class MainSingleProcess {
    public static void main(String[] args) {
        Player player1 = new Player("initiator", null);
        Player player2 = new Player("receiver", player1);
        player1.setOtherPlayer(player2);

        Thread player1Thread = new Thread(player1);
        Thread player2Thread = new Thread(player2);

        player1Thread.start();
        player2Thread.start();

        try {
            player1Thread.join();
            player2Thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}