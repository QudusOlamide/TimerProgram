/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package stopwatchnottimer;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author h
 */
public class StopwatchNotTimer {
    static int interval;
    static Timer timer;
    static boolean paused = false;

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      Scanner sc = new Scanner(System.in);
        System.out.print("Input seconds => : ");
        String secs = sc.nextLine();
        interval = Integer.parseInt(secs);
        System.out.println("Countdown time set to " + secs + " seconds.");
        startTimer();
        while (true) {
            System.out.println("\nCommands: 'pause', 'resume', 'exit'");
            String command = sc.nextLine().trim().toLowerCase();
            switch (command) {
                case "pause":
                    pauseTimer();
                    break;
                case "resume":
                    resumeTimer();
                    break;
                case "exit":
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
            }
    }
    
}
     private static void startTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                if (!paused) {
                    System.out.println(setInterval());
                }
            }
        }, 1000, 1000);
    }

    private static void pauseTimer() {
        if (!paused) {
            paused = true;
            System.out.println("Timer paused.");
        } else {
            System.out.println("Timer is already paused.");
        }
    }

    private static void resumeTimer() {
        if (paused) {
            paused = false;
            System.out.println("Timer resumed.");
        } else {
            System.out.println("Timer is already running.");
        }
    }

    private static final int setInterval() {
        if (interval == 1) {
            timer.cancel();
            System.out.println("Time's up!");
        }
        return --interval;
                }
}
        

