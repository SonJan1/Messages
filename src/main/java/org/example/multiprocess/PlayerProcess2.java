package org.example.multiprocess;

import java.io.*;

/**
 * The PlayerProcess2 class simulates a player in a separate Java process.
 * It receives messages, appends a reply, and sends them back.
 */
public class PlayerProcess2 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

            for (int i = 0; i < 10; i++) {
                String message = reader.readLine();
                System.out.println("Process2 received: " + message);
                writer.write(message + " [reply from Process2]\n");
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}