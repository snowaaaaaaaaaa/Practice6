// CommandQueue.java
package com.mycompany.ex02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class CommandQueue {
    private static final ExecutorService executor = Executors.newFixedThreadPool(5);
    private static final LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();

    public static void addCommand(Runnable command) {
        queue.add(command);
    }

    public static void executeCommands() {
        while (!queue.isEmpty()) {
            Runnable command = queue.poll();
            executor.execute(command);
        }
    }
}
