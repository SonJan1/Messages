package org.example.multiprocess;

import java.io.IOException;

/**
 * The MainMultiProcess class is responsible for starting two separate Java processes
 * for PlayerProcess1 and PlayerProcess2, enabling them to communicate via IPC.
 */
public class MainMultiProcess {
    public static void main(String[] args) {
        try {
            Process process1 = new ProcessBuilder("java", "-cp", "target/classes", "com.example.multiprocess.PlayerProcess1").start();
            Process process2 = new ProcessBuilder("java", "-cp", "target/classes", "com.example.multiprocess.PlayerProcess2").start();

            process1.waitFor();
            process2.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}