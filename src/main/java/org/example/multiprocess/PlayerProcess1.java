package org.example.multiprocess;

import java.io.*;

/**
 * The PlayerProcess1 class simulates a player in a separate Java process.
 * It sends and receives messages, appending a reply and a message counter.
 */
public class PlayerProcess1 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

            for (int i = 0; i < 10; i++) {
                writer.write("Message " + (i + 1) + " from Process1\n");
                writer.flush();
                String response = reader.readLine();
                System.out.println("Process1 received: " + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}